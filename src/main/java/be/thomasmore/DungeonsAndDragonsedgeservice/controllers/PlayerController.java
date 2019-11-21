package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.DungeonsAndDragonsEdgeServiceApplication;
import be.thomasmore.DungeonsAndDragonsedgeservice.models.Player;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//import be.thomasmore.DungeonsAndDragonsedgeservice.mappers.PlayerRowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RestController
@RequestMapping("/playerController")
public class PlayerController {

    // Deze service maakt de calls naar de andere 4 microcontroller databases.
    // Geef de juiste url's mee
    // Maak  voor elke microcontroller een apparte controller!!!
    private static Logger log = LoggerFactory.getLogger(DungeonsAndDragonsEdgeServiceApplication.class);


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    //voorbeeld van aanvraag
//    @RequestMapping("/hi")
//    public String hi(@RequestParam(value="name", defaultValue="Geen naam gevonden") String name) {
//        String greeting = restTemplate.getForObject("http://localhost:8003/greeting", String.class);
//        return String.format("%s, %s!", greeting, name);
//    }

//    public PlayerController(NamedParameterJdbcTemplate template) {
//        this.template = template;
//    }

//    private NamedParameterJdbcTemplate template;

    //voorbeeld van aanvraag
//    @RequestMapping("/player/{username}")
//    public Player getPlayerByUsername(@PathVariable("username") String username){
//        Player player = restTemplate.getForObject("http://localhost:8003/players/search/findPlayerByUsername?username=" + username, Player.class);
//        return player;
//    }

    @RequestMapping("/player/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") String playerId){
        Player player = restTemplate.getForObject("http://localhost:8003/players/search/findPlayerById?playerId=" + playerId, Player.class);
        return player;
    }


}
