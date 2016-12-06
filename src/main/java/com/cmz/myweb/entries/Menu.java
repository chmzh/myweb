package com.cmz.myweb.entries;

import java.util.LinkedList;
import java.util.List;

public class Menu {
	private int id;
	private String name;
	private String model;
	private String action;
	private boolean visible;
	private List<Menu> subMenu;
	
	public Menu(){
		subMenu = new LinkedList<Menu>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	public void addSubMenu(Menu subMenu){
		this.subMenu.add(subMenu);
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
