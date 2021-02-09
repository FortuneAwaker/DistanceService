package by.itechart.Distance.service;

import by.itechart.Distance.dto.CityDto;
import by.itechart.Distance.dto.RouteDto;

import java.util.List;

public interface RouteService {

    List<RouteDto> findRoutes(CityDto location, CityDto destination, int numberOfRoutes);
}
