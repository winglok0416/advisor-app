package edu.cuhk.bustrafficindicator.dto.kmb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.bustrafficindicator.dto.BaseBusApiFormat;
import edu.cuhk.bustrafficindicator.serializer.Utc8601OffsetDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RouteList extends BaseBusApiFormat {
    private Set<RouteData> data = new HashSet<>();

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
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//class RouteData {
//
//    private String route;
//
//    private String bound;
//
//    @JsonProperty("service_type")
//    private String serviceType;
//
//    @JsonProperty("orig_en")
//    private String origEn;
//
//    @JsonProperty("orig_tc")
//    private String origTc;
//
//    @JsonProperty("orig_sc")
//    private String origSc;
//
//    @JsonProperty("dest_en")
//    private String destEn;
//
//    @JsonProperty("dest_tc")
//    private String destTc;
//
//    @JsonProperty("dest_sc")
//    private String destSc;
//}
