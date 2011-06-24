/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.dosen;

import java.util.List;
import java.util.Map;

/**
 *
 * @author kris
 */
public interface DosenDao {

    int saveDosen(Dosen dosen);

    int updateDosen(Dosen dosen);

    int deleteDosen(Dosen dosen);

    Dosen getDosenById(int id);

    List<Dosen> getDosenByNip(Map<Object, Object> params);

    List<Dosen> getDosenByNama(Map<Object, Object> params);

    List<Dosen> getAllDosen(Map<Object, Object> params);

    int countAllDosen();

    int countAllDosenByNip(Map<Object, Object> params);

    int countAllDosenByNama(Map<Object, Object> params);
}
