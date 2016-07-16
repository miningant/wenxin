package cn.shhuifu.analyse.beans;

import javax.persistence.*;

@Entity
@Table(name = "csweb_data_mobile_users", schema = "data_weixin_user", catalog = "")
public class CswebDataMobileUsersEntity extends Params {
    private long custId;
    private String appId;
    private String phoneNo;
    private String userName;
    private String userSex;
    private String userBirthday;
    private String userEmail;
    private String cityNodeId;
    private String userAddress;
    private String zipCode;
    private String weixinVerify;
    private String updateTime;
    private String createTime;

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
    @Column(name = "USER_EMAIL", nullable = true, length = 64)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
    @Column(name = "USER_ADDRESS", nullable = true, length = 255)
    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Basic
    @Column(name = "ZIP_CODE", nullable = true, length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "WEIXIN_VERIFY", nullable = false, length = 1)
    public String getWeixinVerify() {
        return weixinVerify;
    }

    public void setWeixinVerify(String weixinVerify) {
        this.weixinVerify = weixinVerify;
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

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getCityIdLike() {
        return cityIdLike;
    }

    public void setCityIdLike(String cityIdLike) {
        this.cityIdLike = cityIdLike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CswebDataMobileUsersEntity that = (CswebDataMobileUsersEntity) o;

        if (custId != that.custId) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userSex != null ? !userSex.equals(that.userSex) : that.userSex != null) return false;
        if (userBirthday != null ? !userBirthday.equals(that.userBirthday) : that.userBirthday != null) return false;
        if (userEmail != null ? !userEmail.equals(that.userEmail) : that.userEmail != null) return false;
        if (cityNodeId != null ? !cityNodeId.equals(that.cityNodeId) : that.cityNodeId != null) return false;
        if (userAddress != null ? !userAddress.equals(that.userAddress) : that.userAddress != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;
        if (weixinVerify != null ? !weixinVerify.equals(that.weixinVerify) : that.weixinVerify != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

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
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (cityNodeId != null ? cityNodeId.hashCode() : 0);
        result = 31 * result + (userAddress != null ? userAddress.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (weixinVerify != null ? weixinVerify.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
