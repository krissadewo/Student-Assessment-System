/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.dosen.matakuliah;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.dosen.Dosen;
import com.os.sipm.model.dosen.matakuliah.DosenMataKuliah;
import com.os.sipm.model.dosen.matakuliah.DosenMataKuliahService;
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
    private Combobox cmbboxMataKuliah;
    @Autowired
    private DosenMataKuliahService dosenMataKuliahService;
    @Autowired
    private MataKuliahService mataKuliahService;
    private DosenMataKuliah selectedDosenMataKuliah;
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
        selectedDosenMataKuliah = (DosenMataKuliah) Executions.getCurrent().getArg().get("selectedDosen");
        if (selectedDosenMataKuliah != null) {
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
    }

    public void onClick$btnSave(Event event) {
        DosenMataKuliah dosenMataKuliah = new DosenMataKuliah();
        if (txtboxNip.getText().isEmpty()) {
            throw new WrongValueException(txtboxNip, MessagesHelper.dataEmpty());
        }
        if (txtboxNama.getText().isEmpty()) {
            throw new WrongValueException(txtboxNama, MessagesHelper.dataEmpty());
        }
        if (selectedDosenMataKuliah != null) {
            dosenMataKuliah.setId(selectedDosenMataKuliah.getId());
        }
        MataKuliah mataKuliah = new MataKuliah();
        mataKuliah.setId(Integer.valueOf(SipmUtils.getSelectedMataKuliah(mataKuliahs, cmbboxMataKuliah.getSelectedItem().toString())));
        dosenMataKuliah.setDosen(selectedDosen);



        if (dosenMataKuliahService.saveOrUpdate(dosenMataKuliah) == 1) {
            this.componentClear();
            MessagesHelper.saveSuccess();
        } else {
            MessagesHelper.saveFailed();
        }
        // Send data pribadi to parent window
        if (selectedDosenMataKuliah != null) {
            Map<Object, Object> params = new HashMap<Object, Object>();
            params.put("nip", selectedDosen.getNip());
            params.put("limit", 1);
            params.put("cursor", 0);
            List<DosenMataKuliah> dosenMataKuliahs = dosenMataKuliahService.getByNip(params);
            self.setAttribute("dosenMataKuliahs", dosenMataKuliahs);
        }
        self.detach();
    }
}
