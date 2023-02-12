package edu.cuhk.bustrafficindicator.dto.kmb;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.cuhk.bustrafficindicator.dto.BaseBusApiFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RouteStop extends BaseBusApiFormat {
    private Set<RouteStopData> data = new HashSet<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RouteStopData {
        private String route;

        private String bound;

        @JsonProperty("service_type")
        private String serviceType;

        private Integer seq;

        private String stop;
    }
}