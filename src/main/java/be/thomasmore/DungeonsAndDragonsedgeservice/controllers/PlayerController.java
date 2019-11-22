package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

//    http://localhost:8010/player/id?id=1
    @RequestMapping("/id")
    public Player getPlayerById(@RequestParam("id") Integer id){
        Player player = restTemplate.getForObject("http://localhost:8003/players/search/findPlayerById?id=" + id, Player.class);
        return player;
    }



}
