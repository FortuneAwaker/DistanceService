package by.itechart.Distance.controller;

import by.itechart.Distance.dto.CityDto;
import by.itechart.Distance.dto.RouteDto;
import by.itechart.Distance.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("route")
public class RouteController {

    private final RouteService routeService;

    @PostMapping("{numberOfRoutes}")
    public List<RouteDto> findRoute(@PathVariable int numberOfRoutes,
                                    @RequestBody CityDto location,
                                    @RequestBody CityDto destination) {
        return routeService.findRoutes(location, destination, numberOfRoutes);
    }

}
