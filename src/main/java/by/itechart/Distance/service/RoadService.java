package by.itechart.Distance.service;

import by.itechart.Distance.dto.RoadDto;
import by.itechart.Distance.dto.mapper.RoadMapper;
import by.itechart.Distance.entity.Road;
import by.itechart.Distance.exception.ResourceNotFoundException;
import by.itechart.Distance.repository.RoadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    @Override
    @Transactional
    public void delete(final Long id) {
        roadRepository.deleteById(id);
    }

}
