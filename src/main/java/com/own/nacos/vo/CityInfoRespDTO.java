package com.own.nacos.vo;

import lombok.*;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityInfoRespDTO {
        private String cityInfoYear;
        private String cityPolicyAndEvaluationTime;
        private String carSalesStatisticsDateTime;
        private String cityCode;

        private String cityName;

        private Long permanentPopulation = 0L;

        private Long totalGDP = 0L;

        private Double perCapitaGDP = 0.0;

        private Integer adminRegionCount = 0;

        private Integer totalStation = 0;

        private Integer totalCharges = 0;

        private BigDecimal dailyChargeAmount = BigDecimal.ZERO;

        private BigDecimal dailyChargeDuration = BigDecimal.ZERO;

        private Integer newEnergyVehicleSales = 0;

        private Integer newEnergyVehicleStock = 0;
        private Integer carStock = 0;
        // 汽车销量
        private Integer carSalesNum = 0;

        private String carStockRate = "0%";
        // 汽车销量
        private String carSalesNumRate = "0%";
        private String policyOrientation;

        private String comprehensiveEvaluation;
}
