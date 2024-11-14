package com.javalab.school.domain;

public class Takes {
    private String stuId;       // 학번
    private String courseId;    // 강좌번호
    private String score;       // 성적

    public Takes() {
    }

    public Takes(String stuId, String courseId, String score) {
        this.stuId = stuId;
        this.courseId = courseId;
        this.score = score;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Takes{" +
                "stuId='" + stuId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
