package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.GenericResponseWrapper;
import be.thomasmore.DungeonsAndDragonsedgeservice.models.Race;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/race")
public class RaceController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    // http://localhost:8010/race/all
    @RequestMapping("/all")
    public List<Race> getAll() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://localhost:8001/races/search/findByNameNotNull", GenericResponseWrapper.class);

        List<Race> races = objectMapper.convertValue(wrapper.get_embedded().get("races"), new TypeReference<List<Race>>() {});

        return races;
    }

    // http://localhost:8010/race/name?name=Dwarf
    @RequestMapping("/name")
    public Race getRaceByName(@RequestParam(value="name") String name) {
        Race race = restTemplate.getForObject("http://localhost:8001/races/search/findRacesByName?name="+name, Race.class);
        return race;
    }

    // http://localhost:8010/race/id?id=5dd6737d1c9d4400008a5a40
    @RequestMapping("/id")
    public Race getRaceById(@RequestParam(value="id") String id) {
        Race race = restTemplate.getForObject("http://localhost:8001/races/search/findRacesById?id="+id, Race.class);
        return race;
    }


}
