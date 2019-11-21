package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.GenericResponseWrapper;
import be.thomasmore.DungeonsAndDragonsedgeservice.models.Race;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/all")
    public List<Race> getAll() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://localhost:8001/races/search/findRacesBySize?size=medium", GenericResponseWrapper.class);

        List<Race> races = objectMapper.convertValue(wrapper.get_embedded().get("races"), new TypeReference<List<Race>>() {});

        return races;
    }




}
