package org.rongrong;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.rongrong.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description：
 * @auther lurongrong
 * @create 2021-05-30 10:51
 */
public class TestMyBatis {
    //测试方法  测试功能
    @Test
    public void testInsert() throws IOException {
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
        String sqlId = "org.rongrong.dao.StudentDao" + "." + "insertStudent";
        Student student = new Student();
        student.setId(3);
        student.setName("万科");
        student.setEmail("799@cds");
        student.setAge(19);

        int nums = sqlSession.insert(sqlId,student);
        //mybatis默认不是自动提交事务的，所以在insert，delete，update后要手工提交事务
        sqlSession.commit();
        //8.输出结果
//        studentList.forEach( stu -> System.out.println(stu));
        System.out.println("输出执行的结果：" + nums);
        sqlSession.close();
    }
}
