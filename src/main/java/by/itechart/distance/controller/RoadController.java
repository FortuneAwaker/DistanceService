package by.itechart.distance.controller;

import by.itechart.distance.dto.RoadDto;
import by.itechart.distance.service.RoadService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@AllArgsConstructor
@RequestMapping("/road")
public class RoadController {
    private final RoadService roadService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@RequestBody RoadDto roadDto) {
        roadService.save(roadDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        roadService.delete(id);
    }
}
