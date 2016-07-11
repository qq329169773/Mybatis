package bdp;

import static org.junit.Assert.*;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jd.bdp.order.contoller.Users;
import com.jd.bdp.order.mybatis.UserIface;

public class TestMyBatis {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	private static SqlSession session ;
 
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	
	@Before
	public void before(){
		session = sqlSessionFactory.openSession();
 	}
	
	@Test
	public void test() {
		UserIface userIface = session.getMapper(UserIface.class);
		Users user = userIface.selectUserByID(1);
		System.out.println(user.getUser_name() + " "+ user.getSale());
	}
	@Test
	public void testMutipleContent() {
	/*	UserIface userIface = session.getMapper(UserIface.class);
		Users param = new Users();
		param.setDepart("JAVA");
		List<Users> user = userIface.mutipleSelect();
		System.out.println(user);*/
 	}
	@After
	public void after(){
		session.close();
	}

}
