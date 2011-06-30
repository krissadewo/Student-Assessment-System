/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.matakuliah;

import java.util.List;
import java.util.Map;

/**
 *
 * @author KrisSadewo
 */
public interface MataKuliahDao {

    int saveMataKuliah(MataKuliah MataKuliah);

    int updateMataKuliah(MataKuliah MataKuliah);

    int deleteMataKuliah(MataKuliah MataKuliah);

    MataKuliah getMataKuliahById(int id);

    List<MataKuliah> getMataKuliahByKode(Map<Object, Object> params);

    List<MataKuliah> getMataKuliahByNama(Map<Object, Object> params);

    List<MataKuliah> getAllMataKuliah(Map<Object, Object> params);

    int countAllMataKuliah();

    int countAllMataKuliahByKode(Map<Object, Object> params);

    int countAllMataKuliahByNama(Map<Object, Object> params);
}
