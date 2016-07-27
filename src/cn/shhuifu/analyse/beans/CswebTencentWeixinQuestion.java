package cn.shhuifu.analyse.beans;

/**
 * Created by yang on 2016/7/25.
 */
public class CswebTencentWeixinQuestion {
    private Integer questionId;
    private String questionTitle;
    private String questionAnswer;
    private String questionLabels;
    private String createUserId;
    private String createTime;
    private Integer size;
    private Integer page;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public String getQuestionLabels() {
        return questionLabels;
    }

    public void setQuestionLabels(String questionLabels) {
        this.questionLabels = questionLabels;
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
