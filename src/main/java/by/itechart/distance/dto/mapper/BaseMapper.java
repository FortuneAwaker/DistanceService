package by.itechart.distance.dto.mapper;

import by.itechart.distance.dto.BaseDto;
import by.itechart.distance.entity.BaseEntity;

public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {

    E map(final D dto);

    D map(final E entity);

    void map(final D from, final E to);

}
