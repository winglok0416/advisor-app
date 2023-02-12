package edu.cuhk.bustrafficindicator.dto.citybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.bustrafficindicator.dto.BaseBusApiFormat;
import edu.cuhk.bustrafficindicator.serializer.Utc8601OffsetDateTimeDeserializer;
import lombok.*;

import java.time.OffsetDateTime;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Route extends BaseBusApiFormat {
    private RouteData data;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class RouteData {
        private String co;

        private String route;

        @JsonProperty("orig_en")
        private String origEn;

        @JsonProperty("orig_tc")
        private String origTc;

        @JsonProperty("orig_sc")
        private String origSc;

        @JsonProperty("dest_en")
        private String destEn;

        @JsonProperty("dest_tc")
        private String destTc;

        @JsonProperty("dest_sc")
        private String destSc;

        @JsonProperty("data_timestamp")
        @JsonDeserialize(using = Utc8601OffsetDateTimeDeserializer.class)
        private OffsetDateTime dataTimestamp;
    }
}