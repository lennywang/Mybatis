package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.pojo.student;

public class MyFirstMybatisTest {

	@Test
	public void testMybatis() throws IOException {
		String resource="sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = build.openSession();
		student student = sqlSession.selectOne("test.findStudentById",1);
		System.out.println(student);
	}
}
