package by.itechart.Distance.service.impl;

import by.itechart.Distance.dto.RoadDto;
import by.itechart.Distance.repository.RoadRepository;
import by.itechart.Distance.service.RoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoadServiceImpl implements RoadService {

    private RoadRepository roadRepository;


    @Override
    public Page<RoadDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public RoadDto save(RoadDto dto) {
        return null;
    }

    @Override
    public RoadDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RoadDto findByName(String roadName) {
        return null;
    }
}
