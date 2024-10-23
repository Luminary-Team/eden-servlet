package model;

public class Plan {
    private int id_plan;
    private String name;
    private String description;
    private double price;
    private int duration_days;

    public Plan(int id, String name, String description, double price, int duration_days){
        this.id_plan = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration_days = duration_days;
    }

    public String toString() {
        return "\nid_plan: " + this.id_plan+
        "\nnome: " + this.name +
        "\ndescrição: " + this.description+
        "\npreço: " + this.price+
        "\nDias de duração: " + this.duration_days;

    }

    public int getId_plan() {
        return this.id_plan;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public int getDuration_days() {
        return this.duration_days;
    }
}
