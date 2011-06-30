/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.jurusan;

/**
 *
 * @author KrisSadewo
 */
public class Jurusan {

    private int id;
    private String kode;
    private String nama;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        final Jurusan other = (Jurusan) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.kode == null) ? (other.kode != null) : !this.kode.equals(other.kode)) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + (this.kode != null ? this.kode.hashCode() : 0);
        hash = 97 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Jurusan{" + "id=" + id + ", kode=" + kode + ", nama=" + nama + '}';
    }
}
