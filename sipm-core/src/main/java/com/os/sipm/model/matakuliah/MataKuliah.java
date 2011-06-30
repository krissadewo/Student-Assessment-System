/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.matakuliah;

import com.os.sipm.model.jenisnilai.JenisNilai;

/**
 *
 * @author KrisSadewo
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MataKuliah other = (MataKuliah) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.kode == null) ? (other.kode != null) : !this.kode.equals(other.kode)) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if (this.sks != other.sks && (this.sks == null || !this.sks.equals(other.sks))) {
            return false;
        }
        if (this.jenisNilai != other.jenisNilai && (this.jenisNilai == null || !this.jenisNilai.equals(other.jenisNilai))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.kode != null ? this.kode.hashCode() : 0);
        hash = 37 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 37 * hash + (this.sks != null ? this.sks.hashCode() : 0);
        hash = 37 * hash + (this.jenisNilai != null ? this.jenisNilai.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "MataKuliah{" + "id=" + id + ", kode=" + kode + ", nama=" + nama + ", sks=" + sks + ", jenisNilai=" + jenisNilai + '}';
    }
}
