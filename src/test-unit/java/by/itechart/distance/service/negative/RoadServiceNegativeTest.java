package by.itechart.distance.service.negative;

import by.itechart.distance.dto.mapper.RoadMapper;
import by.itechart.distance.exception.ResourceNotFoundException;
import by.itechart.distance.repository.RoadRepository;
import by.itechart.distance.service.RoadService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class RoadServiceNegativeTest {

    @InjectMocks
    private RoadService roadService;
    @Mock
    private RoadRepository roadRepository;
    @Mock
    private RoadMapper roadMapper;

    @Test
    public void getRoadByName_Positive() {
        // when
        Mockito.when(roadRepository.findByName("M3")).thenReturn(Optional.empty());
        // then
        Assertions.assertThrows(ResourceNotFoundException.class, () -> roadService.findByName("M3"));

    }

    @Test
    public void getRoadById_Positive() {
        // when
        Mockito.when(roadRepository.findById(1L)).thenReturn(Optional.empty());
        // then
        Assertions.assertThrows(ResourceNotFoundException.class, () -> roadService.findById(1L));

    }

    @Test
    public void getRoadByCities_Positive() {
        // when
        Mockito.when(roadRepository.findByFirstCityIdAndSecondCityId(1L, 2L)).thenReturn(Optional.empty());
        // then
        Assertions.assertThrows(ResourceNotFoundException.class, () -> roadService.findByCities(1L, 2L));

    }

}
