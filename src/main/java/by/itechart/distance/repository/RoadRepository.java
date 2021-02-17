package by.itechart.distance.repository;

import by.itechart.distance.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoadRepository extends JpaRepository<Road, Long> {

    public Optional<Road> findByName(String name);

    public Optional<Road> findByFirstCityIdAndSecondCityId(Long firstCityId, Long secondCityId);

}
