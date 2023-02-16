package edu.cuhk.advisor.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import edu.cuhk.advisor.serializer.Utc8601OffsetDateTimeDeserializer;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public abstract class BaseBusApiFormat {
    private String type;

    private String version;

    @JsonProperty("generated_timestamp")
    @JsonDeserialize(using = Utc8601OffsetDateTimeDeserializer.class)
    private OffsetDateTime generatedTimestamp;
}
