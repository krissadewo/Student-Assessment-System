/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.matakuliah;

import com.os.sipm.model.jenisnilai.JenisNilai;

/**
 *
 * @author kris
 */
public class MataKuliah {

    private Integer id;
    private String kode;
    private String nama;
    private Integer sks;
    private JenisNilai jenisNilai;

    public JenisNilai getJenisNilai() {
        return jenisNilai;
    }

    public void setJenisNilai(JenisNilai jenisNilai) {
        this.jenisNilai = jenisNilai;
    }

    public Integer getSks() {
        return sks;
    }

    public void setSks(Integer sks) {
        this.sks = sks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
