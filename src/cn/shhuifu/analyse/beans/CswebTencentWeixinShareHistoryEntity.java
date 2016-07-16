package cn.shhuifu.analyse.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "csweb_tencent_weixin_share_history", schema = "data_weixin_user", catalog = "")
public class CswebTencentWeixinShareHistoryEntity extends Params {
    private long custId;
    private String weixinUser;
    private long shareId;
    private String shareStatus;
    private String shareResult;
    private String updateTime;
    private String createTime;

    @Basic
    @Column(name = "CUST_ID", nullable = false)
    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "WEIXIN_USER", nullable = false, length = 13)
    public String getWeixinUser() {
        return weixinUser;
    }

    public void setWeixinUser(String weixinUser) {
        this.weixinUser = weixinUser;
    }

    @Basic
    @Column(name = "SHARE_ID", nullable = false)
    public long getShareId() {
        return shareId;
    }

    public void setShareId(long shareId) {
        this.shareId = shareId;
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
    @Column(name = "SHARE_RESULT", nullable = true, length = 255)
    public String getShareResult() {
        return shareResult;
    }

    public void setShareResult(String shareResult) {
        this.shareResult = shareResult;
    }

    @Basic
    @Column(name = "UPDATE_TIME", nullable = true, length = 19)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CswebTencentWeixinShareHistoryEntity that = (CswebTencentWeixinShareHistoryEntity) o;

        if (custId != that.custId) return false;
        if (shareId != that.shareId) return false;
        if (weixinUser != null ? !weixinUser.equals(that.weixinUser) : that.weixinUser != null) return false;
        if (shareStatus != null ? !shareStatus.equals(that.shareStatus) : that.shareStatus != null) return false;
        if (shareResult != null ? !shareResult.equals(that.shareResult) : that.shareResult != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (custId ^ (custId >>> 32));
        result = 31 * result + (weixinUser != null ? weixinUser.hashCode() : 0);
        result = 31 * result + (int) (shareId ^ (shareId >>> 32));
        result = 31 * result + (shareStatus != null ? shareStatus.hashCode() : 0);
        result = 31 * result + (shareResult != null ? shareResult.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
