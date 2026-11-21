package com.collectpoint.bean.req;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes6.dex */
public class InsertPatrolProblemCommentReq {
    private String commentContent;
    private String commentUserCode;
    private String commentUserName;
    private String problemCode;

    public InsertPatrolProblemCommentReq(String str, String str2, String str3, String str4) {
        this.commentUserCode = str;
        this.commentUserName = str2;
        this.problemCode = str3;
        this.commentContent = str4;
    }

    public String getCommentContent() {
        return this.commentContent;
    }

    public String getCommentUserCode() {
        return this.commentUserCode;
    }

    public String getCommentUserName() {
        return this.commentUserName;
    }

    public String getProblemCode() {
        return this.problemCode;
    }

    public void setCommentContent(String str) {
        this.commentContent = str;
    }

    public void setCommentUserCode(String str) {
        this.commentUserCode = str;
    }

    public void setCommentUserName(String str) {
        this.commentUserName = str;
    }

    public void setProblemCode(String str) {
        this.problemCode = str;
    }
}
