package com.javalab.school.domain;

public class Professor {
    private String profId; // 교수번호
    private String profName; // 이름
    private String jumin; // 주민번호
    private String grade; // 직급(교수, 조교수, 부교수, 강사)
    private String deptId; // 학과 코드
    private String hiredate; // 입사년도

    public Professor() {
    }

    public Professor(String profId, String profName, String jumin, String grade, String deptId, String hiredate) {
        this.profId = profId;
        this.profName = profName;
        this.jumin = jumin;
        this.grade = grade;
        this.deptId = deptId;
        this.hiredate = hiredate;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    public String getJumin() {
        return jumin;
    }

    public void setJumin(String jumin) {
        this.jumin = jumin;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "profId='" + profId + '\'' +
                ", profName='" + profName + '\'' +
                ", jumin='" + jumin + '\'' +
                ", grade='" + grade + '\'' +
                ", deptId=" + deptId +
                ", hiredate='" + hiredate + '\'' +
                '}';
    }
}
