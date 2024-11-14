package com.javalab.school.domain;

public class Department {
    private int deptId;   //학과 코드
    private String deptName;      //학과명
    private String office;      //과사무실

    public Department() {
    }

    public Department(int deptId, String deptName, String office) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.office = office;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}