package controller;

import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pojo.User;
import utils.JDBCUtils;

public class ALLUser {
	private QueryRunner runner ;
	
	@Before
	public void JunitBefore() {
		runner = new QueryRunner();
	}
	
	/**
	 * 
	 * @throws Exception
	 * 查询全部 new BeanListHandler<User>(User.class)
	 */
	@Test
	public void getAllUser() throws Exception{
		String sql = "select * from userinfo";
		List<User> user = runner.query(JDBCUtils.getConnection(), sql, new BeanListHandler<User>(User.class));
		for (User userlist : user) {
			System.out.println(userlist.toString());
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 * 添加
	 */
	@Test
	public void addUser() throws Exception {
		User user = new User();
		user.setUsername("Amy");
		user.setPassword("90902");
		String sql = "insert into userinfo values (null,?,?)";
		Object[] params = {user.getUsername(),user.getPassword()};
		runner.insert(JDBCUtils.getConnection(), sql, new BeanHandler<User>(User.class), params);
		System.out.println("添加成功");
	}
	/**
	 * 
	 * @throws Exception
	 * 删除
	 */
	@Test
	public void deleteUser() throws Exception{
		String sql ="delete from userinfo where id = ?";
		runner.update(JDBCUtils.getConnection(), sql, 21);
		System.out.println("删除成功");
	}
	
	/**
	 * 修改 
	 * @throws Exception 
	 */
	@Test
	public void updateUser() throws Exception {
		User user = new User();
		user.setUsername("Jack");
		user.setPassword("8888");
		user.setId(18);
		String sql = "update userinfo set username = ?,password = ? where id = ?";
		Object[] params = {user.getUsername(),user.getPassword(),user.getId()};
		runner.update(JDBCUtils.getConnection(), sql, params);
	}
	
	/**
	 * 获取某一条信息
	 * @throws Exception 
	 */
	@Test
	public void getOneUser() throws Exception {
		String sql = "select * from userinfo where id = ?";
		User user = runner.query(JDBCUtils.getConnection(), sql, new BeanHandler<User>(User.class), 19);
		System.out.println(user.toString());
	}
	
	@After
	public void JunitAfter() {
		
	}
}
