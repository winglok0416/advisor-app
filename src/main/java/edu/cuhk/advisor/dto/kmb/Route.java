package edu.cuhk.advisor.dto.kmb;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.cuhk.advisor.dto.BaseBusApiFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Route extends BaseBusApiFormat {
    private RouteData data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RouteData {

        private String route;

        private String bound;

        @JsonProperty("service_type")
        private String serviceType;

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
    }
}

