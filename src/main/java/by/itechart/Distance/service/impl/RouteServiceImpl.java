package by.itechart.Distance.service.impl;

import by.itechart.Distance.dto.CityDto;
import by.itechart.Distance.dto.RouteDto;
import by.itechart.Distance.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    @Override
    public List<RouteDto> findRoutes(CityDto location, CityDto destination, int numberOfRoutes) {
        return null;
    }

}
