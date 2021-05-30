package org.rongrong.dao;

import org.rongrong.domain.Student;

import java.util.List;

/**
 * @description：接口操作student表
 * @auther lurongrong
 * @create 2021-05-29 14:54
 */
public interface StudentDao {
    //查询student表的所有的数据
    public List<Student> selectStudents();
    //插入方法

    /**
     *
     * @param student 表示要插入导数据库的数据
     * @return int 表示执行行insert操作之后影响数据库的行数
     */
    public int insertStudent(Student student);

}
