package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Race {
    private String id;
    private String name;
    private int speed;
    private String size;
    private String abilityBonuses;

    public Race(String id, String name, int speed, String size, String abilityBonuses) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.size = size;
        this.abilityBonuses = abilityBonuses;
    }

    public Race() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAbilityBonuses() {
        return abilityBonuses;
    }

    public void setAbilityBonuses(String abilityBonuses) {
        this.abilityBonuses = abilityBonuses;
    }
}
