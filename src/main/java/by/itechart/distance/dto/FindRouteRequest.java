package by.itechart.distance.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FindRouteRequest {

    private CityDto firstCityDto;
    private CityDto secondCityDto;

}
