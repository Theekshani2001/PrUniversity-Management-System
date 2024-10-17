package com.thariindi.tech_vista.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class StudentPersonalProfile implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private String studentId;

    private String name;
    private String personalMail;
    private String address;
    private LocalDate birthdate;
    private Integer phone;
    private String faculty;
    private String imgUrl;


    public StudentPersonalProfile() {
    }

    public StudentPersonalProfile(String studentId, String name, String personalMail, String address, LocalDate birthdate, Integer phone, String faculty, String imgUrl) {
        this.studentId = studentId;
        this.name = name;
        this.personalMail = personalMail;
        this.address = address;
        this.birthdate = birthdate;
        this.phone = phone;
        this.faculty = faculty;
        this.imgUrl = imgUrl;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalMail() {
        return personalMail;
    }

    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "StudentPersonalProfile{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", personalMail='" + personalMail + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", imgUrl='" + imgUrl + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}