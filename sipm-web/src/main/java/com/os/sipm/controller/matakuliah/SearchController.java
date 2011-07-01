/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.matakuliah;

import com.os.sipm.controller.mahasiswa.*;
import com.os.sipm.model.dosen.Dosen;
import com.os.sipm.model.mahasiswa.Mahasiswa;
import com.os.sipm.model.mahasiswa.MahasiswaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Textbox;

/**
 * 
 * @author KrisSadewo
 */
public class SearchController extends GenericForwardComposer {

    private Textbox txtboxKodeCari;
    private Textbox txtboxNamaCari;
    private Checkbox chkboxKode;
    private Checkbox chkboxNama;

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
    }

    public void onClick$btnCari(Event event) {
        Map params = new HashMap();
        if (!txtboxKodeCari.getValue().isEmpty()) {
            params.put("kode", txtboxKodeCari.getValue() + "%");
        } else if (!txtboxNamaCari.getValue().isEmpty()) {
            params.put("nama", txtboxNamaCari.getValue() + "%");
        }
        self.setAttribute("params", params);
        self.detach();
    }

    public void onClick$chkboxKode(Event event) {
        if (chkboxKode.isChecked()) {
            txtboxKodeCari.setVisible(true);
        } else {
            txtboxKodeCari.setVisible(false);
        }
    }

    public void onClick$chkboxNama(Event event) {
        if (chkboxNama.isChecked()) {
            txtboxNamaCari.setVisible(true);
        } else {
            txtboxNamaCari.setVisible(false);
        }
    }

    public void onClick$btnBatal(Event event) {
        txtboxNamaCari.setValue("");
        txtboxKodeCari.setValue("");
    }
}
