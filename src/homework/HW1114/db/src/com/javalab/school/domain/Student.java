package com.javalab.school.domain;

public class Student {
    private String stuId; // 학번
    private String stuName; // 이름
    private String jumin; // 주민번호
    private int year; // 학년
    private String address; // 주소
    private String deptId; // 학과 코드


    public Student() {
    }

    public Student(String stuId, String stuName, String jumin, int year, String address, String deptId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.jumin = jumin;
        this.year = year;
        this.address = address;
        this.deptId = deptId;
    }
    // getter, setter

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getJumin() {
        return jumin;
    }

    public void setJumin(String jumin) {
        this.jumin = jumin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", jumin='" + jumin + '\'' +
                ", year=" + year +
                ", address='" + address + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
