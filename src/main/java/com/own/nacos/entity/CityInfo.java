package com.own.nacos.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@TableName("city_info")
public class CityInfo  implements Serializable {
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String cityCode;
    private String cityName;
    private Integer population;
    @Column(name = "GDP")
    private BigDecimal gdp;
    @Column(name = "per_capita_GDP")
    private BigDecimal perCapitaGdp;
    private BigDecimal area;
    private String year;
    private Integer adminRegionCount;
    private String updateTime;
    private String createTime;
    private String comprehensiveEvaluation;
    private String score;

    @TableField(exist = false)
    private Integer rowNum;

}
