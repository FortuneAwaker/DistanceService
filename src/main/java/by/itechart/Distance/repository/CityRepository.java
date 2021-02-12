package by.itechart.Distance.repository;

import by.itechart.Distance.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    public Optional<City> findByName(String name);

}
