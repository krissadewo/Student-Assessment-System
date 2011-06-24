/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.jurusan;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kris
 */
@Service
public class JurusanService {

    @Autowired
    private JurusanDao jurusanDao;

    public int saveJurusan(Jurusan jurusan) {
        return jurusanDao.saveJurusan(jurusan);
    }

    public int updateJurusan(Jurusan jurusan) {
        return jurusanDao.updateJurusan(jurusan);
    }

    public int deleteJurusan(Jurusan jurusan) {
        return jurusanDao.deleteJurusan(jurusan);
    }

    public List<Jurusan> getAllJurusan() {
        return jurusanDao.getAllJurusan();
    }
}
