/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.mahasiswa;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kris
 */
@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaDao mahasiswaDao;

    public int saveOrUpdate(Mahasiswa entity) {
        if (entity.getId() == null) {
            return mahasiswaDao.saveMahasiswa(entity);
        } else {
            return mahasiswaDao.updateMahasiswa(entity);
        }
    }

    public int delete(Mahasiswa entity) {
        return mahasiswaDao.deleteMahasiswa(entity);
    }

    public Mahasiswa getById(Integer id) {
        return mahasiswaDao.getMahasiswaById(id);
    }

    public List<Mahasiswa> getByNim(Map<Object, Object> params) {
        return mahasiswaDao.getMahasiswaByNim(params);
    }

    public List<Mahasiswa> getByName(Map<Object, Object> params) {
        return mahasiswaDao.getMahasiswaByNama(params);
    }

    public List<Mahasiswa> getAll(Map<Object, Object> params) {
        return mahasiswaDao.getAllMahasiswa(params);
    }

    public int countAllMahasiswa() {
        return mahasiswaDao.countAllMahasiswa();
    }

    public int countAllMahasiswaByNim(Map<Object, Object> params) {
        return mahasiswaDao.countAllMahasiswaByNim(params);
    }

    public int countAllMahasiswaByNama(Map<Object, Object> params) {
        return mahasiswaDao.countAllMahasiswaByNama(params);
    }
}
