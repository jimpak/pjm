package model2.member;

import java.util.Date;

public class MemberDTO {
    private String id;
    private String pass;
    private String user_name;
    private Date regidate;
    private int mileage;

    public MemberDTO() {
    }

    public MemberDTO(String id, String pass, String user_name, Date regidate, int mileage) {
        this.id = id;
        this.pass = pass;
        this.user_name = user_name;
        this.regidate = regidate;
        this.mileage = mileage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}