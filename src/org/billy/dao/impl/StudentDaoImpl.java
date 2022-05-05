package org.billy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import org.billy.dao.StudentDao;
import org.billy.pojo.Student;
import org.billy.utils.DBUtil;

public class StudentDaoImpl implements StudentDao{

    @Override
    public ArrayList<Student> queryAll() throws SQLException {
        ArrayList<Student> arrayList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from student";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        ResultSet executeQuery = prepareStatement.executeQuery();
        while (executeQuery.next()) {
            Student student = new Student();
            int id = executeQuery.getInt(1);
            String name = executeQuery.getString(2);
            String sex = executeQuery.getString(3);
            String address = executeQuery.getString(4);
            double score = executeQuery.getDouble(5);
            student.setId(id);
            student.setName(name);
            student.setSex(sex);
            student.setAddress(address);
            student.setScore(score);
            arrayList.add(student);
        }
        DBUtil.closeAll(connection, prepareStatement, executeQuery);
        return arrayList;
    }

    @Override
    public boolean add(Student student) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into student (name,sex,address,score) values (?,?,?,?)";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1,student.getId());
        prepareStatement.setString(2, student.getName());
        prepareStatement.setString(3, student.getSex());
        prepareStatement.setString(4, student.getAddress());
        prepareStatement.setDouble(5, student.getScore());
        boolean execute = prepareStatement.execute();
        DBUtil.closeAll(connection, prepareStatement, null);
        return execute;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "delete * from student where id = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, id);
        boolean execute = prepareStatement.execute();
        DBUtil.closeAll(connection, prepareStatement, null);
        return execute;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "update student set name = ?,sex = ?,address = ?,score = ? where id = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, student.getName());
        prepareStatement.setString(2, student.getSex());
        prepareStatement.setString(3, student.getAddress());
        prepareStatement.setDouble(4, student.getScore());
        prepareStatement.setInt(5, student.getId());
        boolean execute = prepareStatement.execute();
        DBUtil.closeAll(connection, prepareStatement, null);
        return execute;
    }

    @Override
    public Student query(int id) throws SQLException {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from student where id = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setInt(1, id);
        ResultSet executeQuery = prepareStatement.executeQuery();
        Student student = new Student();
        while (executeQuery.next()) {
            String name = executeQuery.getString(2);
            String sex = executeQuery.getString(3);
            String address = executeQuery.getString(4);
            double score = executeQuery.getDouble(5);
            student.setId(id);
            student.setName(name);
            student.setSex(sex);
            student.setAddress(address);
            student.setScore(score);
        }
        DBUtil.closeAll(connection, prepareStatement, executeQuery);
        return student;
    }
    
}
