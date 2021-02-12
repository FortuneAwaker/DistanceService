package by.itechart.Distance.dto.mapper;

import by.itechart.Distance.dto.CityDto;
import by.itechart.Distance.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper implements BaseMapper<City, CityDto> {
    @Override
    public City map(final CityDto dto) {
        return City.builder()
                .id(dto.getId())
                .name(dto.getName())
                .country(dto.getCountry())
                .build();
    }

    @Override
    public CityDto map(final City entity) {
        return CityDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .country(entity.getCountry())
                .build();
    }

    @Override
    public void map(final CityDto from, final City to) {
        to.setId(from.getId());
        to.setName(from.getName());
        to.setCountry(from.getCountry());
    }
}
