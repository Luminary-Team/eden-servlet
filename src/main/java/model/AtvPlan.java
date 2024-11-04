package model;

public class AtvPlan {
    private int id_act;
    private String name_product;
    private String name_user;
    private String name_plan;
    private String on_date;
    private String off_date;
    private boolean status;

    public AtvPlan(int id_act, String name_product,String name_user, String name_plan, String on_date, String off_date, boolean status) {
        this.id_act = id_act;
        this.name_product = name_product;
        this.name_user = name_user;
        this.name_plan = name_plan;
        this.on_date = on_date;
        this.off_date = off_date;
        this.status = status;
    }

    public String toString() {
        return "\nid_act: " + this.id_act +
                "\nname_product: " + this.name_product +
                "\nname_user: " + this.name_user +
                "\nuser_plan: " + this.name_plan +
                "\non_date: " + this.on_date +
                "\noff_date: " + this.off_date +
                "\nstatus: " + this.status;
    }

//    GETTERS
    public int getId_act() {
        return this.id_act;
    }

    public String getName_product() {
        return this.name_product;
    }

    public String getName_user() {
        return this.name_user;
    }

    public String getName_plan() {
        return this.name_plan;
    }

    public String getOn_date() {
        return this.on_date;
    }

    public String getOff_date() {
        return this.off_date;
    }

    public boolean isStatus() {
        return this.status;
    }
}
