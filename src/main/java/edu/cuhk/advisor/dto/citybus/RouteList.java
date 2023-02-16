package edu.cuhk.advisor.dto.citybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.advisor.dto.BaseBusApiFormat;
import edu.cuhk.advisor.serializer.Utc8601OffsetDateTimeDeserializer;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RouteList extends BaseBusApiFormat {
    private Set<Route.RouteData> data = new HashSet<>();

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
