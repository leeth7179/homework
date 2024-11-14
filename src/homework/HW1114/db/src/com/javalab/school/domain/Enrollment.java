package com.javalab.school.domain;

import java.time.LocalDateTime;

public class Enrollment {
    private int enrollId; // 수강번호
    private String stuId; // 학생번호
    private String courseId; // 강좌번호
    private String status; // 수강상태(대기,승인,취소)
    private LocalDateTime enrollmentDate; // 수강신청일

    public Enrollment() {
    }

    public Enrollment(int enrollId, String stuId, String courseId, String status, LocalDateTime enrollmentDate) {
        this.enrollId = enrollId;
        this.stuId = stuId;
        this.courseId = courseId;
        this.status = status;
        this.enrollmentDate = enrollmentDate;
    }

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "enrollId=" + enrollId +
                ", stuId='" + stuId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", status='" + status + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
