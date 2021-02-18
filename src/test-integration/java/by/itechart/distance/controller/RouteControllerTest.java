package by.itechart.distance.controller;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.RoadDto;
import by.itechart.distance.dto.mapper.CityMapper;
import by.itechart.distance.dto.mapper.RoadMapper;
import by.itechart.distance.entity.City;
import by.itechart.distance.entity.Road;
import by.itechart.distance.repository.CityRepository;
import by.itechart.distance.repository.RoadRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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

    @AfterEach
    public void resetDb() {
        cityRepository.deleteAll();
        roadRepository.deleteAll();
    }

    private CityDto createTestCity(final String name, final String country) {
        City city = City.builder()
                .name(name)
                .country(country)
                .build();
        return cityMapper.map(cityRepository.save(city));
    }

    private RoadDto createTestRoad(final String name, final Double distance,
                                   final Long firstCityId, final Long secondCityId) {
        Road road = Road.builder()
                .name(name)
                .distance(distance)
                .firstCityId(firstCityId)
                .secondCityId(secondCityId)
                .build();
        return roadMapper.map(roadRepository.save(road));
    }

}
