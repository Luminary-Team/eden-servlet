package model;

public class Categ {
    private int pk_id;
    private String category;
    private String desciption;

    public Categ(int pk_id, String category, String desciption) {
        this.pk_id = pk_id;
        this.category = category;
        this.desciption = desciption;
    }

    public String toString(){
        return "\npk_id: " + this.pk_id+
                "\ncategoria: " + this.category +
                "\ndescrição: " + this.desciption;
    }

//    GETTERS
    public int getPk_id() {
        return this.pk_id;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDesciption() {
        return this.desciption;
    }
}
