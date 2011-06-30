/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.sipm.model.menu;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KrisSadewo
 */
@Service
public class MenuService {

    @Autowired
    private MenuDao menuDao;

    public List<Menu> getAll() {
        return menuDao.getAllMenu();
    }
}
