package by.itechart.distance.controller;

import by.itechart.distance.dto.FindRouteRequest;
import by.itechart.distance.dto.RouteDto;
import by.itechart.distance.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public List<RouteDto> findRoute(@RequestBody FindRouteRequest request) {
        return routeService.findRoutes(request);
    }

}
