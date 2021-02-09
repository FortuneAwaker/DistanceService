package by.itechart.Distance.dto.mapper;

import by.itechart.Distance.dto.BaseDto;
import by.itechart.Distance.entity.BaseEntity;

public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {

    E map(final D dto);

    D map(final E entity);

    void map(final D from, final E to);

}
