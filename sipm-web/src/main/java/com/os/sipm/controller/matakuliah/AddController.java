/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.matakuliah;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.jenisnilai.JenisNilai;
import com.os.sipm.model.jenisnilai.JenisNilaiService;
import com.os.sipm.model.matakuliah.MataKuliah;
import com.os.sipm.model.matakuliah.MataKuliahService;
import com.os.sipm.utils.SipmUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

/**
 * 
 * @author KrisSadewo
 */
public class AddController extends GenericForwardComposer {

    private Textbox txtboxKode;
    private Textbox txtboxNama;
    private Intbox txtboxSks;
    private Combobox cmbboxJenisMataKuliah;
    @Autowired
    private MataKuliahService mataKuliahService;
    @Autowired
    private JenisNilaiService jenisNilaiService;
    private MataKuliah selectedMataKuliah;
    private List<JenisNilai> jenisNilais;
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        this.initComponent();
    }

    private void initComponent() {
        loadDataJenisNilai();
        // Get param from parent window if exist
        selectedMataKuliah = (MataKuliah) Executions.getCurrent().getArg().get("selectedMataKuliah");
        if (selectedMataKuliah != null) {
            txtboxKode.setText(selectedMataKuliah.getKode());
            txtboxNama.setText(selectedMataKuliah.getNama());
            txtboxSks.setText(String.valueOf(selectedMataKuliah.getSks()));
            cmbboxJenisMataKuliah.setSelectedIndex(SipmUtils.getSelectedJenisNilai(jenisNilais, selectedMataKuliah.getJenisNilai().getNamaJenis()));
        }
    }

    private void loadDataJenisNilai() {
        cmbboxJenisMataKuliah.getItems().clear();
        jenisNilais = jenisNilaiService.getAll();
        for (JenisNilai jenisNilai : jenisNilais) {
            Comboitem comboitem = new Comboitem();
            comboitem.setValue(Integer.valueOf(jenisNilai.getId()));
            comboitem.setLabel(jenisNilai.getNamaJenis());
            cmbboxJenisMataKuliah.appendChild(comboitem);
        }
        cmbboxJenisMataKuliah.setSelectedIndex(0);
    }

    private void componentClear() {
        txtboxKode.setValue("");
        txtboxNama.setValue("");
        txtboxSks.setValue(0);
        cmbboxJenisMataKuliah.setSelectedIndex(0);
    }

    public void onClick$btnSave(Event event) {
        MataKuliah mataKuliah = new MataKuliah();
        if (txtboxKode.getText().isEmpty()) {
            throw new WrongValueException(txtboxKode, MessagesHelper.dataEmpty());
        }
        if (txtboxNama.getText().isEmpty()) {
            throw new WrongValueException(txtboxNama, MessagesHelper.dataEmpty());
        }
        if (selectedMataKuliah != null) {
            mataKuliah.setId(selectedMataKuliah.getId());
        }
        mataKuliah.setKode(txtboxKode.getText());
        mataKuliah.setNama(txtboxNama.getText());
        mataKuliah.setSks(Integer.valueOf(txtboxSks.getValue()));

        JenisNilai jenisNilai = new JenisNilai();
        jenisNilai.setId(Integer.valueOf(cmbboxJenisMataKuliah.getSelectedItem().getValue().toString()));
        mataKuliah.setJenisNilai(jenisNilai);

        if (mataKuliahService.saveOrUpdate(mataKuliah) == 1) {
            this.componentClear();
            MessagesHelper.saveSuccess();
        } else {
            MessagesHelper.saveFailed();
        }
        // Send data pribadi to parent window
        if (mataKuliah != null) {
            Map<Object, Object> params = new HashMap<Object, Object>();
            params.put("kode", mataKuliah.getKode());           
            List<MataKuliah> mataKuliahs = mataKuliahService.getByKode(params);
            self.setAttribute("mataKuliahs", mataKuliahs);
        }
        self.detach();
    }
}
