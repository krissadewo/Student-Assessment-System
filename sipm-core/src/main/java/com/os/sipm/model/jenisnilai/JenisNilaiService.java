/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.jenisnilai;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kris
 */
@Service
public class JenisNilaiService {

    @Autowired
    private JenisNilaiDao jenisNilaiDao;

    public List<JenisNilai> getAll() {
        return jenisNilaiDao.getAllJenisNilai();
    }
}
