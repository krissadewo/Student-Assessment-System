/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.mahasiswa;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.mahasiswa.Mahasiswa;
import com.os.sipm.model.mahasiswa.MahasiswaService;
import java.util.HashMap;
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

    private Listbox listboxData;
    private List<Mahasiswa> mahasiswas;
    @Autowired
    private MahasiswaService mahasiswaService;
    private Mahasiswa selectedMahasiswa;
    private Paging paging;
    private final int LIMIT = 2;
    private Map<Object, Object> params;
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        this.init();
    }

    private void init() {
        params = new HashMap<Object, Object>();
        loadDataMahasiswa(0);
    }

    private void generateDataMahasiswa(final int cursor) {
        int no = cursor + 1;
        params.put("limit", LIMIT);
        params.put("cursor", cursor);
        if (params.containsKey("nim")) {
            paging.setTotalSize(mahasiswaService.countAllMahasiswaByNim(params));
            mahasiswas = mahasiswaService.getByNim(params);
        } else if (params.containsKey("nama")) {
            paging.setTotalSize(mahasiswaService.countAllMahasiswaByNama(params));
            mahasiswas = mahasiswaService.getByName(params);
        } else {
            paging.setTotalSize(mahasiswaService.countAllMahasiswa());
            mahasiswas = mahasiswaService.getAll(params);
        }
        generateLisboxData(no);
    }

    public void loadDataMahasiswa(int cursor) {
        // Show Listbox on the first
        generateDataMahasiswa(cursor);
        paging.addEventListener("onPaging", new EventListener() {

            @Override
            public void onEvent(Event event) throws Exception {
                PagingEvent pagingEvent = (PagingEvent) event;
                int activePage = pagingEvent.getActivePage();
                int cursor = activePage * LIMIT;
                // Redraw current paging
                generateDataMahasiswa(cursor);
            }
        });
    }

    public void generateLisboxData(int no) {
        listboxData.getItems().clear();
        for (final Mahasiswa mahasiswa : mahasiswas) {
            Listitem listitem = new Listitem();
            listitem.appendChild(new Listcell(no + ""));
            listitem.appendChild(new Listcell(mahasiswa.getNim()));
            listitem.appendChild(new Listcell(mahasiswa.getNama()));
            listitem.appendChild(new Listcell(mahasiswa.getJurusan().getNama()));
            listitem.addEventListener("onClick", new EventListener() {

                @Override
                public void onEvent(Event event) throws Exception {
                    selectedMahasiswa = mahasiswas.get(listboxData.getSelectedIndex());
                }
            });

            Toolbarbutton toolbarbutton = new Toolbarbutton();
            toolbarbutton.setLabel(Labels.getLabel("toolbarBtnPinjaman"));
            toolbarbutton.setImage("img/");
            toolbarbutton.addEventListener("onClick", new EventListener() {

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
        Window window = (Window) Executions.createComponents("/views/mahasiswa/add.zul", this.self, null);
        window.doModal();
        List<Mahasiswa> mahasiswaTemp = (List<Mahasiswa>) window.getAttribute("mahasiswas");
        if (mahasiswaTemp != null) {
            mahasiswas = mahasiswaTemp;
            this.generateLisboxData(1);
        }
    }

    public void onClick$btnEdit(Event event) throws InterruptedException {
        if (listboxData.getSelectedIndex() < 0) {
            MessagesHelper.editEmpty();
        } else {
            // Send param to modal window
            param.put("selectedMahasiswa", selectedMahasiswa);
            Window window = (Window) Executions.createComponents("/views/mahasiswa/add.zul", this.self, param);
            window.doModal();
            List<Mahasiswa> mahasiswaTemp = (List<Mahasiswa>) window.getAttribute("mahasiswas");
            if (mahasiswaTemp != null) {
                mahasiswas = mahasiswaTemp;
                this.generateLisboxData(1);
            }
        }
    }

    public void onClick$btnSearch(Event event) throws InterruptedException {
        Window window = (Window) Executions.createComponents("/views/mahasiswa/search.zul", this.self, null);
        window.doModal();
        params = (Map) window.getAttribute("params");
        if (params != null) {
            paging.setTotalSize(0);
            loadDataMahasiswa(0);
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
                            if (mahasiswaService.delete(selectedMahasiswa) == 1) {
                                MessagesHelper.deleteSuccess();
                                // Remove data from listbox with unique id from
                                // selectedIndex
                                mahasiswas.remove(listboxData.getSelectedIndex());
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
        loadDataMahasiswa(paging.getActivePage() * LIMIT);
    }
}
