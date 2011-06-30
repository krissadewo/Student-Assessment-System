/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.jurusan;

import java.util.List;

/**
 *
 * @author KrisSadewo
 */
public interface JurusanDao {

    int saveJurusan(Jurusan jurusan);

    int updateJurusan(Jurusan jurusan);

    int deleteJurusan(Jurusan jurusan);

    List<Jurusan> getAllJurusan();
}
