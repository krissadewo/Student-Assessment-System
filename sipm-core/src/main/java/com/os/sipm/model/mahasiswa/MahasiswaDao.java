/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.mahasiswa;

import java.util.List;
import java.util.Map;

/**
 *
 * @author kris
 */
public interface MahasiswaDao {

    int saveMahasiswa(Mahasiswa mahasiswa);

    int updateMahasiswa(Mahasiswa mahasiswa);

    int deleteMahasiswa(Mahasiswa mahasiswa);

    Mahasiswa getMahasiswaById(int id);

    List<Mahasiswa> getMahasiswaByNim(Map<Object, Object> params);

    List<Mahasiswa> getMahasiswaByNama(Map<Object, Object> params);

    List<Mahasiswa> getAllMahasiswa(Map<Object, Object> params);

    int countAllMahasiswa();

    int countAllMahasiswaByNim(Map<Object, Object> params);

    int countAllMahasiswaByNama(Map<Object, Object> params);
}
