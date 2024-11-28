package com.own.nacos.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.own.nacos.entity.CityInfo;
import com.own.nacos.vo.CityInfoRespDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CityInfoMapper extends BaseMapper<CityInfo> {
    @Select("""
           
            SELECT
                 ci.city_code AS cityCode,
                 ci.city_name AS cityName,
                 ci.population AS permanentPopulation,
                 ci.GDP AS totalGDP,
                 ci.admin_region_count AS adminRegionCount,
                 ci.year AS cityInfoYear,
                 cs.new_energy_vehicle_sales AS newEnergyVehicleSales,
                 cs.new_energy_vehicle_stock AS newEnergyVehicleStock,
                 cs.car_stock as carStock,
                 cs.car_sales_num as carSalesNum,
                 CAST((cs.new_energy_vehicle_sales / NULLIF(cs.car_sales_num, 0)) * 100 AS DECIMAL(10,2)) AS carSalesNumRate,
                 CAST((cs.new_energy_vehicle_stock / NULLIF(cs.car_stock, 0)) * 100 AS DECIMAL(10,2)) AS carStockRate,
                 cs.date_time AS carSalesStatisticsDateTime,
                 cp.policy AS policyOrientation,
                 cp.time AS cityPolicyAndEvaluationTime,
                 ci.per_capita_GDP AS perCapitaGDP,
                 0 AS dailyChargeAmount,
                 0 AS dailyChargeDuration,
                 ci.comprehensive_evaluation AS comprehensiveEvaluation
             FROM
                 city_info ci
             JOIN
                 (SELECT city_code, MAX(year) AS max_year
                  FROM city_info
                  WHERE city_code = #{cityCode}
                  GROUP BY city_code) ci_latest ON ci.city_code = ci_latest.city_code AND ci.year = ci_latest.max_year
             LEFT JOIN
                 car_sales_statistics cs ON ci.city_code = cs.city_code
             JOIN
                 (SELECT city_code, MAX(date_time) AS max_date_time
                  FROM car_sales_statistics
                  WHERE city_code = #{cityCode}
                  GROUP BY city_code) cs_latest ON cs.city_code = cs_latest.city_code AND cs.date_time = cs_latest.max_date_time
             LEFT JOIN
                 city_policy_and_evaluation cp ON ci.city_code = cp.city_code
             JOIN
                 (SELECT city_code, MAX(time) AS max_time
                  FROM city_policy_and_evaluation
                  WHERE city_code = #{cityCode}
                  GROUP BY city_code) cp_latest ON cp.city_code = cp_latest.city_code AND cp.time = cp_latest.max_time
             WHERE
                 ci.city_code = #{cityCode}
            """)
    CityInfoRespDTO getCityOverviewByCode(@Param("cityCode") String cityCode);

    @Select(value = """
         <script>
            select * from city_info where (city_code,year) in 
             (
               <foreach item="item" index="index" collection="cityInfoList" separator=",">
                   (#{item.cityCode}, #{item.year})
               </foreach>
              )
         </script>
    """)
    List<CityInfo> selectByListEntity(@Param("cityInfoList") List<CityInfo> cityInfoList);


}