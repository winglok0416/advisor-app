package edu.cuhk.advisor.dto.kmb;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.cuhk.advisor.dto.BaseBusApiFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteStopList extends BaseBusApiFormat {
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