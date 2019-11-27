package be.thomasmore.DungeonsAndDragonsedgeservice.controllers;

import be.thomasmore.DungeonsAndDragonsedgeservice.models.GenericResponseWrapper;
import be.thomasmore.DungeonsAndDragonsedgeservice.models.Race;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Api(value = "Race controller", description = "alle functies die horen bij race")
@RestController
@RequestMapping("/race")
@CrossOrigin
public class RaceController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    // http://localhost:8010/race/all
    @ApiOperation(value="Haalt alle races op", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alle races werden succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U heeft geen toestemming om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de gewenste bron is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @RequestMapping("/all")
    public List<Race> getAll() {
        GenericResponseWrapper wrapper = restTemplate.getForObject("http://localhost:8001/races/search/findByNameNotNull", GenericResponseWrapper.class);

        List<Race> races = objectMapper.convertValue(wrapper.get_embedded().get("races"), new TypeReference<List<Race>>() {});

        return races;
    }

    // http://localhost:8010/race/name?name=Dwarf
    @ApiOperation(value="Haal het race op dat hoort bij de gegeven naam", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "het race werd succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U heeft geen toestemming om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de gewenste bron is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @RequestMapping("/name")
    public Race getRaceByName(@RequestParam(value="name") String name) {
        Race race = restTemplate.getForObject("http://localhost:8001/races/search/findRacesByName?name="+name, Race.class);
        return race;
    }

    // http://localhost:8010/race/id?id=5dd6737d1c9d4400008a5a40
    @ApiOperation(value="Haal het race op dat hoort bij de gegeven id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "het race werd succesvol opgehaald"),
            @ApiResponse(code = 401, message = "U heeft geen toestemming om de bron te bekijken"),
            @ApiResponse(code = 403, message = "Toegang tot de gewenste bron is verboden"),
            @ApiResponse(code = 404, message = "De bron die u probeerde te bereiken, is niet gevonden")
    })
    @RequestMapping("/id")
    public Race getRaceById(@RequestParam(value="id") String id) {
        Race race = restTemplate.getForObject("http://localhost:8001/races/search/findRacesById?id="+id, Race.class);
        return race;
    }


}
