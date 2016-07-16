package cn.shhuifu.analyse.beans;

import javax.persistence.*;

@Entity
@Table(name = "csweb_tencent_weixin_share_data", schema = "data_weixin_user", catalog = "")
public class CswebTencentWeixinShareDataEntity extends Params {
    private int custId;
    private String appId;
    private String shareStatus;
    private String shareType;
    private String shareUrl;
    private String shareTitle;
    private String shareInfo01;
    private String shareInfo02;
    private String shareInfo03;
    private String shareInfo04;
    private String sharePic01;
    private String sharePic02;
    private String sharePic03;
    private String sharePic04;
    private String sharePic05;
    private String sharePic06;
    private String sharePic07;
    private String sharePic08;
    private String sharePic09;
    private String shareTime;
    private String createTime;
    private String createUser;

    @Id
    @Column(name = "CUST_ID", nullable = false)
    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
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
    @Column(name = "SHARE_STATUS", nullable = false, length = 8)
    public String getShareStatus() {
        return shareStatus;
    }

    public void setShareStatus(String shareStatus) {
        this.shareStatus = shareStatus;
    }

    @Basic
    @Column(name = "SHARE_TYPE", nullable = false, length = 8)
    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    @Basic
    @Column(name = "SHARE_URL", nullable = true, length = 255)
    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    @Basic
    @Column(name = "SHARE_TITLE", nullable = false, length = 255)
    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle;
    }

    @Basic
    @Column(name = "SHARE_INFO01", nullable = true, length = -1)
    public String getShareInfo01() {
        return shareInfo01;
    }

    public void setShareInfo01(String shareInfo01) {
        this.shareInfo01 = shareInfo01;
    }

    @Basic
    @Column(name = "SHARE_INFO02", nullable = true, length = -1)
    public String getShareInfo02() {
        return shareInfo02;
    }

    public void setShareInfo02(String shareInfo02) {
        this.shareInfo02 = shareInfo02;
    }

    @Basic
    @Column(name = "SHARE_INFO03", nullable = true, length = -1)
    public String getShareInfo03() {
        return shareInfo03;
    }

    public void setShareInfo03(String shareInfo03) {
        this.shareInfo03 = shareInfo03;
    }

    @Basic
    @Column(name = "SHARE_INFO04", nullable = true, length = -1)
    public String getShareInfo04() {
        return shareInfo04;
    }

    public void setShareInfo04(String shareInfo04) {
        this.shareInfo04 = shareInfo04;
    }

    @Basic
    @Column(name = "SHARE_PIC_01", nullable = true, length = 255)
    public String getSharePic01() {
        return sharePic01;
    }

    public void setSharePic01(String sharePic01) {
        this.sharePic01 = sharePic01;
    }

    @Basic
    @Column(name = "SHARE_PIC_02", nullable = true, length = 255)
    public String getSharePic02() {
        return sharePic02;
    }

    public void setSharePic02(String sharePic02) {
        this.sharePic02 = sharePic02;
    }

    @Basic
    @Column(name = "SHARE_PIC_03", nullable = true, length = 255)
    public String getSharePic03() {
        return sharePic03;
    }

    public void setSharePic03(String sharePic03) {
        this.sharePic03 = sharePic03;
    }

    @Basic
    @Column(name = "SHARE_PIC_04", nullable = true, length = 255)
    public String getSharePic04() {
        return sharePic04;
    }

    public void setSharePic04(String sharePic04) {
        this.sharePic04 = sharePic04;
    }

    @Basic
    @Column(name = "SHARE_PIC_05", nullable = true, length = 255)
    public String getSharePic05() {
        return sharePic05;
    }

    public void setSharePic05(String sharePic05) {
        this.sharePic05 = sharePic05;
    }

    @Basic
    @Column(name = "SHARE_PIC_06", nullable = true, length = 255)
    public String getSharePic06() {
        return sharePic06;
    }

    public void setSharePic06(String sharePic06) {
        this.sharePic06 = sharePic06;
    }

    @Basic
    @Column(name = "SHARE_PIC_07", nullable = true, length = 255)
    public String getSharePic07() {
        return sharePic07;
    }

    public void setSharePic07(String sharePic07) {
        this.sharePic07 = sharePic07;
    }

    @Basic
    @Column(name = "SHARE_PIC_08", nullable = true, length = 255)
    public String getSharePic08() {
        return sharePic08;
    }

    public void setSharePic08(String sharePic08) {
        this.sharePic08 = sharePic08;
    }

    @Basic
    @Column(name = "SHARE_PIC_09", nullable = true, length = 255)
    public String getSharePic09() {
        return sharePic09;
    }

    public void setSharePic09(String sharePic09) {
        this.sharePic09 = sharePic09;
    }

    @Basic
    @Column(name = "SHARE_TIME", nullable = true, length = 19)
    public String getShareTime() {
        return shareTime;
    }

    public void setShareTime(String shareTime) {
        this.shareTime = shareTime;
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
    @Column(name = "CREATE_USER", nullable = false, length = 64)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CswebTencentWeixinShareDataEntity that = (CswebTencentWeixinShareDataEntity) o;

        if (custId != that.custId) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (shareStatus != null ? !shareStatus.equals(that.shareStatus) : that.shareStatus != null) return false;
        if (shareType != null ? !shareType.equals(that.shareType) : that.shareType != null) return false;
        if (shareUrl != null ? !shareUrl.equals(that.shareUrl) : that.shareUrl != null) return false;
        if (shareTitle != null ? !shareTitle.equals(that.shareTitle) : that.shareTitle != null) return false;
        if (shareInfo01 != null ? !shareInfo01.equals(that.shareInfo01) : that.shareInfo01 != null) return false;
        if (shareInfo02 != null ? !shareInfo02.equals(that.shareInfo02) : that.shareInfo02 != null) return false;
        if (shareInfo03 != null ? !shareInfo03.equals(that.shareInfo03) : that.shareInfo03 != null) return false;
        if (shareInfo04 != null ? !shareInfo04.equals(that.shareInfo04) : that.shareInfo04 != null) return false;
        if (sharePic01 != null ? !sharePic01.equals(that.sharePic01) : that.sharePic01 != null) return false;
        if (sharePic02 != null ? !sharePic02.equals(that.sharePic02) : that.sharePic02 != null) return false;
        if (sharePic03 != null ? !sharePic03.equals(that.sharePic03) : that.sharePic03 != null) return false;
        if (sharePic04 != null ? !sharePic04.equals(that.sharePic04) : that.sharePic04 != null) return false;
        if (sharePic05 != null ? !sharePic05.equals(that.sharePic05) : that.sharePic05 != null) return false;
        if (sharePic06 != null ? !sharePic06.equals(that.sharePic06) : that.sharePic06 != null) return false;
        if (sharePic07 != null ? !sharePic07.equals(that.sharePic07) : that.sharePic07 != null) return false;
        if (sharePic08 != null ? !sharePic08.equals(that.sharePic08) : that.sharePic08 != null) return false;
        if (sharePic09 != null ? !sharePic09.equals(that.sharePic09) : that.sharePic09 != null) return false;
        if (shareTime != null ? !shareTime.equals(that.shareTime) : that.shareTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custId;
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (shareStatus != null ? shareStatus.hashCode() : 0);
        result = 31 * result + (shareType != null ? shareType.hashCode() : 0);
        result = 31 * result + (shareUrl != null ? shareUrl.hashCode() : 0);
        result = 31 * result + (shareTitle != null ? shareTitle.hashCode() : 0);
        result = 31 * result + (shareInfo01 != null ? shareInfo01.hashCode() : 0);
        result = 31 * result + (shareInfo02 != null ? shareInfo02.hashCode() : 0);
        result = 31 * result + (shareInfo03 != null ? shareInfo03.hashCode() : 0);
        result = 31 * result + (shareInfo04 != null ? shareInfo04.hashCode() : 0);
        result = 31 * result + (sharePic01 != null ? sharePic01.hashCode() : 0);
        result = 31 * result + (sharePic02 != null ? sharePic02.hashCode() : 0);
        result = 31 * result + (sharePic03 != null ? sharePic03.hashCode() : 0);
        result = 31 * result + (sharePic04 != null ? sharePic04.hashCode() : 0);
        result = 31 * result + (sharePic05 != null ? sharePic05.hashCode() : 0);
        result = 31 * result + (sharePic06 != null ? sharePic06.hashCode() : 0);
        result = 31 * result + (sharePic07 != null ? sharePic07.hashCode() : 0);
        result = 31 * result + (sharePic08 != null ? sharePic08.hashCode() : 0);
        result = 31 * result + (sharePic09 != null ? sharePic09.hashCode() : 0);
        result = 31 * result + (shareTime != null ? shareTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        return result;
    }
}
