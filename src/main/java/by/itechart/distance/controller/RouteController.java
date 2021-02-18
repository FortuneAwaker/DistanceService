package by.itechart.distance.controller;

import by.itechart.distance.dto.FindRouteRequest;
import by.itechart.distance.dto.RouteDto;
import by.itechart.distance.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<RouteDto> findRoute(@RequestBody FindRouteRequest request) {
        return new ResponseEntity<>(routeService.findRoutes(request), HttpStatus.OK);
    }

}
