package packt.rediscookbook.springdataredisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Data
@AllArgsConstructor
@Value
@Builder
@JsonDeserialize(builder = User.UserBuilder.class)
public class User implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String nation;
    private long register_time;
    
    @JsonPOJOBuilder(withPrefix = "")
    public static final class UserBuilder {
    }

}
