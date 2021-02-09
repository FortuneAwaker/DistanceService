package by.itechart.Distance.controller;

import by.itechart.Distance.dto.CityDto;
import by.itechart.Distance.service.CityService;
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
@RequestMapping("city")
public class CityController {

    private final CityService cityService;

    @PostMapping
    public CityDto save(@RequestBody CityDto cityDto) {
        return cityService.save(cityDto);
    }

    @GetMapping
    public Page<CityDto> getAll(@PageableDefault(sort = {"name"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return cityService.findAll(pageable);
    }

    @GetMapping("{id}")
    public CityDto getById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @GetMapping("/name/{name}")
    public CityDto getByName(@PathVariable String name) {
        return cityService.findByName(name);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }

}
