package model2.product;

import java.util.Date;

public class ProductDTO {
    private int pcode;
    private String pname;
    private String description;
    private int price;
    private int amount;
    private String user_id;
    private Date postdate;
    private int visitcount;
    private String ofile;
    private String sfile;
    private int downcount;
    private int replycount;

    public ProductDTO() {
    }

    public ProductDTO(int pcode, String pname, String description, int price, int amount, String user_id, Date postdate, int visitcount, String ofile, String sfile, int downcount, int replycount) {
        this.pcode = pcode;
        this.pname = pname;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.user_id = user_id;
        this.postdate = postdate;
        this.visitcount = visitcount;
        this.ofile = ofile;
        this.sfile = sfile;
        this.downcount = downcount;
        this.replycount = replycount;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public int getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(int visitcount) {
        this.visitcount = visitcount;
    }

    public String getOfile() {
        return ofile;
    }

    public void setOfile(String ofile) {
        this.ofile = ofile;
    }

    public String getSfile() {
        return sfile;
    }

    public void setSfile(String sfile) {
        this.sfile = sfile;
    }

    public int getDowncount() {
        return downcount;
    }

    public void setDowncount(int downcount) {
        this.downcount = downcount;
    }

    public int getReplycount() {
        return replycount;
    }

    public void setReplycount(int replycount) {
        this.replycount = replycount;
    }
}