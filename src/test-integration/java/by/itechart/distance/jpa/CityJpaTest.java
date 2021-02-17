package by.itechart.distance.jpa;

import by.itechart.distance.entity.City;
import by.itechart.distance.repository.CityRepository;
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
public class CityJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String sqlFindCityByName = "select id from city where name like ";

    @Test
    public void whenFindByName_thenReturnCity() {
        // given
        String persistedName = "Minsk";
        entityManager.persist(
                City.builder()
                        .name(persistedName)
                        .country("Belarus")
                        .build());
        entityManager.flush();

        // when
        Optional<City> foundOptional = cityRepository.findByName(persistedName);
        City found = foundOptional.isEmpty() ? City.builder().build() : foundOptional.get();

        // then
        Assertions.assertEquals(found.getName(), persistedName);
    }

    @Test
    public void whenFindById_thenReturnCity() {
        // given
        String persistedName = "Minsk";
        entityManager.persist(
                City.builder()
                        .name(persistedName)
                        .country("Belarus")
                        .build());
        entityManager.flush();
        Long idFoundByName = jdbcTemplate
                .queryForObject(sqlFindCityByName + "'" + persistedName + "'", Long.class);

        // when
        Optional<City> foundOptional = cityRepository.findById(idFoundByName);
        City found = foundOptional.isEmpty() ? City.builder().build() : foundOptional.get();

        // then
        Assertions.assertEquals(found.getName(), persistedName);
    }

}
