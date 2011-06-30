/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.dosen;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KrisSadewo
 */
@Service
public class DosenService {

    @Autowired
    private DosenDao dosenDao;

    public int saveOrUpdate(Dosen entity) {
        if (entity.getId() == null) {
            return dosenDao.saveDosen(entity);
        } else {
            return dosenDao.updateDosen(entity);
        }
    }

    public int delete(Dosen entity) {
        return dosenDao.deleteDosen(entity);
    }

    public Dosen getById(Integer id) {
        return dosenDao.getDosenById(id);
    }

    public List<Dosen> getByName(Map<Object, Object> params) {
        return dosenDao.getDosenByName(params);
    }

    public List<Dosen> getByNip(Map<Object, Object> params) {
        return dosenDao.getDosenByNip(params);
    }

    public List<Dosen> getAll(Map<Object, Object> params) {
        return dosenDao.getAllDosen(params);
    }

    public int countAllDosen() {
        return dosenDao.countAllDosen();
    }

    public int countAllDosenByNip(Map<Object, Object> params) {
        return dosenDao.countAllDosenByNip(params);
    }

    public int countAllDosenByName(Map<Object, Object> params) {
        return dosenDao.countAllDosenByName(params);
    }
}
