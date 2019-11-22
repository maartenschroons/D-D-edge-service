package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Class {
private int id;
private String name;
private double hit_Die;
private List<String> proficiencies;
private boolean spellcasting;

    public Class() {
    }

    public Class(int id, String name, double hit_Die, List<String> proficiencies, boolean spellcasting) {
        this.id = id;
        this.name = name;
        this.hit_Die = hit_Die;
        this.proficiencies = proficiencies;
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

    public boolean isSpellcasting() {
        return spellcasting;
    }

    public void setSpellcasting(boolean spellcasting) {
        this.spellcasting = spellcasting;
    }
}
