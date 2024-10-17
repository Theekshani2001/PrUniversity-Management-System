package com.thariindi.tech_vista.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class SocietyMember implements Serializable {

    @Id
    @Column(updatable = false, nullable = false)
    private String societyMemberId;

    private String memberName;
    private String societyName;
    private String imgUrl;


    public SocietyMember() {
    }

    public SocietyMember(String societyMemberId, String memberName, String societyName, String imgUrl) {
        this.societyMemberId = societyMemberId;
        this.memberName = memberName;
        this.societyName = societyName;
        this.imgUrl = imgUrl;
    }

    public String getSocietyMemberId() {
        return societyMemberId;
    }

    public void setSocietyMemberId(String societyMemberId) {
        this.societyMemberId = societyMemberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "SocietyMember{" +
                "societyMemberId='" + societyMemberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", societyName='" + societyName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}