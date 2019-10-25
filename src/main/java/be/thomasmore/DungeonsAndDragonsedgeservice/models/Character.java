package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import java.util.List;

public class Character {
    private int id;
    private int raceId;
    private int equipmentId;
    private int classId;
    private int playerId;
    private Race race;
    private List<Equipment> equipment;
    private Class klasse;
    private Player player;
    private String name;
    private String alignment;
    private int Strenght;
    private int Dexterity;
    private int conjuring;
    private int wisdom;
    private int intelligence;
    private int charisma;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public Race getRace() {
        return race;
    }

    public Character(int id, Race race, List<Equipment> equipment, Class klasse, Player player, String name, String alignment, int strenght, int dexterity, int conjuring, int wisdom, int intelligence, int charisma) {
        this.id = id;
        this.race = race;
        this.equipment = equipment;
        this.klasse = klasse;
        this.player = player;
        this.name = name;
        this.alignment = alignment;
        Strenght = strenght;
        Dexterity = dexterity;
        this.conjuring = conjuring;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Class getKlasse() {
        return klasse;
    }

    public void setKlasse(Class klasse) {
        this.klasse = klasse;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public int getStrenght() {
        return Strenght;
    }

    public void setStrenght(int strenght) {
        Strenght = strenght;
    }

    public int getDexterity() {
        return Dexterity;
    }

    public void setDexterity(int dexterity) {
        Dexterity = dexterity;
    }

    public int getConjuring() {
        return conjuring;
    }

    public void setConjuring(int conjuring) {
        this.conjuring = conjuring;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }



}
