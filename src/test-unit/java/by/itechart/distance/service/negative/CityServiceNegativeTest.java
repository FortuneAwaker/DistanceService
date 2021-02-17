package by.itechart.distance.service.negative;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.mapper.CityMapper;
import by.itechart.distance.entity.City;
import by.itechart.distance.exception.ResourceNotFoundException;
import by.itechart.distance.repository.CityRepository;
import by.itechart.distance.service.CityService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceNegativeTest {

    @InjectMocks
    private CityService cityService;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CityMapper cityMapper;

    @Test
    public void getCityByName_Negative() {
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
        Mockito.when(cityRepository.findByName("London")).thenReturn(Optional.empty());
        Mockito.when(cityMapper.map(city)).thenReturn(cityDto);
        // then
        Assertions.assertThrows(ResourceNotFoundException.class, () -> cityService.findByName("London"));

    }

    @Test
    public void getCityById_Negative() {
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
        Mockito.when(cityRepository.findById(322L)).thenReturn(Optional.empty());
        Mockito.when(cityMapper.map(city)).thenReturn(cityDto);
        // then
        Assertions.assertThrows(ResourceNotFoundException.class, () -> cityService.findById(322L));

    }

}
