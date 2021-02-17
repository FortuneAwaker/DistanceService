package by.itechart.distance.service;

import by.itechart.distance.dto.RoadDto;
import by.itechart.distance.dto.mapper.RoadMapper;
import by.itechart.distance.entity.Road;
import by.itechart.distance.exception.ResourceNotFoundException;
import by.itechart.distance.repository.RoadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoadService implements BaseService<RoadDto> {

    private final RoadRepository roadRepository;
    private final RoadMapper roadMapper;

    @Override
    @Transactional
    public RoadDto save(final RoadDto dto) {
        Road road = Optional.ofNullable(dto.getId())
                .map(item -> {
                    final Road existing = roadRepository
                            .findById(dto.getId())
                            .orElseThrow();
                    roadMapper.map(dto, existing);
                    return existing;
                })
                .orElseGet(() -> roadMapper.map(dto));

        final Road saved = roadRepository.save(road);
        return roadMapper.map(saved);
    }

    @Override
    public RoadDto findById(final Long id) {
        return roadRepository.findById(id).map(roadMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Road with id=" + id + " doesn't exist"));
    }

    @Override
    public RoadDto findByName(final String name) {
        return roadRepository.findByName(name).map(roadMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Road with name=" + name + " doesn't exist"));
    }

    public RoadDto findByCities(final Long firstCityId, final Long secondCityId) {
        return roadRepository.findByFirstCityIdAndSecondCityId(firstCityId, secondCityId).map(roadMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("Road between cities with ids "
                        + firstCityId + " and " + secondCityId
                        + " doesn't exist"));
    }

    @Override
    @Transactional
    public void delete(final Long id) {
        roadRepository.deleteById(id);
    }

    public List<RoadDto> getAllCities() {
        return roadRepository.findAll().stream().map(roadMapper::map).collect(Collectors.toList());
    }

}
