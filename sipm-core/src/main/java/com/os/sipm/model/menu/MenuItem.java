package com.os.sipm.model.menu;

import java.io.Serializable;

/**
 * hris-demo
 * 
 * @author KrisSadewo Apr 17, 2011
 */
public class MenuItem implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 237982067171117270L;
    private int id;
    private String menuItemName;
    private Menu menu;
    private String imagePath;
    private String viewPath;
    private int sequance;

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getSequance() {
        return sequance;
    }

    public void setSequance(int sequance) {
        this.sequance = sequance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.menuItemName == null) ? (other.menuItemName != null) : !this.menuItemName.equals(other.menuItemName)) {
            return false;
        }
        if (this.menu != other.menu && (this.menu == null || !this.menu.equals(other.menu))) {
            return false;
        }
        if ((this.imagePath == null) ? (other.imagePath != null) : !this.imagePath.equals(other.imagePath)) {
            return false;
        }
        if ((this.viewPath == null) ? (other.viewPath != null) : !this.viewPath.equals(other.viewPath)) {
            return false;
        }
        if (this.sequance != other.sequance) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + (this.menuItemName != null ? this.menuItemName.hashCode() : 0);
        hash = 37 * hash + (this.menu != null ? this.menu.hashCode() : 0);
        hash = 37 * hash + (this.imagePath != null ? this.imagePath.hashCode() : 0);
        hash = 37 * hash + (this.viewPath != null ? this.viewPath.hashCode() : 0);
        hash = 37 * hash + this.sequance;
        return hash;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", menuItemName=" + menuItemName + ", menu=" + menu + ", imagePath=" + imagePath + ", viewPath=" + viewPath + ", sequance=" + sequance + '}';
    }
}
