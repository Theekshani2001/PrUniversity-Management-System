package com.thariindi.tech_vista.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class AcademicStaff implements Serializable {
    @Id
    @Column(updatable = false,nullable = false)
    private String academicStaffId;

    @Column(unique = true)
    private String academicEmail;
    private String name;
    private LocalDate birthdate;
    private String position;
    private String address;
    private String faculty;
    private String imgUrl;

    public AcademicStaff() {
    }

    public AcademicStaff(String academicStaffId, String academicEmail, String name, LocalDate birthdate, String position, String address, String faculty, String imgUrl) {
        this.academicStaffId = academicStaffId;
        this.academicEmail = academicEmail;
        this.name = name;
        this.birthdate = birthdate;
        this.position = position;
        this.address = address;
        this.faculty = faculty;
        this.imgUrl = imgUrl;
    }

    public String getAcademicStaffId() {
        return academicStaffId;
    }

    public void setAcademicStaffId(String academicStaffId) {
        this.academicStaffId = academicStaffId;
    }

    public String getAcademicEmail() {
        return academicEmail;
    }

    public void setAcademicEmail(String academicEmail) {
        this.academicEmail = academicEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    @Override
    public String toString() {
        return "AcademicStaff{" +
                "academicStaffId='" + academicStaffId + '\'' +
                ", academicEmail='" + academicEmail + '\'' +
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", faculty='" + faculty + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
