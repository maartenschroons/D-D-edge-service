package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.Character;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    //    http://localhost:8010/character/name?name=valanthe
    @RequestMapping("/name")
    public Character getCharactersByName(@RequestParam("name") String name){
        Character character = restTemplate.getForObject("http://localhost:8002/characters/search/findCharacterByName?name=" + name, Character.class);
        return character;
    }

    //    http://localhost:8010/character/id?id=1
    @RequestMapping("/id")
    public Character getCharactersById(@RequestParam("id") Integer id){
        Character character = restTemplate.getForObject("http://localhost:8002/characters/search/findCharacterById?id=" + id, Character.class);
        return character;
    }



}
