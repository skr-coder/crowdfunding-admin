package com.wcan.crowd.funding.handler;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wcan.crowd.funding.entity.ResultEntity;
import com.wcan.crowd.funding.entity.Role;
import com.wcan.crowd.funding.service.RoleService;

@RestController
public class RoleHandler {
	
	@Autowired
	private RoleService roleService;
	
	// @ResponseBody
		@RequestMapping("/role/update/role")
		public ResultEntity<String> updateRole(Role role) {
			
			roleService.updateRole(role);
			
			return ResultEntity.successWithoutData();
		}
		
		// @ResponseBody
		@RequestMapping("/role/save/role")
		public ResultEntity<String> saveRole(@RequestParam("roleName") String roleName) {
			
			roleService.saveRole(roleName);
			
			return ResultEntity.successWithoutData();
		}
		
		// @ResponseBody
		@RequestMapping("/role/batch/remove")
		public ResultEntity<String> batchRemove(@RequestBody List<Integer> roleIdList) {
			
			roleService.batchRemove(roleIdList);
			
			return ResultEntity.successWithoutData();
		}
		
		// @ResponseBody
		@RequestMapping("/role/get/list/by/id/list")
		public ResultEntity<List<Role>> getRoleListByIdList(@RequestBody List<Integer> roleIdList) {
			
			List<Role> roleList = roleService.getRoleListByIdList(roleIdList);
			//System.out.println(1/0);
			return ResultEntity.successWithData(roleList);
		}
	
		//@ResponseBody
		@RequestMapping("/role/search/by/keyword")
		public ResultEntity<PageInfo<Role>> search(
					@RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
					@RequestParam(value="pageSize", defaultValue="5") Integer pageSize,
					@RequestParam(value="keyword", defaultValue="") String keyword
				) {
			
			// 1.查询得到PageInfo对象
			PageInfo<Role> pageInfo = roleService.queryForKeywordWithPage(pageNum, pageSize, keyword);
			
			// 2.封装结果对象返回
			return ResultEntity.successWithData(pageInfo);
		}

}
