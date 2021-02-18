package by.itechart.distance.service.positive;

import by.itechart.distance.dto.RoadDto;
import by.itechart.distance.dto.mapper.RoadMapper;
import by.itechart.distance.entity.Road;
import by.itechart.distance.repository.RoadRepository;
import by.itechart.distance.service.RoadService;
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
public class RoadServiceTestPositive {

    @InjectMocks
    private RoadService roadService;
    @Mock
    private RoadRepository roadRepository;
    @Mock
    private RoadMapper roadMapper;

    @Test
    public void getRoadByName_Positive() {
        // given
        Road road = Road.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        RoadDto roadDto = RoadDto.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        // when
        Mockito.when(roadRepository.findByName("M3")).thenReturn(Optional.of(road));
        Mockito.when(roadMapper.map(road)).thenReturn(roadDto);
        // then
        Assertions.assertEquals(roadDto, roadService.findByName("M3"));

    }

    @Test
    public void getRoadById_Positive() {
        // given
        Road road = Road.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        RoadDto roadDto = RoadDto.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        // when
        Mockito.when(roadRepository.findById(1L)).thenReturn(Optional.of(road));
        Mockito.when(roadMapper.map(road)).thenReturn(roadDto);
        // then
        Assertions.assertEquals(roadDto, roadService.findById(1L));

    }

    @Test
    public void getRoadByCities_Positive() {
        // given
        Road road = Road.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        RoadDto roadDto = RoadDto.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        // when
        Mockito.when(roadRepository.findByFirstCityIdAndSecondCityId(1L, 2L)).thenReturn(Optional.of(road));
        Mockito.when(roadMapper.map(road)).thenReturn(roadDto);
        // then
        Assertions.assertEquals(roadDto, roadService.findByCities(1L, 2L));

    }

    @Test
    public void getAllRoads() {
        // given
        Road road = Road.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        RoadDto roadDto = RoadDto.builder()
                .id(1L)
                .name("M3")
                .firstCityId(1L)
                .secondCityId(2L)
                .distance(3000.0)
                .build();
        List<Road> roadList = Collections.singletonList(road);
        List<RoadDto> roadDtoList = Collections.singletonList(roadDto);
        // when
        Mockito.when(roadRepository.findAll()).thenReturn(roadList);
        Mockito.when(roadMapper.map(road)).thenReturn(roadDto);
        // then
        Assertions.assertEquals(roadDtoList, roadService.getAllRoads());

    }

}
