package cn.shhuifu.analyse.beans;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "csweb_admin_applications", schema = "data_csweb_dmp", catalog = "")
public class CswebAdminApplicationsEntity {
    private String appId;
    private String companyName;
    private String companyUrl;
    private String appName;
    private int appEnabled;
    private String appInfo;
    private String appIcon;
    private String nodeId;
    private String templateWeb;
    private String templateMobi;
    private String domainName;
    private String domainNo;
    private String companyInfo;
    private String companyEmail;
    private String companyQq;
    private String companyPhone;
    private String companyUser;
    private String companyAddr;
    private BigDecimal companyLon;
    private BigDecimal companyLat;
    private String contactInfo;
    private String createTime;
    private String expDate;
    private String createUser;
    private String baiduUrl;
    private String funcParams;
    private String appSignature;
    private String smsFlag;
    private String smsSignature;
    private String showTop;
    private String menuColor;
    private String copyright;
    private String weiboaddr;
    private String isShowAboutus;
    private String backgroundimg;

    @Id
    @Column(name = "APP_ID", nullable = false, length = 16)
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "COMPANY_NAME", nullable = true, length = 128)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "COMPANY_URL", nullable = true, length = 255)
    public String getCompanyUrl() {
        return companyUrl;
    }

    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }

    @Basic
    @Column(name = "APP_NAME", nullable = false, length = 64)
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Basic
    @Column(name = "APP_ENABLED", nullable = false)
    public int getAppEnabled() {
        return appEnabled;
    }

    public void setAppEnabled(int appEnabled) {
        this.appEnabled = appEnabled;
    }

    @Basic
    @Column(name = "APP_INFO", nullable = true, length = -1)
    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    @Basic
    @Column(name = "APP_ICON", nullable = false, length = 128)
    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    @Basic
    @Column(name = "NODE_ID", nullable = false, length = 40)
    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @Basic
    @Column(name = "TEMPLATE_WEB", nullable = true, length = 32)
    public String getTemplateWeb() {
        return templateWeb;
    }

    public void setTemplateWeb(String templateWeb) {
        this.templateWeb = templateWeb;
    }

    @Basic
    @Column(name = "TEMPLATE_MOBI", nullable = true, length = 32)
    public String getTemplateMobi() {
        return templateMobi;
    }

    public void setTemplateMobi(String templateMobi) {
        this.templateMobi = templateMobi;
    }

    @Basic
    @Column(name = "DOMAIN_NAME", nullable = true, length = 128)
    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Basic
    @Column(name = "DOMAIN_NO", nullable = true, length = 64)
    public String getDomainNo() {
        return domainNo;
    }

    public void setDomainNo(String domainNo) {
        this.domainNo = domainNo;
    }

    @Basic
    @Column(name = "COMPANY_INFO", nullable = true, length = -1)
    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    @Basic
    @Column(name = "COMPANY_EMAIL", nullable = true, length = 64)
    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    @Basic
    @Column(name = "COMPANY_QQ", nullable = true, length = 64)
    public String getCompanyQq() {
        return companyQq;
    }

    public void setCompanyQq(String companyQq) {
        this.companyQq = companyQq;
    }

    @Basic
    @Column(name = "COMPANY_PHONE", nullable = true, length = 64)
    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    @Basic
    @Column(name = "COMPANY_USER", nullable = true, length = 64)
    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    @Basic
    @Column(name = "COMPANY_ADDR", nullable = true, length = 255)
    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    @Basic
    @Column(name = "COMPANY_LON", nullable = false, precision = 6)
    public BigDecimal getCompanyLon() {
        return companyLon;
    }

    public void setCompanyLon(BigDecimal companyLon) {
        this.companyLon = companyLon;
    }

    @Basic
    @Column(name = "COMPANY_LAT", nullable = false, precision = 6)
    public BigDecimal getCompanyLat() {
        return companyLat;
    }

    public void setCompanyLat(BigDecimal companyLat) {
        this.companyLat = companyLat;
    }

    @Basic
    @Column(name = "CONTACT_INFO", nullable = true, length = -1)
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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
    @Column(name = "EXP_DATE", nullable = true, length = 10)
    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Basic
    @Column(name = "CREATE_USER", nullable = false, length = 64)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "BAIDU_URL", nullable = true, length = 255)
    public String getBaiduUrl() {
        return baiduUrl;
    }

    public void setBaiduUrl(String baiduUrl) {
        this.baiduUrl = baiduUrl;
    }

    @Basic
    @Column(name = "FUNC_PARAMS", nullable = true, length = -1)
    public String getFuncParams() {
        return funcParams;
    }

    public void setFuncParams(String funcParams) {
        this.funcParams = funcParams;
    }

    @Basic
    @Column(name = "APP_SIGNATURE", nullable = true, length = -1)
    public String getAppSignature() {
        return appSignature;
    }

    public void setAppSignature(String appSignature) {
        this.appSignature = appSignature;
    }

    @Basic
    @Column(name = "SMS_FLAG", nullable = true, length = 1)
    public String getSmsFlag() {
        return smsFlag;
    }

    public void setSmsFlag(String smsFlag) {
        this.smsFlag = smsFlag;
    }

    @Basic
    @Column(name = "SMS_SIGNATURE", nullable = true, length = 64)
    public String getSmsSignature() {
        return smsSignature;
    }

    public void setSmsSignature(String smsSignature) {
        this.smsSignature = smsSignature;
    }

    @Basic
    @Column(name = "SHOW_TOP", nullable = true, length = 1)
    public String getShowTop() {
        return showTop;
    }

    public void setShowTop(String showTop) {
        this.showTop = showTop;
    }

    @Basic
    @Column(name = "MENU_COLOR", nullable = true, length = 45)
    public String getMenuColor() {
        return menuColor;
    }

    public void setMenuColor(String menuColor) {
        this.menuColor = menuColor;
    }

    @Basic
    @Column(name = "COPYRIGHT", nullable = true, length = 200)
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Basic
    @Column(name = "WEIBOADDR", nullable = true, length = -1)
    public String getWeiboaddr() {
        return weiboaddr;
    }

    public void setWeiboaddr(String weiboaddr) {
        this.weiboaddr = weiboaddr;
    }

    @Basic
    @Column(name = "IS_SHOW_ABOUTUS", nullable = true, length = 1)
    public String getIsShowAboutus() {
        return isShowAboutus;
    }

    public void setIsShowAboutus(String isShowAboutus) {
        this.isShowAboutus = isShowAboutus;
    }

    @Basic
    @Column(name = "BACKGROUNDIMG", nullable = true, length = 100)
    public String getBackgroundimg() {
        return backgroundimg;
    }

    public void setBackgroundimg(String backgroundimg) {
        this.backgroundimg = backgroundimg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CswebAdminApplicationsEntity that = (CswebAdminApplicationsEntity) o;

        if (appEnabled != that.appEnabled) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (companyUrl != null ? !companyUrl.equals(that.companyUrl) : that.companyUrl != null) return false;
        if (appName != null ? !appName.equals(that.appName) : that.appName != null) return false;
        if (appInfo != null ? !appInfo.equals(that.appInfo) : that.appInfo != null) return false;
        if (appIcon != null ? !appIcon.equals(that.appIcon) : that.appIcon != null) return false;
        if (nodeId != null ? !nodeId.equals(that.nodeId) : that.nodeId != null) return false;
        if (templateWeb != null ? !templateWeb.equals(that.templateWeb) : that.templateWeb != null) return false;
        if (templateMobi != null ? !templateMobi.equals(that.templateMobi) : that.templateMobi != null) return false;
        if (domainName != null ? !domainName.equals(that.domainName) : that.domainName != null) return false;
        if (domainNo != null ? !domainNo.equals(that.domainNo) : that.domainNo != null) return false;
        if (companyInfo != null ? !companyInfo.equals(that.companyInfo) : that.companyInfo != null) return false;
        if (companyEmail != null ? !companyEmail.equals(that.companyEmail) : that.companyEmail != null) return false;
        if (companyQq != null ? !companyQq.equals(that.companyQq) : that.companyQq != null) return false;
        if (companyPhone != null ? !companyPhone.equals(that.companyPhone) : that.companyPhone != null) return false;
        if (companyUser != null ? !companyUser.equals(that.companyUser) : that.companyUser != null) return false;
        if (companyAddr != null ? !companyAddr.equals(that.companyAddr) : that.companyAddr != null) return false;
        if (companyLon != null ? !companyLon.equals(that.companyLon) : that.companyLon != null) return false;
        if (companyLat != null ? !companyLat.equals(that.companyLat) : that.companyLat != null) return false;
        if (contactInfo != null ? !contactInfo.equals(that.contactInfo) : that.contactInfo != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (expDate != null ? !expDate.equals(that.expDate) : that.expDate != null) return false;
        if (createUser != null ? !createUser.equals(that.createUser) : that.createUser != null) return false;
        if (baiduUrl != null ? !baiduUrl.equals(that.baiduUrl) : that.baiduUrl != null) return false;
        if (funcParams != null ? !funcParams.equals(that.funcParams) : that.funcParams != null) return false;
        if (appSignature != null ? !appSignature.equals(that.appSignature) : that.appSignature != null) return false;
        if (smsFlag != null ? !smsFlag.equals(that.smsFlag) : that.smsFlag != null) return false;
        if (smsSignature != null ? !smsSignature.equals(that.smsSignature) : that.smsSignature != null) return false;
        if (showTop != null ? !showTop.equals(that.showTop) : that.showTop != null) return false;
        if (menuColor != null ? !menuColor.equals(that.menuColor) : that.menuColor != null) return false;
        if (copyright != null ? !copyright.equals(that.copyright) : that.copyright != null) return false;
        if (weiboaddr != null ? !weiboaddr.equals(that.weiboaddr) : that.weiboaddr != null) return false;
        if (isShowAboutus != null ? !isShowAboutus.equals(that.isShowAboutus) : that.isShowAboutus != null)
            return false;
        if (backgroundimg != null ? !backgroundimg.equals(that.backgroundimg) : that.backgroundimg != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appId != null ? appId.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (companyUrl != null ? companyUrl.hashCode() : 0);
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + appEnabled;
        result = 31 * result + (appInfo != null ? appInfo.hashCode() : 0);
        result = 31 * result + (appIcon != null ? appIcon.hashCode() : 0);
        result = 31 * result + (nodeId != null ? nodeId.hashCode() : 0);
        result = 31 * result + (templateWeb != null ? templateWeb.hashCode() : 0);
        result = 31 * result + (templateMobi != null ? templateMobi.hashCode() : 0);
        result = 31 * result + (domainName != null ? domainName.hashCode() : 0);
        result = 31 * result + (domainNo != null ? domainNo.hashCode() : 0);
        result = 31 * result + (companyInfo != null ? companyInfo.hashCode() : 0);
        result = 31 * result + (companyEmail != null ? companyEmail.hashCode() : 0);
        result = 31 * result + (companyQq != null ? companyQq.hashCode() : 0);
        result = 31 * result + (companyPhone != null ? companyPhone.hashCode() : 0);
        result = 31 * result + (companyUser != null ? companyUser.hashCode() : 0);
        result = 31 * result + (companyAddr != null ? companyAddr.hashCode() : 0);
        result = 31 * result + (companyLon != null ? companyLon.hashCode() : 0);
        result = 31 * result + (companyLat != null ? companyLat.hashCode() : 0);
        result = 31 * result + (contactInfo != null ? contactInfo.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (expDate != null ? expDate.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (baiduUrl != null ? baiduUrl.hashCode() : 0);
        result = 31 * result + (funcParams != null ? funcParams.hashCode() : 0);
        result = 31 * result + (appSignature != null ? appSignature.hashCode() : 0);
        result = 31 * result + (smsFlag != null ? smsFlag.hashCode() : 0);
        result = 31 * result + (smsSignature != null ? smsSignature.hashCode() : 0);
        result = 31 * result + (showTop != null ? showTop.hashCode() : 0);
        result = 31 * result + (menuColor != null ? menuColor.hashCode() : 0);
        result = 31 * result + (copyright != null ? copyright.hashCode() : 0);
        result = 31 * result + (weiboaddr != null ? weiboaddr.hashCode() : 0);
        result = 31 * result + (isShowAboutus != null ? isShowAboutus.hashCode() : 0);
        result = 31 * result + (backgroundimg != null ? backgroundimg.hashCode() : 0);
        return result;
    }
}
