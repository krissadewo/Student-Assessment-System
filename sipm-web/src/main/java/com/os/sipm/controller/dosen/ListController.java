/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.dosen;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.dosen.Dosen;
import com.os.sipm.model.dosen.DosenService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.zkoss.zul.Window;
import org.zkoss.zul.event.PagingEvent;

/**
 *
 * @author kris
 */
public class ListController extends GenericForwardComposer {

    @Autowired
    private DosenService dosenService;
    private Listbox listboxData;
    private Map<Object, Object> params;
    private final int LIMIT = 15;
    private List<Dosen> dosens;
    private Paging paging;
    private Dosen selectedDosen;
    private boolean isSearchByNama;
    private boolean isSearchByNip;
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        init();
    }

    private void init() {
        params = new HashMap<Object, Object>();
        loadDataDosen(0);
    }

    private void generateDataDosen(final int cursor) {
        int no = cursor + 1;
        params.put("limit", LIMIT);
        params.put("cursor", cursor);
        dosens = dosenService.getAll(params);
        generateLisboxData(no);
    }

    public void loadDataDosen(int cursor) {
        paging.setTotalSize(dosenService.countAllDosen());
        // Show Listbox on the first
        generateDataDosen(cursor);
        paging.addEventListener("onPaging", new EventListener() {

            @Override
            public void onEvent(Event event) throws Exception {
                PagingEvent pagingEvent = (PagingEvent) event;
                int activePage = pagingEvent.getActivePage();
                int cursor = activePage * LIMIT;
                // Redraw current paging
                generateDataDosen(cursor);
            }
        });
    }

    private void generateDataDosenByNip(final Integer cursor, Map<Object, Object> params) {
        int no = cursor + 1;
        params.put("limit", LIMIT);
        params.put("cursor", cursor);
        dosens = dosenService.getByNip(params);
        generateLisboxData(no);
    }

    public void loadDataDosenByNip(int cursor, final Map<Object, Object> params) {
        paging.setTotalSize(dosenService.countAllDosenByNip(params));
        // Show Listbox on the first
        generateDataDosenByNip(cursor, params);
        paging.addEventListener("onPaging", new EventListener() {

            @Override
            public void onEvent(Event event) throws Exception {
                PagingEvent pagingEvent = (PagingEvent) event;
                int activePage = pagingEvent.getActivePage();
                int cursor = activePage * LIMIT;
                // Redraw current paging
                generateDataDosenByNip(cursor, params);
            }
        });
    }

    private void generateDataDosenByNama(final Integer cursor, Map<Object, Object> params) {
        int no = cursor + 1;
        params.put("limit", LIMIT);
        params.put("cursor", cursor);
        dosens = dosenService.getByName(params);
        generateLisboxData(no);
    }

    public void loadDataDosenByNama(int cursor, final Map<Object, Object> params) {
        paging.setTotalSize(dosenService.countAllDosenByNama(params));
        // Show Listbox on the first
        generateDataDosenByNama(cursor, params);
        paging.addEventListener("onPaging", new EventListener() {

            @Override
            public void onEvent(Event event) throws Exception {
                PagingEvent pagingEvent = (PagingEvent) event;
                int activePage = pagingEvent.getActivePage();
                int cursor = activePage * LIMIT;
                // Redraw current paging
                generateDataDosenByNama(cursor, params);
            }
        });
    }

    public Listbox generateLisboxData(int no) {
        listboxData.getItems().clear();
        for (final Dosen dosen : dosens) {
            Listitem listitem = new Listitem();
            listitem.appendChild(new Listcell(no + ""));
            listitem.appendChild(new Listcell(dosen.getNip()));
            listitem.appendChild(new Listcell(dosen.getNama()));
            listitem.addEventListener("onClick", new EventListener() {

                @Override
                public void onEvent(Event event) throws Exception {
                    selectedDosen = dosens.get(listboxData.getSelectedIndex());
                }
            });
            no++;
            listboxData.appendChild(listitem);
        }
        return listboxData;
    }

    public void onClick$btnAdd(Event event) throws InterruptedException {
        Window window = (Window) Executions.createComponents("/views/dosen/add.zul", this.self, null);
        window.doModal();
        dosens = (List<Dosen>) window.getAttribute("dosens");
        if (dosens != null) {
            this.generateLisboxData(1);
        }
    }

    public void onClick$btnEdit(Event event) throws InterruptedException {
        if (listboxData.getSelectedIndex() < 0) {
            MessagesHelper.editEmpty();
        } else {
            // Send param to modal window
            param.put("selectedDosen", selectedDosen);
            Window window = (Window) Executions.createComponents("/views/dosen/add.zul", this.self, param);
            window.doModal();
            dosens = (List<Dosen>) window.getAttribute("dosens");
            if (dosens != null) {
                this.generateLisboxData(1);
            }
        }
    }

    public void onClick$btnSearch(Event event) throws InterruptedException {
        Window window = (Window) Executions.createComponents("/views/dosen/search.zul", this.self, null);
        window.doModal();
        params = (Map) window.getAttribute("params");
        if (params != null) {
            if (params.containsKey("nip")) {
                paging.setTotalSize(0);
                isSearchByNip = true;
                loadDataDosenByNip(0, params);
            } else if (params.containsKey("nama")) {
                paging.setTotalSize(0);
                isSearchByNama = true;
                loadDataDosenByNama(0, params);
            }
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
                            if (dosenService.delete(selectedDosen) == 1) {
                                MessagesHelper.deleteSuccess();
                                // Remove data from listbox with unique id from
                                // selectedIndex
                                dosens.remove(listboxData.getSelectedIndex());
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
        if (isSearchByNip) {
            loadDataDosenByNip(0, params);
        } else if (isSearchByNama) {
            loadDataDosenByNama(0, params);
        } else {
            loadDataDosen(paging.getActivePage() * LIMIT);
        }
    }
}
