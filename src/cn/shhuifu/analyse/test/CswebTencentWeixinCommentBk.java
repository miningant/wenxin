package cn.shhuifu.analyse.test;

public class CswebTencentWeixinCommentBk {
    private static final long serialVersionUID = 1L;
    private Integer custId;
    private Integer shareCustId;
    private String comment;
    private String createUserId;
    private String createTime;

    public CswebTencentWeixinCommentBk() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CswebTencentWeixinCommentBk(Integer custId, Integer shareCustId,
                                       String comment, String createUserId, String createTime) {
        super();
        this.custId = custId;
        this.shareCustId = shareCustId;
        this.comment = comment;
        this.createUserId = createUserId;
        this.createTime = createTime;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getShareCustId() {
        return shareCustId;
    }

    public void setShareCustId(Integer shareCustId) {
        this.shareCustId = shareCustId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}