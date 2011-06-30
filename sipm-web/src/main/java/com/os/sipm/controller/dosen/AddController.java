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
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;

/**
 * 
 * @author KrisSadewo
 */
public class AddController extends GenericForwardComposer {

    @Autowired
    private DosenService dosenService;
    private Dosen selectedDosen;
    private Textbox txtboxNip;
    private Textbox txtboxNama;
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void doAfterCompose(Component win) throws Exception {
        super.doAfterCompose(win);
        this.initComponent();
    }

    private void initComponent() {
        // Get param from parent window if exist
        selectedDosen = (Dosen) Executions.getCurrent().getArg().get("selectedDosen");
        if (selectedDosen != null) {
            txtboxNip.setText(selectedDosen.getNip());
            txtboxNama.setText(selectedDosen.getNama());
        }
    }

    private void componentClear() {
        txtboxNip.setValue("");
        txtboxNama.setValue("");
    }

    public void onClick$btnSave(Event event) {
        Dosen dosen = new Dosen();
        if (txtboxNip.getText().isEmpty()) {
            throw new WrongValueException(txtboxNip, MessagesHelper.dataEmpty());
        }
        if (txtboxNama.getText().isEmpty()) {
            throw new WrongValueException(txtboxNama, MessagesHelper.dataEmpty());
        }
        if (selectedDosen != null) {
            dosen.setId(selectedDosen.getId());
        }
        dosen.setNip(txtboxNip.getText());
        dosen.setNama(txtboxNama.getText());

        if (dosenService.saveOrUpdate(dosen) == 1) {
            this.componentClear();
            MessagesHelper.saveSuccess();
        } else {
            MessagesHelper.saveFailed();
        }
        // Send data pribadi to parent window
        if (dosen != null) {
            Map<Object, Object> params = new HashMap<Object, Object>();
            params.put("nip", dosen.getNip());
            params.put("limit", 1);
            params.put("cursor", 0);
            List<Dosen> dosens = dosenService.getByNip(params);
            self.setAttribute("dosens", dosens);
        }
        self.detach();
    }
}
