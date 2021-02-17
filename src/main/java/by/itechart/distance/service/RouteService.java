package by.itechart.distance.service;

import by.itechart.distance.dto.FindRouteRequest;
import by.itechart.distance.dto.RouteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {

    public List<RouteDto> findRoutes(final FindRouteRequest request) {
        return null;
    }
}
