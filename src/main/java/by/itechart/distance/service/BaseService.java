package by.itechart.distance.service;

import by.itechart.distance.dto.BaseDto;

public interface BaseService<Dto extends BaseDto> {

    Dto save(final Dto dto);

    Dto findById(final Long id);

    Dto findByName(String roadName);

    void delete(final Long id);
}
