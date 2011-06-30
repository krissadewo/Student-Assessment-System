/**
 * 
 */
package com.os.sipm.model.menu;

import java.io.Serializable;

/**
 * hris-demo
 * 
 * @author KrisSadewo Apr 17, 2011
 */
public class Menu implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2946576306984072531L;
    private int id;
    private String menuName;
    private String imagePath;
    private int sequance;

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.menuName == null) ? (other.menuName != null) : !this.menuName.equals(other.menuName)) {
            return false;
        }
        if ((this.imagePath == null) ? (other.imagePath != null) : !this.imagePath.equals(other.imagePath)) {
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
        hash = 41 * hash + this.id;
        hash = 41 * hash + (this.menuName != null ? this.menuName.hashCode() : 0);
        hash = 41 * hash + (this.imagePath != null ? this.imagePath.hashCode() : 0);
        hash = 41 * hash + this.sequance;
        return hash;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", menuName=" + menuName + ", imagePath=" + imagePath + ", sequance=" + sequance + '}';
    }
}
