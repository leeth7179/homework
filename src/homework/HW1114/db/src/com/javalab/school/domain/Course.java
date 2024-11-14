package com.javalab.school.domain;

public class Course {
    private String courseId;    // 강좌번호
    private String courseName;  // 강좌명
    private int credit;         // 학점
    private String description; // 강좌 설명
    private String profId;       // 교수 ID
    private int year;            // 학년도
    private String semester;     // 학기
    private int classroomId;     // 강의실 ID

    public Course() {
    }

    public Course(String courseId, String courseName, int credit, String description, String profId, int year, String semester, int classroomId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.description = description;
        this.profId = profId;
        this.year = year;
        this.semester = semester;
        this.classroomId = classroomId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", description='" + description + '\'' +
                ", profId='" + profId + '\'' +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", classroomId=" + classroomId +
                '}';
    }
}
