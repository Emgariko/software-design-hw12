package app.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private final String name;
    private final String currency;

    public UserDto(@JsonProperty("name") String name,
                   @JsonProperty("currency") String currency) {
        this.name = name;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }
}

