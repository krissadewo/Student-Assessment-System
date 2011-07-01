/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.matakuliah.dosen;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.dosen.Dosen;
import com.os.sipm.model.matakuliah.dosen.MataKuliahDosen;
import com.os.sipm.model.matakuliah.dosen.MataKuliahDosenService;
import com.os.sipm.model.matakuliah.MataKuliah;
import com.os.sipm.model.matakuliah.MataKuliahService;
import com.os.sipm.utils.OsUtils;
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

    private Textbox txtboxNip;
    private Textbox txtboxNama;
    private Intbox txtboxUts;
    private Intbox txtboxUas;
    private Intbox txtboxKuis1;
    private Intbox txtboxKuis2;
    private Intbox txtboxAbsensi;
    private Intbox txtboxResponsi;
    private Intbox txtboxTahun;
    private Intbox txtboxSemester;
    private Textbox txtboxJadwal;
    private Textbox txtboxKelas;
    private Combobox cmbboxMataKuliah;
    @Autowired
    private MataKuliahDosenService mataKuliahDosenService;
    @Autowired
    private MataKuliahService mataKuliahService;
    private MataKuliahDosen selectedMataKuliahDosen;
    private List<MataKuliah> mataKuliahs;
    private Logger logger = Logger.getLogger(this.getClass());
    private Dosen selectedDosen;

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        selectedDosen = (Dosen) OsUtils.getActiveUserBySession(session, "dosen");
        logger.info("Getting session dosen with nip dosen " + selectedDosen.getNip());
        initComponent();
    }

    private void initComponent() {
        loadDataMataKuliah();
        // Get param from parent window if exist
        txtboxNip.setText(selectedDosen.getNip());
        txtboxNama.setText(selectedDosen.getNama());
        selectedMataKuliahDosen = (MataKuliahDosen) Executions.getCurrent().getArg().get("selectedDosenMataKuliah");
        if (selectedMataKuliahDosen != null) {
            txtboxUts.setValue(selectedMataKuliahDosen.getUts());
            txtboxUas.setValue(selectedMataKuliahDosen.getUas());
            txtboxKuis1.setValue(selectedMataKuliahDosen.getKuis1());
            txtboxKuis2.setValue(selectedMataKuliahDosen.getKuis2());
            txtboxAbsensi.setValue(selectedMataKuliahDosen.getAbsensi());
            txtboxResponsi.setValue(selectedMataKuliahDosen.getResponsi());
            txtboxSemester.setValue(selectedMataKuliahDosen.getSemester());
            txtboxTahun.setValue(selectedMataKuliahDosen.getTahun());
            txtboxJadwal.setValue(selectedMataKuliahDosen.getJadwal());
            txtboxKelas.setValue(selectedMataKuliahDosen.getKelas());
            cmbboxMataKuliah.setSelectedIndex(SipmUtils.getSelectedMataKuliah(mataKuliahs, selectedMataKuliahDosen.getMataKuliah().getNama()));
        }
    }

    private void loadDataMataKuliah() {
        cmbboxMataKuliah.getItems().clear();
        mataKuliahs = mataKuliahService.getAll(null);
        for (MataKuliah mataKuliah : mataKuliahs) {
            Comboitem comboitem = new Comboitem();
            comboitem.setValue(Integer.valueOf(mataKuliah.getId()));
            comboitem.setLabel(mataKuliah.getNama());
            cmbboxMataKuliah.appendChild(comboitem);
        }
        cmbboxMataKuliah.setSelectedIndex(0);
    }

    private void componentClear() {
        txtboxNip.setValue("");
        txtboxNama.setValue("");
        txtboxUts.setValue(0);
        txtboxUas.setValue(0);
        txtboxKuis1.setValue(0);
        txtboxKuis2.setValue(0);
        txtboxAbsensi.setValue(0);
        txtboxResponsi.setValue(0);
        txtboxSemester.setValue(0);
        txtboxTahun.setValue(0);
        txtboxJadwal.setValue("");
        txtboxKelas.setValue("");
        cmbboxMataKuliah.setSelectedIndex(0);
    }

    public void onClick$btnSave(Event event) {
        MataKuliahDosen mataKuliahDosen = new MataKuliahDosen();
        if (txtboxNip.getText().isEmpty()) {
            throw new WrongValueException(txtboxNip, MessagesHelper.dataEmpty());
        }
        if (txtboxNama.getText().isEmpty()) {
            throw new WrongValueException(txtboxNama, MessagesHelper.dataEmpty());
        }
        if (selectedMataKuliahDosen != null) {
            mataKuliahDosen.setId(selectedMataKuliahDosen.getId());
        }
        MataKuliah mataKuliah = new MataKuliah();
        mataKuliah.setId(Integer.valueOf(cmbboxMataKuliah.getSelectedItem().getValue().toString()));
        mataKuliahDosen.setDosen(selectedDosen);
        mataKuliahDosen.setMataKuliah(mataKuliah);
        mataKuliahDosen.setUts(txtboxUts.getValue());
        mataKuliahDosen.setUas(txtboxUas.getValue());
        mataKuliahDosen.setKuis1(txtboxKuis1.getValue());
        mataKuliahDosen.setKuis2(txtboxKuis2.getValue());
        mataKuliahDosen.setAbsensi(txtboxAbsensi.getValue());
        mataKuliahDosen.setResponsi(txtboxResponsi.getValue());
        mataKuliahDosen.setSemester(txtboxSemester.getValue());
        mataKuliahDosen.setTahun(txtboxTahun.getValue());
        mataKuliahDosen.setJadwal(txtboxJadwal.getValue());
        mataKuliahDosen.setKelas(txtboxKelas.getValue());
        if (mataKuliahDosenService.saveOrUpdate(mataKuliahDosen) == 1) {
            this.componentClear();
            MessagesHelper.saveSuccess();
        } else {
            MessagesHelper.saveFailed();
        }
        //Send data to parent window
        if (mataKuliahDosen != null) {
            logger.info("GO TO HERE");
            Map<Object, Object> params = new HashMap<Object, Object>();
            params.put("nip", selectedDosen.getNip());
            params.put("id_matakuliah", mataKuliah.getId());
            params.put("kelas", mataKuliahDosen.getKelas());
            List<MataKuliahDosen> mataKuliahDosens = mataKuliahDosenService.getByNip(params);
            self.setAttribute("mataKuliahDosens", mataKuliahDosens);
        }
        self.detach();
    }
}
