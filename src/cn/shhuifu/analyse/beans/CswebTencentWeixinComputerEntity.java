package cn.shhuifu.analyse.beans;

import javax.persistence.*;

@Entity
@Table(name = "csweb_tencent_weixin_computer", schema = "data_weixin_user", catalog = "")
public class CswebTencentWeixinComputerEntity extends Params {
    private long custId;
    private String appId;
    private String computerId;
    private String computerName;
    private String computerView;
    private String computerIp;
    private String onlineTime;

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
    @Column(name = "COMPUTER_NAME", nullable = false, length = 64)
    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    @Basic
    @Column(name = "COMPUTER_VIEW", nullable = true, length = 64)
    public String getComputerView() {
        return computerView;
    }

    public void setComputerView(String computerView) {
        this.computerView = computerView;
    }

    @Basic
    @Column(name = "COMPUTER_IP", nullable = false, length = 15)
    public String getComputerIp() {
        return computerIp;
    }

    public void setComputerIp(String computerIp) {
        this.computerIp = computerIp;
    }

    @Basic
    @Column(name = "ONLINE_TIME", nullable = false, length = 19)
    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CswebTencentWeixinComputerEntity that = (CswebTencentWeixinComputerEntity) o;

        if (custId != that.custId) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (computerId != null ? !computerId.equals(that.computerId) : that.computerId != null) return false;
        if (computerName != null ? !computerName.equals(that.computerName) : that.computerName != null) return false;
        if (computerView != null ? !computerView.equals(that.computerView) : that.computerView != null) return false;
        if (computerIp != null ? !computerIp.equals(that.computerIp) : that.computerIp != null) return false;
        if (onlineTime != null ? !onlineTime.equals(that.onlineTime) : that.onlineTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (custId ^ (custId >>> 32));
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (computerId != null ? computerId.hashCode() : 0);
        result = 31 * result + (computerName != null ? computerName.hashCode() : 0);
        result = 31 * result + (computerView != null ? computerView.hashCode() : 0);
        result = 31 * result + (computerIp != null ? computerIp.hashCode() : 0);
        result = 31 * result + (onlineTime != null ? onlineTime.hashCode() : 0);
        return result;
    }
}
