package com.thariindi.tech_vista.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
public class NonAcademicStaff implements Serializable {
    @Id
    @Column(updatable = false,nullable = false,unique = true)
    private String nonAcademicStaffId;
    @Column(unique = true)
    private String nonAcademicStaffMail;
    private String name;
    private LocalDate birthdate;
    private String position;
    private String address;
    private String imgUrl;

    public NonAcademicStaff() {
    }

    public NonAcademicStaff(String nonAcademicStaffId, String nonAcademicStaffMail, String name, LocalDate birthdate, String position, String address, String imgUrl) {
        this.nonAcademicStaffId = nonAcademicStaffId;
        this.nonAcademicStaffMail = nonAcademicStaffMail;
        this.name = name;
        this.birthdate = birthdate;
        this.position = position;
        this.address = address;
        this.imgUrl=imgUrl;

    }

    public String getNonAcademicStaffId() {
        return nonAcademicStaffId;
    }

    public void setNonAcademicStaffId(String nonAcademicStaffId) {
        this.nonAcademicStaffId = nonAcademicStaffId;
    }

    public String getNonAcademicStaffMail() {
        return nonAcademicStaffMail;
    }

    public void setNonAcademicStaffMail(String nonAcademicStaffMail) {
        this.nonAcademicStaffMail = nonAcademicStaffMail;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "NonAcademicStaff{" +
                "nonAcademicStaffId='" + nonAcademicStaffId + '\'' +
                ", nonAcademicStaffMail='" + nonAcademicStaffMail + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", position='" + position + '\'' +
                ", address='" + address + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
