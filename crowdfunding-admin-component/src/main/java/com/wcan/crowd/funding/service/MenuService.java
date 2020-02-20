package com.wcan.crowd.funding.service;

import java.util.List;

import com.wcan.crowd.funding.entity.Menu;

public interface MenuService {

	void updateMenu(Menu menu);

	Menu getMenuById(Integer menuId);

	void saveMenu(Menu menu);

	List<Menu> getAll();

}
