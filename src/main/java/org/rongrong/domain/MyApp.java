package org.rongrong.domain;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-29 17:30
 */
public class MyApp {

    public static void main(String[] args) throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始（target/clasess）
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.【重要】获取SqlSession对象。从SqlSessionFactory中获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //6.
        String sqlId = "org.rongrong.dao.StudentDao" + "." + "selectStudents";
        List<Object> studentList = sqlSession.selectList(sqlId);
        studentList.forEach( stu -> System.out.println(stu));
        sqlSession.close();
    }
}
