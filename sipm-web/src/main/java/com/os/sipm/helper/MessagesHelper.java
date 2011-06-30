/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.helper;

import org.zkoss.util.resource.Labels;
import org.zkoss.zul.Messagebox;

/**
 * 
 * @author KrisSadewo
 */
public class MessagesHelper {

    public static void saveSuccess() {
        try {
            Messagebox.show(Labels.getLabel("saveSuccess"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void saveFotoSuccess() {
        try {
            Messagebox.show(Labels.getLabel("saveFotoSuccess"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void saveFailed() {
        try {
            Messagebox.show(Labels.getLabel("saveFailed"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSuccess() {
        try {
            Messagebox.show(Labels.getLabel("deleteSuccess"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFailed() {
        try {
            Messagebox.show(Labels.getLabel("deleteFailed"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void windowExist() {
        try {
            Messagebox.show(Labels.getLabel("windowExist"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void editEmpty() {
        try {
            Messagebox.show(Labels.getLabel("editEmpty"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteEmpty() {
        try {
            Messagebox.show(Labels.getLabel("deleteEmpty"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void dataNotFound() {
        try {
            Messagebox.show(Labels.getLabel("dataNotFound"), "Informasi", Messagebox.OK, Messagebox.INFORMATION);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String dataEmpty() {
        return Labels.getLabel("dataEmpty");
    }

    public static String comfirmationDelete() {
        return Labels.getLabel("comfirmationDelete");
    }
}
