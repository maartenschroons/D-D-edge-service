package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private int id;
    private String raceid;
    private int equipmentid;
    private int classid;
    private int playerid;
    private String name;
    private String alignment;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Character() {
    }

    public Character(int id, String raceid, int equipmentid, int classid, int playerid, String name, String alignment, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.id = id;
        this.raceid = raceid;
        this.equipmentid = equipmentid;
        this.classid = classid;
        this.playerid = playerid;
        this.name = name;
        this.alignment = alignment;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaceid() {
        return raceid;
    }

    public void setRaceid(String raceid) {
        this.raceid = raceid;
    }

    public int getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(int equipmentid) {
        this.equipmentid = equipmentid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}


