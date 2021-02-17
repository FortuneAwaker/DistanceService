package by.itechart.distance.service.positive;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.mapper.CityMapper;
import by.itechart.distance.entity.City;
import by.itechart.distance.repository.CityRepository;
import by.itechart.distance.service.CityService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTestPositive {

    @InjectMocks
    private CityService cityService;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CityMapper cityMapper;

    @Test
    public void getCityByName_Positive() {
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

    @Test
    public void getCityById_Positive() {
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
        Mockito.when(cityRepository.findById(1L)).thenReturn(Optional.of(city));
        Mockito.when(cityMapper.map(city)).thenReturn(cityDto);
        // then
        Assertions.assertEquals(cityDto, cityService.findById(1L));

    }

    @Test
    public void getAllCities() {
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
        List<City> cityList = Collections.singletonList(city);
        List<CityDto> cityDtoList = Collections.singletonList(cityDto);
        // when
        Mockito.when(cityRepository.findAll()).thenReturn(cityList);
        Mockito.when(cityMapper.map(city)).thenReturn(cityDto);
        // then
        Assertions.assertEquals(cityDtoList, cityService.getAllCities());

    }

}
