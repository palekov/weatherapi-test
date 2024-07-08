package org.palekov.weathertest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentDto {

    @JsonProperty("last_updated_epoch")
    private Long lastUpdatedEpoch;

    @JsonProperty("last_updated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime lastUpdated;

    @JsonProperty("temp_c")
    private Float tempC;

    @JsonProperty("temp_f")
    private Float tempF;

    @JsonProperty("is_day")
    private Integer isDay;

    @JsonProperty("condition")
    ConditionDto condition;

    @JsonProperty("wind_mph")
    private Float windMph;

    @JsonProperty("wind_kph")
    private Float windKph;

    @JsonProperty("wind_degree")
    private Integer windDegree;

    @JsonProperty("wind_dir")
    private String windDir;

    @JsonProperty("pressure_mb")
    private Integer pressureMb;

    @JsonProperty("pressure_in")
    private Integer pressureIn;

    @JsonProperty("precip_mm")
    private Integer precipMm;

    @JsonProperty("precip_in")
    private Integer precipIn;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("cloud")
    private Integer cloud;

    @JsonProperty("feelslike_c")
    private Float feelsLikeC;

    @JsonProperty("feelslike_f")
    private Float feelsLikeF;

    @JsonProperty("windchill_c")
    private Integer windChillC;

    @JsonProperty("windchill_f")
    private Float windChillF;

    @JsonProperty("heatindex_c")
    private Float heatIndexC;

    @JsonProperty("heatindex_f")
    private Float heatIndexF;

    @JsonProperty("dewpoint_c")
    private Float dewPointC;

    @JsonProperty("dewpoint_f")
    private Float dewPointF;

    @JsonProperty("vis_km")
    private Integer visKm;

    @JsonProperty("vis_miles")
    private Integer visMiles;

    @JsonProperty("uv")
    private Integer uv;

    @JsonProperty("gust_mph")
    private Float gustMph;

    @JsonProperty("gust_kph")
    private Float gustKph;
}
