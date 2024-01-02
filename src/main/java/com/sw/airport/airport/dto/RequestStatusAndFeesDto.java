package com.sw.airport.airport.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

public class RequestStatusAndFeesDto {
    private Long id;
    private float fees;
    private Long requestId;

}
