package by.itechart.Distance.service;

import by.itechart.Distance.dto.BaseDto;

public interface BaseService<Dto extends BaseDto> {

    Dto save(final Dto dto);

    Dto findById(final Long id);

    Dto findByName(String roadName);

    void delete(final Long id);
}
