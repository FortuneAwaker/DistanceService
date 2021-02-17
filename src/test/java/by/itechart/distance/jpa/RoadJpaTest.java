package by.itechart.distance.jpa;

import by.itechart.distance.entity.City;
import by.itechart.distance.entity.Road;
import by.itechart.distance.repository.CityRepository;
import by.itechart.distance.repository.RoadRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoadJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoadRepository roadRepository;

    @Autowired
    private CityRepository cityRepository;

    @Before
    public void initCities() {
        entityManager.persist(
                City.builder()
                        .name("Minsk")
                        .country("Belarus")
                        .build());
        entityManager.persist(
                City.builder()
                .name("Grodno")
                .country("Belarus")
                .build());
        entityManager.persist(
                Road.builder()
                .firstCityId(cityRepository.findByName("Minsk").get().getId())
                .secondCityId(cityRepository.findByName("Grodno").get().getId())
                .name("MG")
                .distance(300.0)
                .build());
        entityManager.flush();
    }

    @Test
    public void whenFindByCities_thenReturnRoad() {
        // given
        String persistedName = "MG";
        String firstCityName = "Minsk";
        String secondCityName = "Grodno";
        Optional<City> foundByNameFirst = cityRepository.findByName(firstCityName);
        Optional<City> foundByNameSecond = cityRepository.findByName(secondCityName);
        City first = foundByNameFirst.isEmpty() ? City.builder().build() : foundByNameFirst.get();
        City second = foundByNameSecond.isEmpty() ? City.builder().build() : foundByNameSecond.get();

        // when
        Optional<Road> foundOptional = roadRepository.findByFirstCityIdAndSecondCityId(first.getId(), second.getId());
        Road found = foundOptional.isEmpty() ? Road.builder().build() : foundOptional.get();

        // then
        Assertions.assertEquals(found.getName(), persistedName);
    }

    @Test
    public void whenFindByName_thenReturnCity() {
        // given
        String persistedName = "MG";

        // when
        Optional<Road> foundOptional = roadRepository.findByName(persistedName);
        Road found = foundOptional.isEmpty() ? Road.builder().build() : foundOptional.get();

        // then
        Assertions.assertEquals(found.getName(), persistedName);
    }

    @Test
    public void whenFindById_thenReturnRoad() {
        // given
        String persistedName = "MG";
        Optional<Road> foundByNameOptional = roadRepository.findByName(persistedName);
        Road foundByName = foundByNameOptional.isEmpty() ? Road.builder().build() : foundByNameOptional.get();

        // when
        Optional<Road> foundOptional = roadRepository.findById(foundByName.getId());
        Road found = foundOptional.isEmpty() ? Road.builder().build() : foundOptional.get();

        // then
        Assertions.assertEquals(found.getName(), persistedName);
    }

}
