/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.service;

import com.os.sipm.model.jenisnilai.JenisNilai;
import com.os.sipm.model.matakuliah.MataKuliah;
import com.os.sipm.model.matakuliah.MataKuliahService;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Before;
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
public class MataKuliahServiceTest {

    @Autowired
    private MataKuliahService mataKuliahService;

    @Before
    public void init() {
        Assert.assertNotNull(mataKuliahService);
    }

    @Test
    public void getAll() {
        Map<Object, Object> params = new HashMap<Object, Object>();
        params.put("limit", 10);
        params.put("cursor", 0);
        Assert.assertNotNull(mataKuliahService.getAll(null));
        System.out.println(mataKuliahService.getAll(null).get(0).toString());
    }

    //@Test
    public void testAll() {
        Map<Object, Object> params = new HashMap<Object, Object>();
        MataKuliah mataKuliah = new MataKuliah();
        mataKuliah.setKode("MKW001");
        mataKuliah.setNama("Algoritma dan Pemrograman");
        mataKuliah.setSks(2);
        JenisNilai jenisNilai = new JenisNilai();
        jenisNilai.setId(1);
        mataKuliah.setJenisNilai(jenisNilai);
        Assert.assertEquals(1, mataKuliahService.saveOrUpdate(mataKuliah));

        params.put("kode", "MK%");
        params.put("nama", "Alg%");
        params.put("limit", 15);
        params.put("cursor", 0);
        //Try to update       
        mataKuliah = mataKuliahService.getByKode(params).get(0);

        Assert.assertNotNull(mataKuliahService.getByKode(params));
        Assert.assertNotNull(mataKuliahService.getByName(params));
        Assert.assertNotNull(mataKuliahService.getById(mataKuliah.getId()));
        Assert.assertEquals(1, mataKuliahService.saveOrUpdate(mataKuliah));
        Assert.assertEquals(1, mataKuliahService.delete(mataKuliah));



    }
}
