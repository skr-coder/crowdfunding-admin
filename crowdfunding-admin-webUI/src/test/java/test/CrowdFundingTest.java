package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wcan.crowd.funding.entity.Admin;
import com.wcan.crowd.funding.mapper.AdminMapper;
import com.wcan.crowd.funding.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdFundingTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Test
	public void batchSaveAdmin() {
		for(int i = 0; i < 500; i++) {
			adminMapper.insert(new Admin(null, "loginAcct"+i, "1111111", "userName"+i, "email"+i+"@qq.com", null));
		}
	}
	
//	@Test
//	public void testTx() {
//		adminService.updateAdmin();
//	}
	
	@Test
	public void testMybatis() {
		List<Admin> adminList = adminService.getAll();
		for (Admin admin : adminList) {
			System.out.println(admin);
		}
	}
	
	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		
		System.err.println(connection);
	}

}