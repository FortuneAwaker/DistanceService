package by.itechart.distance.controller;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.RouteDto;
import by.itechart.distance.dto.mapper.CityMapper;
import by.itechart.distance.dto.mapper.RoadMapper;
import by.itechart.distance.entity.City;
import by.itechart.distance.entity.Road;
import by.itechart.distance.repository.CityRepository;
import by.itechart.distance.repository.RoadRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RouteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RoadMapper roadMapper;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @AfterEach
    public void resetDb() {
        cityRepository.deleteAll();
        roadRepository.deleteAll();
    }

    @Test
    public void givenCitiesAndRoads_whenFindOptimalRoute_thenStatus200() throws JsonProcessingException {
        // given
        CityDto firstCityDto = createTestCity("Minsk", "Belarus");
        CityDto secondCityDto = createTestCity("Brest", "Belarus");
        Double distanceMB = 348.0;
        createTestRoad("MB", distanceMB, firstCityDto.getId(), secondCityDto.getId());
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("firstCityDto", firstCityDto);
        requestBody.put("secondCityDto", secondCityDto);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(
                OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

        // when
        RouteDto routeDto = restTemplate.postForObject("/route", httpEntity, RouteDto.class);
        // then
        Assertions.assertEquals(distanceMB, routeDto.getTotalDistance());
        Assertions.assertTrue(routeDto.getVisitedCities().contains(firstCityDto));
        Assertions.assertTrue(routeDto.getVisitedCities().contains(secondCityDto));
    }

    private CityDto createTestCity(final String name, final String country) {
        City city = City.builder()
                .name(name)
                .country(country)
                .build();
        return cityMapper.map(cityRepository.save(city));
    }

    private void createTestRoad(final String name, final Double distance,
                                final Long firstCityId, final Long secondCityId) {
        roadMapper.map(roadRepository.save(
                Road.builder()
                .name(name)
                .distance(distance)
                .firstCityId(firstCityId)
                .secondCityId(secondCityId)
                .build()));
    }

}
