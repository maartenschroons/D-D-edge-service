package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.DungeonsAndDragonsEdgeServiceApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/race")
public class RaceController {

    // Deze service maakt de calls naar de andere 4 microcontroller databases.
    // Geef de juiste url's mee
    // Maak  voor elke microcontroller een apparte controller!!!
    private static Logger log = LoggerFactory.getLogger(DungeonsAndDragonsEdgeServiceApplication.class);


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    //voorbeeld van aanvraag
    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Geen naam gevonden") String name) {
        String greeting = restTemplate.getForObject("http://localhost:8001/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }


}