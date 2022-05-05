package org.billy.pojo;
public class Student {
    private int id;
    private String name;
    private String sex;
    private String address;
    private double score;
    
    public Student() {
    }

    public Student(int id, String name, String sex, String address, double score) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [address=" + address + ", id=" + id + ", name=" + name + ", score=" + score + ", sex=" + sex
                + "]";
    }

    
}
