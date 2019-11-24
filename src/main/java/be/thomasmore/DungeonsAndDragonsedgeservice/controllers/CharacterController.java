package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.Character;
import be.thomasmore.DungeonsAndDragonsedgeservice.models.GenericResponseWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
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

    //    http://localhost:8010/character/id?id=5
    @RequestMapping("/id")
    public Character getCharacterById(@RequestParam("id") Integer id){
        Character character = restTemplate.getForObject("http://localhost:8002/characters/search/findCharacterById?id=" + id, Character.class);
        return character;
    }

    //    http://localhost:8010/character/playerid?playerid=1
    @RequestMapping("/playerid")
    public List<Character> getCharactersByPlayerid(@RequestParam("playerid") Integer playerid){
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://localhost:8002/characters/search/findCharactersByPlayeridOrderByName?playerid="+playerid, GenericResponseWrapper.class);

        List<Character> characters = objectMapper.convertValue(wrapper.get_embedded().get("characters"), new TypeReference<List<Character>>() {});
        return characters;
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


    //http://localhost:8010/character/update + json character
    @PutMapping("/update")
    public ResponseEntity<String> putCharacterById(@RequestBody Character character){
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);
        restTemplate.put("http://localhost:8002/characters/"+character.getId(), character, String.class);
        return  ResponseEntity.ok().build();
    }



}
