/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.dosen;

/**
 *
 * @author KrisSadewo
 */
public class Dosen {

    private Integer id;
    private String nip;
    private String nama;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dosen other = (Dosen) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.nip == null) ? (other.nip != null) : !this.nip.equals(other.nip)) {
            return false;
        }
        if ((this.nama == null) ? (other.nama != null) : !this.nama.equals(other.nama)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 29 * hash + (this.nip != null ? this.nip.hashCode() : 0);
        hash = 29 * hash + (this.nama != null ? this.nama.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Dosen{" + "id=" + id + ", nip=" + nip + ", nama=" + nama + '}';
    }
}
