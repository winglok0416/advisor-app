package edu.cuhk.advisor.dto.kmb;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.cuhk.advisor.dto.BaseBusApiFormat;
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
public class StopList extends BaseBusApiFormat {
    private Set<StopData> data = new HashSet<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class StopData {
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
    }

}

