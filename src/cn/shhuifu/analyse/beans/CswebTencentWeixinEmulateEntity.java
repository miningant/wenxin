package cn.shhuifu.analyse.beans;

import javax.persistence.*;

@Entity
@Table(name = "csweb_tencent_weixin_emulate", schema = "data_weixin_user", catalog = "")
public class CswebTencentWeixinEmulateEntity extends Params {
    private long custId;
    private String appId;
    private String computerId;
    private String androidId;
    private String androidName;
    private String onlineTime;
    private String weixinUser;
    private String weixinPass;

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
    @Column(name = "COMPUTER_ID", nullable = false, length = 64)
    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    @Basic
    @Column(name = "ANDROID_ID", nullable = false, length = 64)
    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    @Basic
    @Column(name = "ANDROID_NAME", nullable = true, length = 64)
    public String getAndroidName() {
        return androidName;
    }

    public void setAndroidName(String androidName) {
        this.androidName = androidName;
    }

    @Basic
    @Column(name = "ONLINE_TIME", nullable = false, length = 19)
    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Basic
    @Column(name = "WEIXIN_USER", nullable = true, length = 64)
    public String getWeixinUser() {
        return weixinUser;
    }

    public void setWeixinUser(String weixinUser) {
        this.weixinUser = weixinUser;
    }

    @Basic
    @Column(name = "WEIXIN_PASS", nullable = true, length = 64)
    public String getWeixinPass() {
        return weixinPass;
    }

    public void setWeixinPass(String weixinPass) {
        this.weixinPass = weixinPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CswebTencentWeixinEmulateEntity that = (CswebTencentWeixinEmulateEntity) o;

        if (custId != that.custId) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (computerId != null ? !computerId.equals(that.computerId) : that.computerId != null) return false;
        if (androidId != null ? !androidId.equals(that.androidId) : that.androidId != null) return false;
        if (androidName != null ? !androidName.equals(that.androidName) : that.androidName != null) return false;
        if (onlineTime != null ? !onlineTime.equals(that.onlineTime) : that.onlineTime != null) return false;
        if (weixinUser != null ? !weixinUser.equals(that.weixinUser) : that.weixinUser != null) return false;
        if (weixinPass != null ? !weixinPass.equals(that.weixinPass) : that.weixinPass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (custId ^ (custId >>> 32));
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (computerId != null ? computerId.hashCode() : 0);
        result = 31 * result + (androidId != null ? androidId.hashCode() : 0);
        result = 31 * result + (androidName != null ? androidName.hashCode() : 0);
        result = 31 * result + (onlineTime != null ? onlineTime.hashCode() : 0);
        result = 31 * result + (weixinUser != null ? weixinUser.hashCode() : 0);
        result = 31 * result + (weixinPass != null ? weixinPass.hashCode() : 0);
        return result;
    }
}
