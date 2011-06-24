package com.os.sipm.model.menu;

import com.os.sipm.model.menu.Menu;
import java.io.Serializable;

/**
 * hris-demo
 * 
 * @author kris Apr 17, 2011
 */
public class MenuItem implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 237982067171117270L;
    private int id;
    private String menuItemName;
    private Menu menu;
    private String imagePath;
    private String viewPath;
    private int sequance;

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getSequance() {
        return sequance;
    }

    public void setSequance(int sequance) {
        this.sequance = sequance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
