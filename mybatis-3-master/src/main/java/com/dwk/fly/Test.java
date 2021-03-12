package com.dwk.fly;

import com.dwk.fly.bean.UserBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Auth duweikun
 *
 *  mybatis 源码阅读
 *
 * @Date 2021/3/6
 */
public class Test {

  public static void main(String[] args) throws IOException {
    //读取配置文件
    String configFile = "mybatis.xml";
    //
    Reader reader = Resources.getResourceAsReader(configFile);
    //创建sqlSessionFactory实例
    SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
    //创建sqlSession实例
    SqlSession session = build.openSession();
    //执行操作
    UserBean user = session.selectOne("findOne", 1);
    System.out.println("查询："+user.getName());
    //关闭流
    session.close();
  }

}
