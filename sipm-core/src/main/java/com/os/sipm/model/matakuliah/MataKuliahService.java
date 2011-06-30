/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.matakuliah;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KrisSadewo
 */
@Service
public class MataKuliahService {

    @Autowired
    private MataKuliahDao mataKuliahDao;

    public int saveOrUpdate(MataKuliah entity) {
        if (entity.getId() == null) {
            return mataKuliahDao.saveMataKuliah(entity);
        } else {
            return mataKuliahDao.updateMataKuliah(entity);
        }
    }

    public int delete(MataKuliah entity) {
        return mataKuliahDao.deleteMataKuliah(entity);
    }

    public MataKuliah getById(Integer id) {
        return mataKuliahDao.getMataKuliahById(id);
    }

    public List<MataKuliah> getByName(Map<Object, Object> params) {
        return mataKuliahDao.getMataKuliahByNama(params);
    }

    public List<MataKuliah> getByKode(Map<Object, Object> params) {
        return mataKuliahDao.getMataKuliahByKode(params);
    }

    public List<MataKuliah> getAll(Map<Object, Object> params) {
        return mataKuliahDao.getAllMataKuliah(params);
    }

    public int countAllMataKuliah() {
        return mataKuliahDao.countAllMataKuliah();
    }

    public int countAllMataKuliahByKode(Map<Object, Object> params) {
        return mataKuliahDao.countAllMataKuliahByKode(params);
    }

    public int countAllMataKuliahByNama(Map<Object, Object> params) {
        return mataKuliahDao.countAllMataKuliahByNama(params);
    }
}
