package by.itechart.distance.jpa;

import by.itechart.distance.entity.City;
import by.itechart.distance.entity.Road;
import by.itechart.distance.repository.RoadRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
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
    private JdbcTemplate jdbcTemplate;

    private final static String sqlFindCityByName = "select id from city where name like ";
    private final static String sqlFindRoadByName = "select id from road where name like ";

    @Test
    public void whenFindByCities_thenReturnRoad() {
        // given
        String persistedName = "MG";
        String firstCityName = "Minsk";
        String secondCityName = "Grodno";
        entityManager.persist(
                City.builder()
                        .name(firstCityName)
                        .country("Belarus")
                        .build());
        entityManager.persist(
                City.builder()
                        .name(secondCityName)
                        .country("Belarus")
                        .build());
        Long firstIdFoundByName = jdbcTemplate
                .queryForObject(sqlFindCityByName + "'" + firstCityName + "'", Long.class);
        Long secondIdFoundByName = jdbcTemplate
                .queryForObject(sqlFindCityByName + "'" + secondCityName + "'", Long.class);
        entityManager.persist(
                Road.builder()
                        .firstCityId(firstIdFoundByName)
                        .secondCityId(secondIdFoundByName)
                        .name(persistedName)
                        .distance(300.0)
                        .build());
        entityManager.flush();

        // when
        Optional<Road> foundOptional = roadRepository
                .findByFirstCityIdAndSecondCityId(firstIdFoundByName, secondIdFoundByName);
        Road found = foundOptional.isEmpty() ? Road.builder().build() : foundOptional.get();

        // then
        Assertions.assertEquals(found.getName(), persistedName);
    }

    @Test
    public void whenFindByName_thenReturnCity() {
        // given
        String persistedName = "MG";
        String firstCityName = "Minsk";
        String secondCityName = "Grodno";
        entityManager.persist(
                City.builder()
                        .name(firstCityName)
                        .country("Belarus")
                        .build());
        entityManager.persist(
                City.builder()
                        .name(secondCityName)
                        .country("Belarus")
                        .build());
        Long firstIdFoundByName = jdbcTemplate
                .queryForObject(sqlFindCityByName + "'" + firstCityName + "'", Long.class);
        Long secondIdFoundByName = jdbcTemplate
                .queryForObject(sqlFindCityByName + "'" + secondCityName + "'", Long.class);
        entityManager.persist(
                Road.builder()
                        .firstCityId(firstIdFoundByName)
                        .secondCityId(secondIdFoundByName)
                        .name(persistedName)
                        .distance(300.0)
                        .build());
        entityManager.flush();

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
        String firstCityName = "Minsk";
        String secondCityName = "Grodno";
        entityManager.persist(
                City.builder()
                        .name(firstCityName)
                        .country("Belarus")
                        .build());
        entityManager.persist(
                City.builder()
                        .name(secondCityName)
                        .country("Belarus")
                        .build());
        Long firstIdFoundByName = jdbcTemplate
                .queryForObject(sqlFindCityByName + "'" + firstCityName + "'", Long.class);
        Long secondIdFoundByName = jdbcTemplate
                .queryForObject(sqlFindCityByName + "'" + secondCityName + "'", Long.class);
        entityManager.persist(
                Road.builder()
                        .firstCityId(firstIdFoundByName)
                        .secondCityId(secondIdFoundByName)
                        .name(persistedName)
                        .distance(300.0)
                        .build());
        entityManager.flush();
        Long idFoundByName = jdbcTemplate
                .queryForObject(sqlFindRoadByName + "'" + persistedName + "'", Long.class);

        // when
        Optional<Road> foundOptional = roadRepository.findById(idFoundByName);
        Road found = foundOptional.isEmpty() ? Road.builder().build() : foundOptional.get();

        // then
        Assertions.assertEquals(found.getName(), persistedName);
    }

}
