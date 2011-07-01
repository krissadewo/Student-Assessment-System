/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.matakuliah.dosen;

import com.os.sipm.model.dosen.Dosen;
import com.os.sipm.model.matakuliah.MataKuliah;

/**
 *
 * @author KrisSadewo
 */
public class MataKuliahDosen {

    private Integer id;
    private int uts;
    private int uas;
    private int kuis1;
    private int kuis2;
    private int absensi;
    private int responsi;
    private int tahun;
    private int semester;
    private String jadwal;
    private String kelas;
    private MataKuliah mataKuliah;
    private Dosen dosen;

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getAbsensi() {
        return absensi;
    }

    public void setAbsensi(int absensi) {
        this.absensi = absensi;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public int getKuis1() {
        return kuis1;
    }

    public void setKuis1(int kuis1) {
        this.kuis1 = kuis1;
    }

    public int getKuis2() {
        return kuis2;
    }

    public void setKuis2(int kuis2) {
        this.kuis2 = kuis2;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public int getResponsi() {
        return responsi;
    }

    public void setResponsi(int responsi) {
        this.responsi = responsi;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public int getUas() {
        return uas;
    }

    public void setUas(int uas) {
        this.uas = uas;
    }

    public int getUts() {
        return uts;
    }

    public void setUts(int uts) {
        this.uts = uts;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MataKuliahDosen other = (MataKuliahDosen) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.uts != other.uts) {
            return false;
        }
        if (this.uas != other.uas) {
            return false;
        }
        if (this.kuis1 != other.kuis1) {
            return false;
        }
        if (this.kuis2 != other.kuis2) {
            return false;
        }
        if (this.absensi != other.absensi) {
            return false;
        }
        if (this.responsi != other.responsi) {
            return false;
        }
        if (this.tahun != other.tahun) {
            return false;
        }
        if (this.semester != other.semester) {
            return false;
        }
        if ((this.jadwal == null) ? (other.jadwal != null) : !this.jadwal.equals(other.jadwal)) {
            return false;
        }
        if (this.mataKuliah != other.mataKuliah && (this.mataKuliah == null || !this.mataKuliah.equals(other.mataKuliah))) {
            return false;
        }
        if (this.dosen != other.dosen && (this.dosen == null || !this.dosen.equals(other.dosen))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + this.uts;
        hash = 59 * hash + this.uas;
        hash = 59 * hash + this.kuis1;
        hash = 59 * hash + this.kuis2;
        hash = 59 * hash + this.absensi;
        hash = 59 * hash + this.responsi;
        hash = 59 * hash + this.tahun;
        hash = 59 * hash + this.semester;
        hash = 59 * hash + (this.jadwal != null ? this.jadwal.hashCode() : 0);
        hash = 59 * hash + (this.mataKuliah != null ? this.mataKuliah.hashCode() : 0);
        hash = 59 * hash + (this.dosen != null ? this.dosen.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "DosenMataKuliah{" + "id=" + id + ", uts=" + uts + ", uas=" + uas + ", kuis1=" + kuis1 + ", kuis2=" + kuis2 + ", absensi=" + absensi + ", responsi=" + responsi + ", tahun=" + tahun + ", semester=" + semester + ", jadwal=" + jadwal + ", mataKuliah=" + mataKuliah + ", dosen=" + dosen + '}';
    }
}
