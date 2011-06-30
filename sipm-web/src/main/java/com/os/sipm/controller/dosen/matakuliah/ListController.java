/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.dosen.matakuliah;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.dosen.matakuliah.DosenMataKuliah;
import com.os.sipm.model.dosen.matakuliah.DosenMataKuliahService;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;
import org.zkoss.zul.event.PagingEvent;

/**
 *
 * @author KrisSadewo
 */
public class ListController extends GenericForwardComposer {

    @Autowired
    private DosenMataKuliahService dosenMataKuliahService;
    private Logger logger = Logger.getLogger(this.getClass());
    private Listbox listboxData;
    private List<DosenMataKuliah> dosenMataKuliahs;
    private DosenMataKuliah selectedDosenMataKuliah;
    private Paging paging;
    private final int LIMIT = 2;

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        this.init();
    }

    private void init() {
        loadDataMahasiswa(0, param);
    }

    private void generateDataMahasiswa(final int cursor, Map<Object, Object> paramValues) {
        int no = cursor + 1;
        paramValues.put("limit", LIMIT);
        paramValues.put("cursor", cursor);
        if (paramValues.containsKey("nip")) {
            paging.setTotalSize(dosenMataKuliahService.countAllDosenMataKuliahByNip(paramValues));
            dosenMataKuliahs = dosenMataKuliahService.getByNip(paramValues);
        } else if (paramValues.containsKey("nama")) {
            paging.setTotalSize(dosenMataKuliahService.countAllDosenMataKuliahByName(paramValues));
            dosenMataKuliahs = dosenMataKuliahService.getByName(paramValues);
        } else {
            paging.setTotalSize(dosenMataKuliahService.countAllDosenMataKuliah());
            dosenMataKuliahs = dosenMataKuliahService.getAll(paramValues);
        }
        generateLisboxData(no);
    }

    public void loadDataMahasiswa(int cursor, final Map<Object, Object> paramValues) {
        // Show Listbox on the first
        generateDataMahasiswa(cursor, paramValues);
        paging.addEventListener("onPaging", new EventListener() {

            @Override
            public void onEvent(Event event) throws Exception {
                PagingEvent pagingEvent = (PagingEvent) event;
                int activePage = pagingEvent.getActivePage();
                int cursor = activePage * LIMIT;
                // Redraw current paging
                generateDataMahasiswa(cursor, paramValues);
            }
        });
    }

    public void generateLisboxData(int no) {
        listboxData.getItems().clear();
        for (final DosenMataKuliah dosenMataKuliah : dosenMataKuliahs) {
            Listitem listitem = new Listitem();
            listitem.appendChild(new Listcell(no + ""));
            listitem.appendChild(new Listcell(dosenMataKuliah.getDosen().getNama()));
            listitem.appendChild(new Listcell(dosenMataKuliah.getMataKuliah().getNama()));
            listitem.appendChild(new Listcell(String.valueOf(dosenMataKuliah.getMataKuliah().getSks())));
            listitem.addEventListener("onClick", new EventListener() {

                @Override
                public void onEvent(Event event) throws Exception {
                    selectedDosenMataKuliah = dosenMataKuliahs.get(listboxData.getSelectedIndex());
                }
            });

            Toolbarbutton toolbarbutton = new Toolbarbutton();
            toolbarbutton.setLabel(Labels.getLabel("toolbarBtnDetail"));
            toolbarbutton.setImage("img/");
            toolbarbutton.addEventListener("onClick", new EventListener() {

                @Override
                public void onEvent(Event event) throws Exception {
                    //delete(bentukUsaha.getId());
                }
            });
            Listcell listcellPinjaman = new Listcell();
            listcellPinjaman.appendChild(toolbarbutton);
            listitem.appendChild(listcellPinjaman);
            no++;
            listboxData.appendChild(listitem);
        }
    }

    public void onClick$btnAdd(Event event) throws InterruptedException {
        Window window = (Window) Executions.createComponents("/views/dosenmatakuliah/add.zul", this.self, null);
        window.doModal();
        dosenMataKuliahs = (List<DosenMataKuliah>) window.getAttribute("dosenMataKuliahs");
        if (dosenMataKuliahs != null) {
            this.generateLisboxData(1);
        }
    }

    public void onClick$btnEdit(Event event) throws InterruptedException {
        if (listboxData.getSelectedIndex() < 0) {
            MessagesHelper.editEmpty();
        } else {
            // Send param to modal window
            param.put("selectedMahasiswa", selectedDosenMataKuliah);
            Window window = (Window) Executions.createComponents("/views/dosenmatakuliah/add.zul", this.self, param);
            window.doModal();
            dosenMataKuliahs = (List<DosenMataKuliah>) window.getAttribute("dosenMataKuliahs");
            if (dosenMataKuliahs != null) {
                this.generateLisboxData(1);
            }
        }
    }

    public void onClick$btnSearch(Event event) throws InterruptedException {
        Window window = (Window) Executions.createComponents("/views/dosenmatakuliah/search.zul", this.self, null);
        window.doModal();
        param = (Map) window.getAttribute("params");
        if (param != null) {
            paging.setTotalSize(0);
            loadDataMahasiswa(0, param);
        }
    }

    public void onClick$btnDelete(final Event event) throws InterruptedException {
        if (listboxData.getSelectedIndex() < 0) {
            MessagesHelper.deleteEmpty();
        } else {
            Messagebox.show(MessagesHelper.comfirmationDelete(), "Confirm", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION, new EventListener() {

                public void onEvent(Event evt) {
                    switch (((Integer) evt.getData()).intValue()) {
                        case Messagebox.YES:
                            if (dosenMataKuliahService.delete(selectedDosenMataKuliah) == 1) {
                                MessagesHelper.deleteSuccess();
                                // Remove data from listbox with unique id from
                                // selectedIndex
                                dosenMataKuliahs.remove(listboxData.getSelectedIndex());
                                onClick$btnRefresh(event);
                            } else {
                                MessagesHelper.deleteFailed();
                            }
                            break;
                        case Messagebox.NO:
                            break;
                    }
                }
            });
        }
    }

    public void onClick$btnRefresh(Event event) {
        loadDataMahasiswa(paging.getActivePage() * LIMIT, param);
    }
}
