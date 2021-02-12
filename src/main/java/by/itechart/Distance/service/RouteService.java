package by.itechart.Distance.service;

import by.itechart.Distance.dto.FindRouteRequest;
import by.itechart.Distance.dto.RouteDto;
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
