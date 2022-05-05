package org.billy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.billy.dao.StudentDao;
import org.billy.dao.impl.StudentDaoImpl;
import org.billy.pojo.Student;

public class StudentService {

    StudentDao studentDao = new StudentDaoImpl();
    Scanner scanner = new Scanner(System.in);
    //查询所有
    public void queryAll() throws SQLException{
        ArrayList<Student> queryAll = studentDao.queryAll();
        for (Student student : queryAll) {
            System.out.println(student);
        }
    }

    //增加学生
    public void add() throws SQLException {
        System.out.print("请输入学生id:");
        int id = scanner.nextInt();
        System.out.print("请输入学生姓名:");
        String name = scanner.next();
        System.out.print("请输入学生性别:");
        String sex = scanner.next();
        System.out.print("请输入学生家庭地址:");
        String address = scanner.next();
        System.out.print("请输入学生成绩:");
        double score = scanner.nextDouble();
        Student student = new Student(id,name,sex,address,score);
        boolean add = studentDao.add(student);
        if (add) {
            System.out.println("增加学生成功");
        } else {
            System.out.println("增加学生失败");
        }
    }

    //删除学生
    public void delete() throws SQLException {
        System.out.println("请输入要删除学生的ID:");
        int id = scanner.nextInt();
        boolean delete = studentDao.delete(id);
        if (delete) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    //修改学生信息
    public void update() throws SQLException {
        System.out.println("请输入要修改的学生id:");
        int id = scanner.nextInt();
        Student student = studentDao.query(id);
        boolean update = studentDao.update(student);
        if (update) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    //查询学生信息
    public void query() throws SQLException {
        System.out.println("请输入要查询的学生id");
        int id = scanner.nextInt();
        Student query = studentDao.query(id);
        System.out.println(query);
    }
    
}
