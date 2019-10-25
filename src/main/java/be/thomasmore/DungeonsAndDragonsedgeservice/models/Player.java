package be.thomasmore.DungeonsAndDragonsedgeservice.models;

import java.util.List;

public class Player {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private String firstname;
    private String username;
    private String password;
    private String email;
    private List<Character> characters;

    public Player(int id,String name, String firstname, String username, String password, String email, List<Character> characters) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.characters = characters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
