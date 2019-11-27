package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.Character;
import be.thomasmore.DungeonsAndDragonsedgeservice.models.GenericResponseWrapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Character controller", description = "alle functies die horen bij character")
@RestController
@RequestMapping("/character")
@CrossOrigin
public class CharacterController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    //    http://localhost:8010/character/id?id=5
    @ApiOperation(value="Haal het character op dat hoort bij de gegeven id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "het character werd succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U heeft geen toestemming om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de gewenste bron is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @RequestMapping("/id")
    public Character getCharacterById(@RequestParam("id") Integer id){
        Character character = restTemplate.getForObject("http://localhost:8002/characters/search/findCharacterById?id=" + id, Character.class);
        return character;
    }

    //    http://localhost:8010/character/playerid?playerid=1
    @ApiOperation(value="Haal het character op dat hoort bij de gegeven playerid", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "het character werd succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U heeft geen toestemming om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de gewenste bron is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @RequestMapping("/playerid")
    public List<Character> getCharactersByPlayerid(@RequestParam("playerid") Integer playerid){
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://localhost:8002/characters/search/findCharactersByPlayeridOrderByName?playerid="+playerid, GenericResponseWrapper.class);

        List<Character> characters = objectMapper.convertValue(wrapper.get_embedded().get("characters"), new TypeReference<List<Character>>() {});
        return characters;
    }

    //    http://localhost:8010/character/create + json character
    @ApiOperation(value="Een character toevoegen", response = List.class)
    @PostMapping("/create")
    public ResponseEntity<String> createCharacter(@RequestBody Character character){
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8002/characters/", character, String.class);
        return  ResponseEntity.ok().build();
    }


    //http://localhost:8010/character/update + json character
    @ApiOperation(value="Een character updaten", response = List.class)
    @PutMapping("/update")
    public ResponseEntity<String> putCharacterById(@RequestBody Character character){
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);
        restTemplate.put("http://localhost:8002/characters/"+character.getId(), character, String.class);
        return  ResponseEntity.ok().build();
    }
    //http://localhost:8010/character/delete/?id=5
    @ApiOperation(value="Het character verwijderen dat bij de gegeven id hoort", response = List.class)
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCharacterById(@RequestParam("id") Integer id){
        restTemplate.delete("http://localhost:8002/characters/"+ id, String.class);
        return  ResponseEntity.ok().build();
    }



}
