/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.matakuliah;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.matakuliah.MataKuliah;
import com.os.sipm.model.matakuliah.MataKuliahService;
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
    private MataKuliahService mataKuliahService;
    private Listbox listboxData; 
    private final int LIMIT = 15;
    private List<MataKuliah> mataKuliahs;
    private Paging paging;
    private MataKuliah selectedMataKuliah;   
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        init();
    }

    private void init() {
        loadDataMataKuliah(0, param);
    }

    private void generateDataMataKuliah(final int cursor, Map<Object, Object> paramValues) {
        int no = cursor + 1;
        paramValues.put("limit", LIMIT);
        paramValues.put("cursor", cursor);
        if (paramValues.containsKey("kode")) {
            paging.setTotalSize(mataKuliahService.countAllMataKuliahByKode(paramValues));
            mataKuliahs = mataKuliahService.getByKode(paramValues);
        } else if (paramValues.containsKey("nama")) {
            paging.setTotalSize(mataKuliahService.countAllMataKuliahByNama(paramValues));
            mataKuliahs = mataKuliahService.getByName(paramValues);
        } else {
            paging.setTotalSize(mataKuliahService.countAllMataKuliah());
            mataKuliahs = mataKuliahService.getAll(paramValues);
        }
        generateLisboxData(no);
    }

    public void loadDataMataKuliah(final int cursor, final Map<Object, Object> paramValues) {
        // Show Listbox on the first
        generateDataMataKuliah(cursor, paramValues);
        paging.addEventListener("onPaging", new EventListener() {

            @Override
            public void onEvent(Event event) throws Exception {
                PagingEvent pagingEvent = (PagingEvent) event;
                int activePage = pagingEvent.getActivePage();
                int cursor = activePage * LIMIT;
                // Redraw current paging
                generateDataMataKuliah(cursor, paramValues);
            }
        });
    }

    public void generateLisboxData(int no) {
        listboxData.getItems().clear();
        for (final MataKuliah mataKuliah : mataKuliahs) {
            Listitem listitem = new Listitem();
            listitem.appendChild(new Listcell(no + ""));
            listitem.appendChild(new Listcell(mataKuliah.getKode()));
            listitem.appendChild(new Listcell(mataKuliah.getNama()));
            listitem.appendChild(new Listcell(String.valueOf(mataKuliah.getSks())));
            listitem.appendChild(new Listcell(mataKuliah.getJenisNilai().getNamaJenis()));
            listitem.addEventListener("onClick", new EventListener() {

                @Override
                public void onEvent(Event event) throws Exception {
                    selectedMataKuliah = mataKuliahs.get(listboxData.getSelectedIndex());
                }
            });
            no++;
            listboxData.appendChild(listitem);
        }
    }

    public void onClick$btnAdd(Event event) throws InterruptedException {
        Window window = (Window) Executions.createComponents("/views/matakuliah/add.zul", this.self, null);
        window.doModal();
        mataKuliahs = (List<MataKuliah>) window.getAttribute("mataKuliahs");
        if (mataKuliahs != null) {
            this.generateLisboxData(1);
        }
    }

    public void onClick$btnEdit(Event event) throws InterruptedException {
        if (listboxData.getSelectedIndex() < 0) {
            MessagesHelper.editEmpty();
        } else {
            // Send param to modal window
            param.put("selectedMataKuliah", selectedMataKuliah);
            Window window = (Window) Executions.createComponents("/views/matakuliah/add.zul", this.self, param);
            window.doModal();
            mataKuliahs = (List<MataKuliah>) window.getAttribute("mataKuliahs");
            if (mataKuliahs != null) {
                this.generateLisboxData(1);
            }
        }
    }

    public void onClick$btnSearch(Event event) throws InterruptedException {
        Window window = (Window) Executions.createComponents("/views/matakuliah/search.zul", this.self, null);
        window.doModal();
        param = (Map) window.getAttribute("params");
        if (param != null) {
            paging.setTotalSize(0);
            loadDataMataKuliah(0, param);
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
                            if (mataKuliahService.delete(selectedMataKuliah) == 1) {
                                MessagesHelper.deleteSuccess();
                                // Remove data from listbox with unique id from
                                // selectedIndex
                                mataKuliahs.remove(listboxData.getSelectedIndex());
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
        loadDataMataKuliah(paging.getActivePage() * LIMIT, param);
    }
}
