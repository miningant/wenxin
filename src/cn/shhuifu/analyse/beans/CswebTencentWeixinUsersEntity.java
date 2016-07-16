package cn.shhuifu.analyse.beans;

import javax.persistence.*;

@Entity
@Table(name = "csweb_tencent_weixin_users", schema = "data_weixin_user", catalog = "")
public class CswebTencentWeixinUsersEntity extends Params {
    private long custId;
    private String appId;
    private String phoneNo;
    private String userName;
    private String userSex;
    private String userBirthday;
    private String weixinVerifyStatus;
    private String weixinVerifyTime;
    private String weixinName;
    private String weixinSignal;
    private String weixinHead;
    private String weixinSex;
    private String cityNodeId;
    private String updateTime;
    private String createTime;
    private String weixinUser;

    private String cityIdLike;
    private String sortField;

    @Id
    @Column(name = "CUST_ID", nullable = false)
    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "APP_ID", nullable = false, length = 16)
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "PHONE_NO", nullable = false, length = 13)
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 32)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_SEX", nullable = false, length = 1)
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "USER_BIRTHDAY", nullable = true, length = 10)
    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    @Basic
    @Column(name = "WEIXIN_VERIFY_STATUS", nullable = false, length = 8)
    public String getWeixinVerifyStatus() {
        return weixinVerifyStatus;
    }

    public void setWeixinVerifyStatus(String weixinVerifyStatus) {
        this.weixinVerifyStatus = weixinVerifyStatus;
    }

    @Basic
    @Column(name = "WEIXIN_VERIFY_TIME", nullable = true, length = 19)
    public String getWeixinVerifyTime() {
        return weixinVerifyTime;
    }

    public void setWeixinVerifyTime(String weixinVerifyTime) {
        this.weixinVerifyTime = weixinVerifyTime;
    }

    @Basic
    @Column(name = "WEIXIN_NAME", nullable = true, length = 64)
    public String getWeixinName() {
        return weixinName;
    }

    public void setWeixinName(String weixinName) {
        this.weixinName = weixinName;
    }

    @Basic
    @Column(name = "WEIXIN_SIGNAL", nullable = true, length = 64)
    public String getWeixinSignal() {
        return weixinSignal;
    }

    public void setWeixinSignal(String weixinSignal) {
        this.weixinSignal = weixinSignal;
    }

    @Basic
    @Column(name = "WEIXIN_HEAD", nullable = true, length = 255)
    public String getWeixinHead() {
        return weixinHead;
    }

    public void setWeixinHead(String weixinHead) {
        this.weixinHead = weixinHead;
    }

    @Basic
    @Column(name = "WEIXIN_SEX", nullable = true, length = 1)
    public String getWeixinSex() {
        return weixinSex;
    }

    public void setWeixinSex(String weixinSex) {
        this.weixinSex = weixinSex;
    }

    @Basic
    @Column(name = "CITY_NODE_ID", nullable = false, length = 40)
    public String getCityNodeId() {
        return cityNodeId;
    }

    public void setCityNodeId(String cityNodeId) {
        this.cityNodeId = cityNodeId;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = false, length = 19)
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "CREATE_TIME", nullable = false, length = 19)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "WEIXIN_USER", nullable = true, length = 64)
    public String getWeixinUser() {
        return weixinUser;
    }

    public void setWeixinUser(String weixinUser) {
        this.weixinUser = weixinUser;
    }

    public String getCityIdLike() {
        return cityIdLike;
    }

    public void setCityIdLike(String cityIdLike) {
        this.cityIdLike = cityIdLike;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CswebTencentWeixinUsersEntity that = (CswebTencentWeixinUsersEntity) o;

        if (custId != that.custId) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userSex != null ? !userSex.equals(that.userSex) : that.userSex != null) return false;
        if (userBirthday != null ? !userBirthday.equals(that.userBirthday) : that.userBirthday != null) return false;
        if (weixinVerifyStatus != null ? !weixinVerifyStatus.equals(that.weixinVerifyStatus) : that.weixinVerifyStatus != null)
            return false;
        if (weixinVerifyTime != null ? !weixinVerifyTime.equals(that.weixinVerifyTime) : that.weixinVerifyTime != null)
            return false;
        if (weixinName != null ? !weixinName.equals(that.weixinName) : that.weixinName != null) return false;
        if (weixinSignal != null ? !weixinSignal.equals(that.weixinSignal) : that.weixinSignal != null) return false;
        if (weixinHead != null ? !weixinHead.equals(that.weixinHead) : that.weixinHead != null) return false;
        if (weixinSex != null ? !weixinSex.equals(that.weixinSex) : that.weixinSex != null) return false;
        if (cityNodeId != null ? !cityNodeId.equals(that.cityNodeId) : that.cityNodeId != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (weixinUser != null ? !weixinUser.equals(that.weixinUser) : that.weixinUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (custId ^ (custId >>> 32));
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userBirthday != null ? userBirthday.hashCode() : 0);
        result = 31 * result + (weixinVerifyStatus != null ? weixinVerifyStatus.hashCode() : 0);
        result = 31 * result + (weixinVerifyTime != null ? weixinVerifyTime.hashCode() : 0);
        result = 31 * result + (weixinName != null ? weixinName.hashCode() : 0);
        result = 31 * result + (weixinSignal != null ? weixinSignal.hashCode() : 0);
        result = 31 * result + (weixinHead != null ? weixinHead.hashCode() : 0);
        result = 31 * result + (weixinSex != null ? weixinSex.hashCode() : 0);
        result = 31 * result + (cityNodeId != null ? cityNodeId.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (weixinUser != null ? weixinUser.hashCode() : 0);
        return result;
    }
}
