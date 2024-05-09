package model;

import interfaces.GenericClass;

import java.time.LocalDate;
import java.util.Scanner;

public class Education {
    private int id;
    private String schoolName;
    private String degree;
    private String fieldOfStudy;
    private LocalDate startDate;
    private LocalDate endDate;
    private String grade;
    private int userId;

    public Education() {

    }

    public Education(int id, String schoolName, String degree, String fieldOfStudy, LocalDate startDate, LocalDate endDate, String grade, int userId) {
        this.id = id;
        this.schoolName = schoolName;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.grade = grade;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Education{" +
                "schoolName='" + schoolName + '\'' +
                ", degree='" + degree + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", grade='" + grade + '\'' +
                '}';
    }
}
