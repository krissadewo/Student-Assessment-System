/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.nilaiangka;

import com.os.sipm.model.matakuliah.MataKuliah;
import com.os.sipm.model.mahasiswa.Mahasiswa;

/**
 *
 * @author kris
 */
public class NilaiAngka {

    private int id;
    private float nilai;
    private Mahasiswa mahasiswa;
    private MataKuliah mataKuliah;

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
