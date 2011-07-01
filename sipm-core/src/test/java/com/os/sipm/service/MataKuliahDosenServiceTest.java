/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.service;

import com.os.sipm.model.matakuliah.dosen.MataKuliahDosenService;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author KrisSadewo
 * Jul 1, 2011   
 * 11:48:20 AM 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:com/os/sipm/config/SpringConfig.xml"})
public class MataKuliahDosenServiceTest {

    @Autowired
    public MataKuliahDosenService mataKuliahDosenService;
    Map<Object, Object> params;

    @Before
    public void init() {
        params = new HashMap<Object, Object>();
        params.put("limit", 14);
        params.put("cursor", 0);
        params.put("nip", "D01");
        params.put("id_matakuliah", 1);
        params.put("kelas", 1);
    }

    //@Test
    public void getAll() {
        Assert.assertNotNull(mataKuliahDosenService.getAll(params));
    }

    @Test
    public void getByNip() {
        Assert.assertNotNull(mataKuliahDosenService.getByNip(params));

    }
}
