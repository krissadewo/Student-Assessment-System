/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.utils;

import com.os.sipm.model.jenisnilai.JenisNilai;
import com.os.sipm.model.jurusan.Jurusan;
import com.os.sipm.model.matakuliah.MataKuliah;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author KrisSadewo
 */
public class SipmUtils {

    public static int getSelectedJenisKelamin(final String jenisKelamin) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        map.put("L", 0);
        map.put("P", 1);
        if (map.containsKey(jenisKelamin)) {
            index = map.get(jenisKelamin);
        }
        return index;
    }

    public static int getSelectedStatus(final String status) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        map.put("Aktif", 0);
        map.put("Tidak Aktif", 1);
        if (map.containsKey(status)) {
            index = map.get(status);
        }
        return index;
    }

    public static int getSelectedJurusan(final List<Jurusan> jurusans, final String nama) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        for (Jurusan department : jurusans) {
            map.put(department.getNama(), index++);
        }
        if (map.containsKey(nama)) {
            index = map.get(nama);
        }
        return index;
    }

    public static int getSelectedJenisNilai(final List<JenisNilai> jenisNilais, final String nama) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        for (JenisNilai jenisNilai : jenisNilais) {
            map.put(jenisNilai.getNamaJenis(), index++);
        }
        if (map.containsKey(nama)) {
            index = map.get(nama);
        }
        return index;
    }

    public static int getSelectedMataKuliah(final List<MataKuliah> mataKuliahs, final String nama) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int index = 0;
        for (MataKuliah mataKuliah : mataKuliahs) {
            map.put(mataKuliah.getNama(), index++);
        }
        if (map.containsKey(nama)) {
            index = map.get(nama);
        }
        return index;
    }
}
