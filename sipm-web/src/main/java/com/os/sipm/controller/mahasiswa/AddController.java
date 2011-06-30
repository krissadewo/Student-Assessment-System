/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.controller.mahasiswa;

import com.os.sipm.helper.MessagesHelper;
import com.os.sipm.model.jurusan.Jurusan;
import com.os.sipm.model.jurusan.JurusanService;
import com.os.sipm.model.mahasiswa.Mahasiswa;
import com.os.sipm.model.mahasiswa.MahasiswaService;
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
import org.zkoss.zul.Textbox;

/**
 * 
 * @author KrisSadewo
 */
public class AddController extends GenericForwardComposer {

    private Textbox txtboxNim;
    private Textbox txtboxNama;
    private Combobox cmbboxJurusan;
    @Autowired
    private MahasiswaService mahasiswaService;
    @Autowired
    private JurusanService jurusanService;
    private List<Jurusan> jurusans;
    private Mahasiswa selectedMahasiswa;
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        this.initComponent();
    }

    private void initComponent() {
        loadDataJurusan();
        // Get param from parent window if exist
        selectedMahasiswa = (Mahasiswa) Executions.getCurrent().getArg().get("selectedMahasiswa");
        if (selectedMahasiswa != null) {
            txtboxNim.setText(selectedMahasiswa.getNim());
            txtboxNama.setText(selectedMahasiswa.getNama());
            cmbboxJurusan.setSelectedIndex(SipmUtils.getSelectedJurusan(jurusans, selectedMahasiswa.getJurusan().getNama()));
        }
    }

    private void loadDataJurusan() {
        cmbboxJurusan.getItems().clear();
        jurusans = jurusanService.getAllJurusan();
        for (Jurusan jurusan : jurusans) {
            Comboitem comboitem = new Comboitem();
            comboitem.setValue(Integer.valueOf(jurusan.getId()));
            comboitem.setLabel(jurusan.getNama());
            cmbboxJurusan.appendChild(comboitem);
        }
        cmbboxJurusan.setSelectedIndex(0);
    }

    private void componentClear() {
        txtboxNim.setValue("");
        txtboxNama.setValue("");
        cmbboxJurusan.setSelectedIndex(0);
    }

    public void onClick$btnSave(Event event) {
        logger.info(cmbboxJurusan.getSelectedItem().getValue());
        Jurusan jurusan = new Jurusan();
        jurusan.setId(Integer.valueOf(cmbboxJurusan.getSelectedItem().getValue().toString()));

        Mahasiswa mahasiswa = new Mahasiswa();
        if (txtboxNim.getText().isEmpty()) {
            throw new WrongValueException(txtboxNim, MessagesHelper.dataEmpty());
        }
        if (txtboxNama.getText().isEmpty()) {
            throw new WrongValueException(txtboxNama, MessagesHelper.dataEmpty());
        }
        if (selectedMahasiswa != null) {
            mahasiswa.setId(selectedMahasiswa.getId());
        }
        mahasiswa.setNim(txtboxNim.getText());
        mahasiswa.setNama(txtboxNama.getText());
        mahasiswa.setJurusan(jurusan);

        if (mahasiswaService.saveOrUpdate(mahasiswa) == 1) {
            this.componentClear();
            MessagesHelper.saveSuccess();
        } else {
            MessagesHelper.saveFailed();
        }
        // Send data pribadi to parent window
        if (mahasiswa != null) {
            Map<Object, Object> params = new HashMap<Object, Object>();
            params.put("nim", mahasiswa.getNim());
            params.put("limit", 1);
            params.put("cursor", 0);
            List<Mahasiswa> mahasiswas = mahasiswaService.getByNim(params);
            self.setAttribute("mahasiswas", mahasiswas);
        }
        self.detach();
    }
}
