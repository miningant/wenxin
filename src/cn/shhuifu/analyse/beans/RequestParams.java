package cn.shhuifu.analyse.beans;

public class RequestParams {
	private String nodeId;
	private String appId;
	private String createUser;
	private String shareType;
	private String shareStatus;
	private String phoneNo;
	private String weixinSignal;
	private Integer custId;


	private int page;
	private int size;
	public RequestParams() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestParams(String nodeId, String appId, String createUser,
			String shareType, String shareStatus, String phoneNo,
			String weixinSignal,Integer custId, int page, int size) {
		super();
		this.nodeId = nodeId;
		this.appId = appId;
		this.createUser = createUser;
		this.shareType = shareType;
		this.shareStatus = shareStatus;
		this.phoneNo = phoneNo;
		this.weixinSignal = weixinSignal;
		this.custId=custId;
		this.page = page;
		this.size = size;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getShareType() {
		return shareType;
	}
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}
	public String getShareStatus() {
		return shareStatus;
	}
	public void setShareStatus(String shareStatus) {
		this.shareStatus = shareStatus;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getWeixinSignal() {
		return weixinSignal;
	}
	public void setWeixinSignal(String weixinSignal) {
		this.weixinSignal = weixinSignal;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}


}
