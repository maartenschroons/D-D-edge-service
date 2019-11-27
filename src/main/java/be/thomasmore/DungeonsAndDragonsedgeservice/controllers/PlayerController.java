package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Player controller", description = "functies die horen bij player")
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

//    http://localhost:8010/player/id?id=1
@ApiOperation(value="Haal de player op die hoort bij de gegeven id", response = List.class)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "de player werd succesvol opgehaald"),
        @ApiResponse(code = 401, message = "U heeft geen toestemming om de bron te bekijken"),
        @ApiResponse(code = 403, message = "Toegang tot de gewenste bron is verboden"),
        @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
})
    @RequestMapping("/id")
    public Player getPlayerById(@RequestParam("id") Integer id){
        Player player = restTemplate.getForObject("http://localhost:8003/players/search/findPlayerById?id=" + id, Player.class);
        return player;
    }


    @ApiOperation(value="De player, met het meegegeven id, wijzigen met de meegegeven player")
    @PutMapping("/id")
    public ResponseEntity putPlayerById(@ApiParam(value = "Het playerId om de player te updaten", required = true)@PathVariable("id") String id,
                                                @ApiParam(value = "Het update player object", required = true)@RequestBody Player player){
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        list.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(list);
        restTemplate.put("localhost:8003/players/search/" + id, player, Player.class);

        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="de player verwijderen die hoort bij de gegeven id", response = List.class)
    @DeleteMapping("/id")
    public ResponseEntity deletePlayerById(@RequestParam("id") Integer id){
        restTemplate.delete("http://localhost:8003/players/search/" + id, Player.class);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value="Een player toevoegen", response = List.class)
    @PostMapping("/")
    public ResponseEntity<Object> PostPlayerById(@RequestBody Player player){
        ResponseEntity<Player> result = restTemplate.postForEntity("http://localhost:8003/players/search/",player, Player.class);
        return ResponseEntity.ok().build();
    }



}
