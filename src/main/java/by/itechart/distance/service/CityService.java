package by.itechart.distance.service;

import by.itechart.distance.dto.CityDto;
import by.itechart.distance.dto.mapper.CityMapper;
import by.itechart.distance.entity.City;
import by.itechart.distance.exception.ResourceNotFoundException;
import by.itechart.distance.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService implements BaseService<CityDto> {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    @Transactional
    public CityDto save(final CityDto dto) {
        City city = Optional.ofNullable(dto.getId())
                .map(item -> {
                    final City existing = cityRepository
                            .findById(dto.getId())
                            .orElseThrow();
                    cityMapper.map(dto, existing);
                    return existing;
                })
                .orElseGet(() -> cityMapper.map(dto));

        final City saved = cityRepository.save(city);
        return cityMapper.map(saved);
    }

    @Override
    public CityDto findById(final Long id) {
        return cityRepository.findById(id).map(cityMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("City with id=" + id + " doesn't exist"));
    }

    @Override
    public CityDto findByName(final String name) {
        return cityRepository.findByName(name).map(cityMapper::map)
                .orElseThrow(() -> new ResourceNotFoundException("City with name=" + name + " doesn't exist"));
    }

    @Override
    @Transactional
    public void delete(final Long id) {
        cityRepository.deleteById(id);
    }

}
