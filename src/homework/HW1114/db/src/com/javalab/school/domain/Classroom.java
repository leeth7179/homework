package com.javalab.school.domain;

public class Classroom {
    private int classroomId;        // 강의실 ID
    private String classroomName;   // 강의실 이름
    private String location;        // 강의실 위치

    public Classroom() {
    }

    public Classroom(int classroomId, String classroomName, String location) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.location = location;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId=" + classroomId +
                ", classroomName='" + classroomName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
