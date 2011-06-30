/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.jenisnilai;

/**
 *
 * @author KrisSadewo
 */
public class JenisNilai {

    private Integer id;
    private String namaJenis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JenisNilai other = (JenisNilai) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.namaJenis == null) ? (other.namaJenis != null) : !this.namaJenis.equals(other.namaJenis)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.namaJenis != null ? this.namaJenis.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "JenisNilai{" + "id=" + id + ", namaJenis=" + namaJenis + '}';
    }
}
