/**
 * 
 */
package com.os.sipm.controller.general;

import com.os.sipm.model.menu.Menu;
import com.os.sipm.model.menu.MenuItem;
import com.os.sipm.model.menu.MenuItemService;
import com.os.sipm.model.menu.MenuService;
import com.os.sipm.utils.LogUtils;
import java.util.List;
import javax.servlet.ServletContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.West;

/**
 * @author kris Apr 22, 2011
 */
@Controller
public class IndexController extends GenericForwardComposer {

    private MenuService menuService;
    @Autowired
    private MenuItemService menuItemService;
    private Div content;
    private Div divMainMenu;
    private Div divMenuItem;
    private List<Menu> menus;
    private List<MenuItem> menuItems;
    private West westContent;
    private Session session;
    private Logger logger = Logger.getLogger(this.getClass());

    public IndexController() {
        createMenu();
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initComponent();
    }

    private void initComponent() {
        createMenuItem();
    }

    private void createMenu() {
        session = Sessions.getCurrent();
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setServletContext((ServletContext) session.getWebApp().getNativeContext());
        context.refresh();
        menuService = context.getBean(MenuService.class);
        this.menus = menuService.getAll();
    }

    private void createMenuItem() {
        this.menuItems = menuItemService.getAll();
        boolean visible = true;
        int sequence = 0;
        for (final Menu menu : menus) {
            final Panel panel = new Panel();
            Panelchildren panelchildren = new Panelchildren();
            Listbox listbox = new Listbox();
            for (final MenuItem menuItem : menuItems) {
                if (menu.getMenuName().equalsIgnoreCase(menuItem.getMenu().getMenuName())) {
                    Listitem listitem = new Listitem();
                    Listcell listcell = new Listcell();
                    listcell.setImage(menuItem.getImagePath());
                    listcell.setLabel(Labels.getLabel(menuItem.getMenuItemName()));
                    LogUtils.logPreviousCommand(logger);
                    listitem.appendChild(listcell);
                    listitem.addEventListener("onClick", new EventListener() {

                        @Override
                        public void onEvent(Event arg0) throws Exception {
                            content.getChildren().clear();
                            Executions.createComponents(menuItem.getViewPath(), content, null);
                        }
                    });
                    listbox.setOddRowSclass("non-odd");
                    listbox.setStyle("border:none;");
                    listbox.appendChild(listitem);
                }
            }
            panelchildren.appendChild(listbox);
            panel.appendChild(panelchildren);
            // Set visible for first panel
            panel.setVisible(visible);
            divMenuItem.appendChild(panel);
            // Set label for each panel, because the properties language
            // can't set the label on event doBeforeComposeChildren
            Button button = (Button) divMainMenu.getChildren().get(sequence);
            button.setLabel(Labels.getLabel(menu.getMenuName()));
            // Set class for first panel
            if (visible) {
                westContent.setTitle(Labels.getLabel(menu.getMenuName()));
                button.setSclass("os-seld");
            }
            // Adding event for each panel
            button.addEventListener("onClick", new EventListener() {

                @Override
                public void onEvent(Event event) throws Exception {
                    divMenuItem.getChildren().clear();
                    divMenuItem.appendChild(panel);
                    westContent.setTitle(Labels.getLabel(menu.getMenuName()));
                    panel.setVisible(true);
                }
            });
            visible = false;
            sequence++;
        }
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
