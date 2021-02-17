package by.itechart.distance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private Double totalDistance;
    private List<RoadDto> usedRoads;

}
