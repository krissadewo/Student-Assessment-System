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
 * @author kris
 */
@Service
public class MenuItemService {

    @Autowired
    public MenuItemDao menuItemDao;

    public List<MenuItem> getAll() {
        return menuItemDao.getAllMenuItem();
    }
}
