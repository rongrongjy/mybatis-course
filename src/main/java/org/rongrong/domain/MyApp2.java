package org.rongrong.domain;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.rongrong.utils.MyBatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-29 17:30
 */
public class MyApp2 {

    public static void main(String[] args) throws IOException {

        //5.【重要】获取SqlSession对象。从SqlSessionFactory中获取sqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //6.
        String sqlId = "org.rongrong.dao.StudentDao" + "." + "selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        studentList.forEach( stu -> System.out.println(stu));
        sqlSession.close();
    }
}
