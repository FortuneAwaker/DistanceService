package by.itechart.Distance.controller;

import by.itechart.Distance.dto.RoadDto;
import by.itechart.Distance.service.RoadService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("road")
public class RoadController {

    private final RoadService roadService;

    @PostMapping
    public RoadDto save(@RequestBody RoadDto roadDto) {
        return roadService.save(roadDto);
    }

    @GetMapping
    public Page<RoadDto> getAll(@PageableDefault(sort = {"name"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return roadService.findAll(pageable);
    }

    @GetMapping("{id}")
    public RoadDto getById(@PathVariable Long id) {
        return roadService.findById(id);
    }

    @GetMapping("/name/{name}")
    public RoadDto getByName(@PathVariable String name) {
        return roadService.findByName(name);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        roadService.delete(id);
    }
}
