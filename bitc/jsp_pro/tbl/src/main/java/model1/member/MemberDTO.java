package model1.member;

import java.util.Date;

public class MemberDTO {
    private String user_id;
    private String user_pass;
    private String user_name;
    private Date regidate;
    private int milage;

    public MemberDTO() {
    }

    public MemberDTO(String user_id, String user_pass, String user_name, Date regidate, int milage) {
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_name = user_name;
        this.regidate = regidate;
        this.milage = milage;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getRegidate() {
        return regidate;
    }

    public void setRegidate(Date regidate) {
        this.regidate = regidate;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }
}
