package by.itechart.Distance.dto.mapper;

import by.itechart.Distance.dto.RoadDto;
import by.itechart.Distance.entity.Road;
import org.springframework.stereotype.Component;

@Component
public class RoadMapper implements BaseMapper<Road, RoadDto> {
    @Override
    public Road map(final RoadDto dto) {
        return Road.builder()
                .id(dto.getId())
                .first_city_id(dto.getFirst_city_id())
                .second_city_id(dto.getSecond_city_id())
                .distance(dto.getDistance())
                .name(dto.getName())
                .build();
    }

    @Override
    public RoadDto map(final Road entity) {
        return RoadDto.builder()
                .id(entity.getId())
                .first_city_id(entity.getFirst_city_id())
                .second_city_id(entity.getSecond_city_id())
                .distance(entity.getDistance())
                .name(entity.getName())
                .build();
    }

    @Override
    public void map(final RoadDto from,final Road to) {
        to.setId(from.getId());
        to.setFirst_city_id(from.getFirst_city_id());
        to.setSecond_city_id(from.getSecond_city_id());
        to.setDistance(from.getDistance());
        to.setName(from.getName());
    }
}
