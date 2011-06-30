/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.nilaiangka;

import com.os.sipm.model.matakuliah.MataKuliah;
import com.os.sipm.model.mahasiswa.Mahasiswa;

/**
 *
 * @author KrisSadewo
 */
public class NilaiAngka {

    private Integer id;
    private float nilai;
    private Mahasiswa mahasiswa;
    private MataKuliah mataKuliah;

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public float getNilai() {
        return nilai;
    }

    public void setNilai(float nilai) {
        this.nilai = nilai;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NilaiAngka other = (NilaiAngka) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.nilai) != Float.floatToIntBits(other.nilai)) {
            return false;
        }
        if (this.mahasiswa != other.mahasiswa && (this.mahasiswa == null || !this.mahasiswa.equals(other.mahasiswa))) {
            return false;
        }
        if (this.mataKuliah != other.mataKuliah && (this.mataKuliah == null || !this.mataKuliah.equals(other.mataKuliah))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Float.floatToIntBits(this.nilai);
        hash = 41 * hash + (this.mahasiswa != null ? this.mahasiswa.hashCode() : 0);
        hash = 41 * hash + (this.mataKuliah != null ? this.mataKuliah.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "NilaiAngka{" + "id=" + id + ", nilai=" + nilai + ", mahasiswa=" + mahasiswa + ", mataKuliah=" + mataKuliah + '}';
    }
    
    
}
