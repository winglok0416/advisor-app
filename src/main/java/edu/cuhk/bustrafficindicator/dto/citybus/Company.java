package edu.cuhk.bustrafficindicator.dto.citybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.bustrafficindicator.dto.BaseBusApiFormat;
import edu.cuhk.bustrafficindicator.serializer.Utc8601OffsetDateTimeDeserializer;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Company extends BaseBusApiFormat {
    private CompanyData data;
}

@Data
class CompanyData {
    private String co;

    @JsonProperty("name_tc")
    private String nameTc;

    @JsonProperty("name_en")
    private String nameEn;

    @JsonProperty("name_sc")
    private String nameSc;

    private String url;

    @JsonProperty("data_timestamp")
    @JsonDeserialize(using = Utc8601OffsetDateTimeDeserializer.class)
    private OffsetDateTime dataTimestamp;
}