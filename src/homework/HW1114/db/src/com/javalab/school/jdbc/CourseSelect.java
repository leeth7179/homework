package com.javalab.school.jdbc;

import java.sql.*;

public class CourseSelect {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC 드라이버 클래스의 경로(오라클 JDBC 드라이버 클래스 로딩 문자열)
            String driverClassName = "oracle.jdbc.OracleDriver";

            // 드라이버 클래스를 동적으로 로드, 로딩된 드라이버는 자동으로 DriverManager에 등록됨.
            Class.forName(driverClassName);

            // 연결할 데이터베이스의 정보
            String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl"; // orcl : 오라클 SID, 전역 데이터베이스 이름
            String username = "school5";    // 오라클 계정 이름
            String password = "1234";       // 오라클 계정 비밀번호

            // DriverManager를 통해 Connection 객체를 생성
            // 매개변수로 연결할 데이터베이스의 URL, 사용자 이름, 비밀번호를 전달
            conn = DriverManager.getConnection(dbUrl, username, password);

            // 학생 목록 조회
            displayCourses(conn);


        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패");
            e.printStackTrace();
        } finally {
            // 연결 종료
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("데이터베이스 연결 종료");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void displayCourses(Connection conn) {
        // 쿼리문 작성
        String sql = "SELECT course_id, prof_id, classroom_id, course_name, credit, description, year, semester " +
                " FROM course " +
                " ORDER BY course_id";

        PreparedStatement pstmt = null; // SQL 문을 실행하는 객체
        ResultSet rs = null;            // SQL 쿼리 결과를 저장하는 객체

        try  {
            // Connection 구현 객체의 prepareStatement 메소드에 쿼리문을 전달해서
            // 쿼리문을 실행할 수 있도록 준비를 하는 PreparedStatement 객체를 생성한다.
            // PreparedStatement 객체에 동적으로 전달받는 파라미터(?)가 있다면 이를 세팅하는
            // 과정을 거쳐야 한다.
            pstmt = conn.prepareStatement(sql);
            // PreparedStatement 객체를 통해서 쿼리를 실행하고 결과를 ResultSet 객체를
            // 통해서 반환 받는다.
            rs = pstmt.executeQuery(); // 조회할때는 executeQuery() 메소드 사용

            // 제목
            System.out.println("<< 강의 목록 >>");
            System.out.println("=============================================");
            System.out.println("강좌번호\t교수ID\t강의실\t강좌명\t학점\t강좌설명\t개설년도\t학기");
            System.out.println("---------------------------------------------");


            // while문을 이용해서 ResultSet 객체에 담긴 결과를 하나씩 꺼내서 출력
            while (rs.next()) {
                String courseId = rs.getString("course_id");
                String courseName = rs.getString("course_name");
                int credit = rs.getInt("credit");
                String description = rs.getString("description");
                String profId = rs.getString("prof_id");
                int year = rs.getInt("year");
                String semester = rs.getString("semester");
                int classroomId = rs.getInt("classroom_id");


                System.out.println(courseId + '\t' + profId + '\t' + classroomId + '\t' + courseName + '\t' + credit + '\t' + description
                        + '\t' + year + '\t' + semester);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // ResultSet, PreparedStatement, Connection 순으로 닫기
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("=============================================");
    }
}
