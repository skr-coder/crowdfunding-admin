package com.wcan.crowd.funding.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wcan.crowd.funding.entity.Role;

public interface RoleService {
	
	PageInfo<Role> queryForKeywordWithPage(Integer pageNum, Integer pageSize, String keyword);

	void updateRole(Role role);

	void saveRole(String roleName);

	void batchRemove(List<Integer> roleIdList);

	List<Role> getRoleListByIdList(List<Integer> roleIdList);

}