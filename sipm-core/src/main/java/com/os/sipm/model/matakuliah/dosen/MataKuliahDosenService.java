/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.matakuliah.dosen;

import com.os.sipm.model.GenerateService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KrisSadewo
 */
@Service
public class MataKuliahDosenService {

    @Autowired
    private MataKuliahDosenDao mataKuliahDosenDao;

    public int saveOrUpdate(MataKuliahDosen entity) {
        if (entity.getId() == null) {
            return mataKuliahDosenDao.saveMataKuliahDosen(entity);
        } else {
            return mataKuliahDosenDao.updateMataKuliahDosen(entity);
        }
    }

    public int delete(MataKuliahDosen entity) {
        return mataKuliahDosenDao.deleteMataKuliahDosen(entity);
    }

    public MataKuliahDosen getById(Integer id) {
        return mataKuliahDosenDao.getMataKuliahDosenById(id);
    }

    public List<MataKuliahDosen> getByNip(Map<Object, Object> params) {
        return mataKuliahDosenDao.getMataKuliahDosenByNip(params);
    }

    public List<MataKuliahDosen> getByName(Map<Object, Object> params) {
        return mataKuliahDosenDao.getMataKuliahDosenByName(params);
    }

    public List<MataKuliahDosen> getAll(Map<Object, Object> params) {
        return mataKuliahDosenDao.getAllMataKuliahDosen(params);
    }

    public int countAllMataKuliahDosen() {
        return mataKuliahDosenDao.countAllMataKuliahDosen();
    }

    public int countAllMataKuliahDosenByNip(Map<Object, Object> params) {
        return mataKuliahDosenDao.countAllMataKuliahDosenByNip(params);
    }

    public int countAllMataKuliahDosenByName(Map<Object, Object> params) {
        return mataKuliahDosenDao.countAllMataKuliahDosenByName(params);
    }
}
