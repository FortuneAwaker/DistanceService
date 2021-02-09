package by.itechart.Distance.service;

import by.itechart.Distance.dto.BaseDto;
import by.itechart.Distance.dto.RoadDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<Dto extends BaseDto> {

    Page<Dto> findAll(Pageable pageable);

    Dto save(final Dto dto);

    Dto findById(final Long id);

    Dto findByName(String roadName);

    void delete(final Long id);
}
