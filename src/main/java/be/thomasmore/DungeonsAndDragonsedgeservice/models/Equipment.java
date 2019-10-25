package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import java.util.List;

public class Equipment {
    private int id;
    private String name;
    private String type;
    private String subtype;
    private double weaponRange;
    private String weaponCategory;
    private double damage;
    private double cost;
    private double weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Equipment(int id, String name, String type, String subtype, double weaponRange, String weaponCategory, double damage, double cost, double weight, List<String> properties) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.subtype = subtype;
        this.weaponRange = weaponRange;
        this.weaponCategory = weaponCategory;
        this.damage = damage;
        this.cost = cost;
        this.weight = weight;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public double getWeaponRange() {
        return weaponRange;
    }

    public void setWeaponRange(double weaponRange) {
        this.weaponRange = weaponRange;
    }

    public String getWeaponCategory() {
        return weaponCategory;
    }

    public void setWeaponCategory(String weaponCategory) {
        this.weaponCategory = weaponCategory;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    private List<String> properties;
}
