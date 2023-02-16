package edu.cuhk.advisor.dto.kmb;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.advisor.dto.BaseBusApiFormat;
import edu.cuhk.advisor.serializer.Utc8601OffsetDateTimeDeserializer;
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
public class StopETA extends BaseBusApiFormat {
    private Set<ETAData> data = new HashSet<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ETAData {
        private String co;

        private String route;

        private String dir;

        @JsonProperty("service_type")
        private String serviceType;

        private Integer seq;
        
        @JsonProperty("dest_en")
        private String destEn;

        @JsonProperty("dest_tc")
        private String destTc;

        @JsonProperty("dest_sc")
        private String destSc;

        @JsonProperty("eta_seq")
        private Integer etaSeq;

        @JsonDeserialize(using = Utc8601OffsetDateTimeDeserializer.class)
        private OffsetDateTime eta;


        @JsonProperty("rmk_en")
        private String rmkEn;

        @JsonProperty("rmk_tc")
        private String rmkTc;

        @JsonProperty("rmk_sc")
        private String rmkSc;

        @JsonProperty("data_timestamp")
        @JsonDeserialize(using = Utc8601OffsetDateTimeDeserializer.class)
        private OffsetDateTime dataTimestamp;
    }
}
