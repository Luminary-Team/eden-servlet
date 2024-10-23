package model;

public class AtvPlan {
    private int id_act;
    private int product_id;
    private int user_id;
    private int plan_id;
    private String on_date;
    private String off_date;
    private boolean status;

    public AtvPlan(int id_act, int product_id, int user_id, int plan_id, String on_date, String off_date, boolean status) {
        this.id_act = id_act;
        this.product_id = product_id;
        this.user_id = user_id;
        this.plan_id = plan_id;
        this.on_date = on_date;
        this.off_date = off_date;
        this.status = status;
    }

    public String toString() {
        return "\nid_act: " + this.id_act +
                "\nproduct_id: " + this.product_id +
                "\nuser_id: " + this.user_id +
                "\nplan_id: " + this.plan_id +
                "\non_date: " + this.on_date +
                "\noff_date: " + this.off_date +
                "\nstatus: " + this.status;
    }

    public int getId_act() {
        return this.id_act;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public int getPlan_id() {
        return this.plan_id;
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
