/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.service;

import com.os.sipm.model.dosen.Dosen;
import com.os.sipm.model.dosen.DosenService;
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
public class DosenServiceTest {

    @Autowired
    private DosenService dosenService;

    //@Test
    public void checkInstance() {
        Assert.assertNotNull(dosenService);
    }

    //@Test
    public void save() {
        Dosen dosen = new Dosen();
        dosen.setNip("D01");
        dosen.setNama("Kris");
        Assert.assertNotNull(dosenService.saveOrUpdate(dosen));
    }

    @Test
    public void get() {
        Map<Object, Object> params = new HashMap<Object, Object>();
        params.put("limit", 10);
        params.put("cursor", 0);
        params.put("nama", "kri%");
        params.put("id", 1);
        params.put("nip", "DO%");
        Assert.assertNotNull(dosenService.getAll(params));
        Assert.assertNotNull(dosenService.getByName(params));
        Assert.assertNotNull(dosenService.getByNip(params));
    }
}
