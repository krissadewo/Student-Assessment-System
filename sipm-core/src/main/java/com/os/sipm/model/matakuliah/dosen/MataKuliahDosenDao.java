/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.matakuliah.dosen;

import java.util.List;
import java.util.Map;

/**
 *
 * @author KrisSadewo
 */
public interface MataKuliahDosenDao {

    int saveMataKuliahDosen(MataKuliahDosen dosenMataKuliah);

    int updateMataKuliahDosen(MataKuliahDosen dosenMataKuliah);

    int deleteMataKuliahDosen(MataKuliahDosen dosenMataKuliah);

    MataKuliahDosen getMataKuliahDosenById(int id);

    List<MataKuliahDosen> getMataKuliahDosenByNip(Map<Object, Object> params);

    List<MataKuliahDosen> getMataKuliahDosenByName(Map<Object, Object> params);

    List<MataKuliahDosen> getAllMataKuliahDosen(Map<Object, Object> params);

    int countAllMataKuliahDosen();

    int countAllMataKuliahDosenByNip(Map<Object, Object> params);

    int countAllMataKuliahDosenByName(Map<Object, Object> params);
}
