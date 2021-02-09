package by.itechart.Distance.service.impl;

import by.itechart.Distance.dto.CityDto;
import by.itechart.Distance.repository.CityRepository;
import by.itechart.Distance.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Override
    public Page<CityDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CityDto save(CityDto dto) {
        return null;
    }

    @Override
    public CityDto findById(Long id) {
        return null;
    }

    @Override
    public CityDto findByName(String roadName) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

}
