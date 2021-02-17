package by.itechart.distance.service;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.mapper.CityMapper;
import by.itechart.distance.entity.City;
import by.itechart.distance.repository.CityRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {
// documentation mockito
    @InjectMocks
    private CityService cityService;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CityMapper cityMapper;

    @Test
    public void getCityByName() {
        // given
        City city = City.builder()
                .id(1L)
                .name("Minsk")
                .country("Belarus")
                .build();
        CityDto cityDto = CityDto.builder()
                .id(1L)
                .name("Minsk")
                .country("Belarus")
                .build();
        // when
        Mockito.when(cityRepository.findByName("Minsk")).thenReturn(Optional.of(city));
        Mockito.when(cityMapper.map(city)).thenReturn(cityDto);
        // then
        Assertions.assertEquals(cityDto, cityService.findByName("Minsk"));

    }

}
