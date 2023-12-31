//package com.ecommerce.amazon.Mail;
//
//import com.ecommerce.amazon.Mail.UserEntity;
//import jakarta.persistence.*;
//
//import java.util.Date;
//import java.util.UUID;
//
//
//
//@Entity
//@Table(name="confirmationToken")
//public class ConfirmationToken {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="token_id")
//    private long tokenid;
//
//    @Column(name="confirmation_token")
// private String confirmationToken;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @OneToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
//    @JoinColumn(nullable = false, name = "user_id")
//    private UserEntity userEntity;
//
//    public ConfirmationToken() {}
//
//    public ConfirmationToken(UserEntity userEntity) {
//        this.userEntity = userEntity;
//        createdDate = new Date();
//        confirmationToken = UUID.randomUUID().toString();
//    }
//
//    public long getTokenid() {
//        return tokenid;
//    }
//
//    public void setTokenid(long tokenid) {
//        this.tokenid = tokenid;
//    }
//
//    public String getConfirmationToken() {
//        return confirmationToken;
//    }
//
//    public void setConfirmationToken(String confirmationToken) {
//        this.confirmationToken = confirmationToken;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public UserEntity getUserEntity() {
//        return userEntity;
//    }
//
//    public void setUserEntity(UserEntity userEntity) {
//        this.userEntity = userEntity;
//    }
//
//
//}