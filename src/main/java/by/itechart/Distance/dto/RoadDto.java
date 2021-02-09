package by.itechart.Distance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoadDto implements BaseDto {

    private Long id;
    private String name;
    private Long first_city_id;
    private Long second_city_id;
    private Double distance;

}
