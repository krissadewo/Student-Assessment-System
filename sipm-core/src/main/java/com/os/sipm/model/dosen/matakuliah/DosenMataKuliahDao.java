/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.dosen.matakuliah;

import java.util.List;
import java.util.Map;

/**
 *
 * @author KrisSadewo
 */
public interface DosenMataKuliahDao {

    int saveDosenMataKuliah(DosenMataKuliah dosenMataKuliah);

    int updateDosenMataKuliah(DosenMataKuliah dosenMataKuliah);

    int deleteDosenMataKuliah(DosenMataKuliah dosenMataKuliah);

    DosenMataKuliah getDosenMataKuliahById(int id);

    List<DosenMataKuliah> getDosenMataKuliahByNip(Map<Object, Object> params);

    List<DosenMataKuliah> getDosenMataKuliahByName(Map<Object, Object> params);

    List<DosenMataKuliah> getAllDosenMataKuliah(Map<Object, Object> params);

    int countAllDosenMataKuliah();

    int countAllDosenMataKuliahByNip(Map<Object, Object> params);

    int countAllDosenMataKuliahByName(Map<Object, Object> params);
}
