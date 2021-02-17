package by.itechart.distance.service;

import by.itechart.distance.dto.mapper.RoadMapper;
import by.itechart.distance.repository.RoadRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RouteServiceTest {



    @TestConfiguration
    static class Config {

        @MockBean
        private RoadRepository roadRepository;

        @MockBean
        private RoadMapper roadMapper;

        @Bean
        public RoadService customerService() {
            return new RoadService(roadRepository, roadMapper);
        }

    }

    @Test
    void testRouteSearch() {

    }

}
