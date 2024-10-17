package com.thariindi.tech_vista.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Society implements Serializable {
    @Id
    @Column(updatable = false, nullable = false)
    private String societyId;

    private String societyName;
    private String description;
    private Integer numOfSocietyMembers;
    private String teacherInCharge;
    private String imgUrl;


    public Society() {
    }

    public Society(String societyId, String societyName, String description, Integer numOfSocietyMembers, String teacherInCharge, String imgUrl) {
        this.societyId = societyId;
        this.societyName = societyName;
        this.description = description;
        this.numOfSocietyMembers = numOfSocietyMembers;
        this.teacherInCharge = teacherInCharge;
        this.imgUrl = imgUrl;
    }

    public String getSocietyId() {
        return societyId;
    }

    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumOfSocietyMembers() {
        return numOfSocietyMembers;
    }

    public void setNumOfSocietyMembers(Integer numOfSocietyMembers) {
        this.numOfSocietyMembers = numOfSocietyMembers;
    }

    public String getTeacherInCharge() {
        return teacherInCharge;
    }

    public void setTeacherInCharge(String teacherInCharge) {
        this.teacherInCharge = teacherInCharge;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Society{" +
                "societyId='" + societyId + '\'' +
                ", societyName='" + societyName + '\'' +
                ", description='" + description + '\'' +
                ", numOfSocietyMembers=" + numOfSocietyMembers +
                ", teacherInCharge='" + teacherInCharge + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}