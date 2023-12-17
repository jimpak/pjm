package model2.product;

import java.util.Date;

public class ReplyDTO {
    private int rnum;
    private int pcode;
    private String user_id;
    private String content;
    private Date postdate;

    public ReplyDTO() {
    }

    public ReplyDTO(int rnum, int pcode, String user_id, String content, Date postdate) {
        this.rnum = rnum;
        this.pcode = pcode;
        this.user_id = user_id;
        this.content = content;
        this.postdate = postdate;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }
}
