package edu.cuhk.advisor.dto.citybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.advisor.dto.BaseBusApiFormat;
import edu.cuhk.advisor.serializer.Utc8601OffsetDateTimeDeserializer;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Stop extends BaseBusApiFormat {
    private StopData data;
}

@Data
class StopData {
    private String stop;

    @JsonProperty("name_tc")
    private String nameTc;

    @JsonProperty("name_en")
    private String nameEn;

    @JsonProperty("name_sc")
    private String nameSc;

    @JsonProperty("lat")
    private Float latitude;

    @JsonProperty("long")
    private Float longitude;

    @JsonProperty("data_timestamp")
    @JsonDeserialize(using = Utc8601OffsetDateTimeDeserializer.class)
    private OffsetDateTime dataTimestamp;
}
