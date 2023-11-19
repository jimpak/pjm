package model1.product;

public class ProductDTO {
    private int pcode;
    private String pname;
    private String description;
    private int price;
    private int amount;
    private String user_id;
    private int visitcount;

    public ProductDTO() {
    }

    public ProductDTO(int pcode, String pname, String description, int price, int amount, String user_id, int visitcount) {
        this.pcode = pcode;
        this.pname = pname;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.user_id = user_id;
        this.visitcount = visitcount;
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

    public int getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(int visitcount) {
        this.visitcount = visitcount;
    }
}
