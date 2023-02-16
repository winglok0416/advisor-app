package edu.cuhk.advisor.dto.citybus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.advisor.dto.BaseBusApiFormat;
import edu.cuhk.advisor.serializer.Utc8601OffsetDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteStop extends BaseBusApiFormat {
    private Set<RouteStopData> data = new HashSet<>();
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class RouteStopData {
    private String co;

    private String route;

    private String dir;

    private Integer seq;

    private String stop;

    @JsonProperty("data_timestamp")
    @JsonDeserialize(using = Utc8601OffsetDateTimeDeserializer.class)
    private OffsetDateTime dataTimestamp;
}