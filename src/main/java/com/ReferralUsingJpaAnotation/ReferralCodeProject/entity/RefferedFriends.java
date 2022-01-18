package com.ReferralUsingJpaAnotation.ReferralCodeProject.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reffered_friend")
public class RefferedFriends {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date joinDate =new Date();
    private Long userId;
    private String userName;
    private Long refferedByUserId ;



    public RefferedFriends() {
    }

    public RefferedFriends(Date joinDate, Long userId, String userName, Long refferedByUserId) {
        this.joinDate = joinDate;
        this.userId = userId;
        this.userName = userName;
        this.refferedByUserId = refferedByUserId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRefferedByUserId() {
        return refferedByUserId;
    }

    public void setRefferedByUserId(Long refferedByUserId) {
        this.refferedByUserId = refferedByUserId;
    }
}
