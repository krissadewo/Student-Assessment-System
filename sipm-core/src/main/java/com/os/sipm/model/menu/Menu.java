/**
 * 
 */
package com.os.sipm.model.menu;

import java.io.Serializable;

/**
 * hris-demo
 * 
 * @author kris Apr 17, 2011
 */
public class Menu implements Serializable{

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

}
