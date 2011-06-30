/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.mahasiswa;

import com.os.sipm.model.jurusan.Jurusan;

/**
 *
 * @author KrisSadewo
 */
public class Mahasiswa {

    private Integer id;
    private String nim;
    private String nama;
    private Jurusan jurusan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mahasiswa other = (Mahasiswa) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nim == null) ? (other.nim != null) : !this.nim.equals(other.nim)) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        if (this.jurusan != other.jurusan && (this.jurusan == null || !this.jurusan.equals(other.jurusan))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.nim != null ? this.nim.hashCode() : 0);
        hash = 53 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        hash = 53 * hash + (this.jurusan != null ? this.jurusan.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "id=" + id + ", nim=" + nim + ", nama=" + nama + ", jurusan=" + jurusan + '}';
    }
}
