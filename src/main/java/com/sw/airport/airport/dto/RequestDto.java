package com.sw.airport.airport.dto;

import com.sw.airport.airport.entities.RequestStatusAndFeesEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder
public class RequestDto {
    private Long id;
    private Long userId;
    private int weight;
    private float price;
    private List<RequestStatusAndFeesEntity> requestStatusAndFeesDtos = new ArrayList<>();

}
