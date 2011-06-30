/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.service;

import com.os.sipm.model.jurusan.Jurusan;
import com.os.sipm.model.mahasiswa.Mahasiswa;
import com.os.sipm.model.mahasiswa.MahasiswaService;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author KrisSadewo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/os/sipm/config/SpringConfig.xml"})
public class MahasiswaServiceTest {

    @Autowired
    public MahasiswaService mahasiswaService;

    //@Test
    public void testObject() {
        Assert.assertNotNull(mahasiswaService);
    }

    //@Test
    public void testAll() {
        Jurusan jurusan = new Jurusan();
        jurusan.setId(1);
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim("002");
        mahasiswa.setNama("Sadewo");
        mahasiswa.setJurusan(jurusan);
        // Assert.assertEquals(mahasiswaService.saveMahasiswa(mahasiswa), 1);
    }

    @Test
    public void getAll() {
        Map<Object, Object> params = new HashMap<Object, Object>();
        params.put("cursor", 1);
        params.put("limit", 14);
        Assert.assertNotNull(mahasiswaService.getAll(params));
    }
}
