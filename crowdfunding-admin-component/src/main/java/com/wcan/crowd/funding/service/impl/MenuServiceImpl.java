package com.wcan.crowd.funding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcan.crowd.funding.entity.Menu;
import com.wcan.crowd.funding.entity.MenuExample;
import com.wcan.crowd.funding.mapper.MenuMapper;
import com.wcan.crowd.funding.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> getAll() {
		return menuMapper.selectByExample(new MenuExample());
	}

	@Override
	public void saveMenu(Menu menu) {
		menuMapper.insert(menu);
	}

	@Override
	public Menu getMenuById(Integer menuId) {
		return menuMapper.selectByPrimaryKey(menuId);
	}

	@Override
	public void updateMenu(Menu menu) {
		menuMapper.updateByPrimaryKey(menu);
	}

}
