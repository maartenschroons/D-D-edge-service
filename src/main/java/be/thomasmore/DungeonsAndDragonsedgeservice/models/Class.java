package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import java.util.List;

public class Class {
private int id;
private String name;
private double hit_Die;
private List<String> proficiencies;
private double Levels;
private String subclass;

    public Class(int id, String name, double hit_Die, List<String> proficiencies, double levels, String subclass, List<String> spellcasting) {
        this.id = id;
        this.name = name;
        this.hit_Die = hit_Die;
        this.proficiencies = proficiencies;
        Levels = levels;
        this.subclass = subclass;
        this.spellcasting = spellcasting;
    }

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

    public double getHit_Die() {
        return hit_Die;
    }

    public void setHit_Die(double hit_Die) {
        this.hit_Die = hit_Die;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public double getLevels() {
        return Levels;
    }

    public void setLevels(double levels) {
        Levels = levels;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public List<String> getSpellcasting() {
        return spellcasting;
    }

    public void setSpellcasting(List<String> spellcasting) {
        this.spellcasting = spellcasting;
    }

    private List<String> spellcasting;
}
