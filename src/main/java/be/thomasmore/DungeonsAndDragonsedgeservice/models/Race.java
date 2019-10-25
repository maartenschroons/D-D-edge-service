package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import java.util.List;

public class Race {
    private int id;
    private String name;
    private double speed;
    private String alignment;
    private double size;
    private List<String> abilityBonuses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Race(int id, String name, long speed, String alignment, long size, List<String> abilityBonuses) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.alignment = alignment;
        this.size = size;
        this.abilityBonuses = abilityBonuses;
    }

    public List<String> getAbilityBonuses() {
        return abilityBonuses;
    }

    public void setAbilityBonuses(List<String> abilityBonuses) {
        this.abilityBonuses = abilityBonuses;
    }
}
