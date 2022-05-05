package org.billy.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.billy.pojo.Student;

public interface StudentDao {
    //查询所有
    public ArrayList<Student> queryAll() throws SQLException;
    //增加学生信息
    public boolean add(Student student) throws SQLException;
    //删除学生信息
    public boolean delete(int id) throws SQLException;
    //修改学生信息
    public boolean update(Student student) throws SQLException;
    //查询学生信息
    public Student query(int id) throws SQLException;
}
