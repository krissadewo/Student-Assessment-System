/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.dosen.matakuliah;

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
public class DosenMataKuliahService {

    @Autowired
    private DosenMataKuliahDao dosenMataKuliahDao;

    public int saveOrUpdate(DosenMataKuliah entity) {
        if (entity.getId() == null) {
            return dosenMataKuliahDao.saveDosenMataKuliah(entity);
        } else {
            return dosenMataKuliahDao.updateDosenMataKuliah(entity);
        }
    }

    public int delete(DosenMataKuliah entity) {
        return dosenMataKuliahDao.deleteDosenMataKuliah(entity);
    }

    public DosenMataKuliah getById(Integer id) {
        return dosenMataKuliahDao.getDosenMataKuliahById(id);
    }

    public List<DosenMataKuliah> getByNip(Map<Object, Object> params) {
        return dosenMataKuliahDao.getDosenMataKuliahByNip(params);
    }

    public List<DosenMataKuliah> getByName(Map<Object, Object> params) {
        return dosenMataKuliahDao.getDosenMataKuliahByName(params);
    }

    public List<DosenMataKuliah> getAll(Map<Object, Object> params) {
        return dosenMataKuliahDao.getAllDosenMataKuliah(params);
    }

    public int countAllDosenMataKuliah() {
        return dosenMataKuliahDao.countAllDosenMataKuliah();
    }

    public int countAllDosenMataKuliahByNip(Map<Object, Object> params) {
        return dosenMataKuliahDao.countAllDosenMataKuliahByNip(params);
    }

    public int countAllDosenMataKuliahByName(Map<Object, Object> params) {
        return dosenMataKuliahDao.countAllDosenMataKuliahByName(params);
    }
}
