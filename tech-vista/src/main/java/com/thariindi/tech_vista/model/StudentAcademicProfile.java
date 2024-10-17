package com.thariindi.tech_vista.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class StudentAcademicProfile implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private String academicId;

    private String name;
    @Column(unique = true)
    private String academicMail;
    private String faculty;
    private String degree;
    private Double currentGPA;
    private Integer academicYear;
    private String imgUrl;



    public StudentAcademicProfile() {
    }

    public StudentAcademicProfile(String academicId, String name, String academicMail, String faculty, String degree, Double currentGPA, Integer academicYear, String imgUrl) {
        this.academicId = academicId;
        this.name = name;
        this.academicMail = academicMail;
        this.faculty = faculty;
        this.degree = degree;
        this.currentGPA = currentGPA;
        this.academicYear = academicYear;
        this.imgUrl = imgUrl;
    }

    public String getAcademicId() {
        return academicId;
    }

    public void setAcademicId(String academicId) {
        this.academicId = academicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicMail() {
        return academicMail;
    }

    public void setAcademicMail(String academicMail) {
        this.academicMail = academicMail;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Double getCurrentGPA() {
        return currentGPA;
    }

    public void setCurrentGPA(Double currentGPA) {
        this.currentGPA = currentGPA;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "StudentAcademicProfile{" +
                "academicId='" + academicId + '\'' +
                ", name='" + name + '\'' +
                ", academicMail='" + academicMail + '\'' +
                ", faculty='" + faculty + '\'' +
                ", degree='" + degree + '\'' +
                ", currentGPA=" + currentGPA +
                ", academicYear=" + academicYear +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}