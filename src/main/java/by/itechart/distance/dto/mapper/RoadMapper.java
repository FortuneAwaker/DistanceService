package by.itechart.distance.dto.mapper;

import by.itechart.distance.dto.RoadDto;
import by.itechart.distance.entity.Road;
import org.springframework.stereotype.Component;

@Component
public class RoadMapper implements BaseMapper<Road, RoadDto> {
    @Override
    public Road map(final RoadDto dto) {
        return Road.builder()
                .id(dto.getId())
                .firstCityId(dto.getFirstCityId())
                .secondCityId(dto.getSecondCityId())
                .distance(dto.getDistance())
                .name(dto.getName())
                .build();
    }

    @Override
    public RoadDto map(final Road entity) {
        return RoadDto.builder()
                .id(entity.getId())
                .firstCityId(entity.getFirstCityId())
                .secondCityId(entity.getSecondCityId())
                .distance(entity.getDistance())
                .name(entity.getName())
                .build();
    }

    @Override
    public void map(final RoadDto from,final Road to) {
        to.setId(from.getId());
        to.setFirstCityId(from.getFirstCityId());
        to.setSecondCityId(from.getSecondCityId());
        to.setDistance(from.getDistance());
        to.setName(from.getName());
    }
}
