package cn.itcast.crm.domain;

import java.sql.Timestamp;

/**
 * 用户（员工）管理
 */
public class CrmUser implements java.io.Serializable {
    private String userId;   //主键id
    private String logonName; //登录名
    private String logonPwd;  //登录密码
    private String userName;  //用户名
    private String gender;    //性别
    private Timestamp onDutyDate; //入职日期
    //多对一：多个用户 属于 一个职位
    private CrmPost crmPost; //职位

    public CrmPost getCrmPost() {
        return crmPost;
    }

    public String getGender() {
        return gender;
    }

    public String getLogonName() {
        return logonName;
    }

    public String getLogonPwd() {
        return logonPwd;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Timestamp getOnDutyDate() {
        return onDutyDate;
    }

    public void setCrmPost(CrmPost crmPost) {
        this.crmPost = crmPost;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public void setLogonPwd(String logonPwd) {
        this.logonPwd = logonPwd;
    }

    public void setOnDutyDate(Timestamp onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

