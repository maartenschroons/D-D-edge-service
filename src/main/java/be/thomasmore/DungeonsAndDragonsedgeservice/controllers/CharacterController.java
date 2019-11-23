package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.Character;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/character")
@CrossOrigin
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

    //    http://localhost:8010/character/create + json character
    @PostMapping("/create")
    public ResponseEntity<String> createCharacter(@RequestBody Character character){
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8002/characters/", character, String.class);
        return  ResponseEntity.ok().build();
    }



}
