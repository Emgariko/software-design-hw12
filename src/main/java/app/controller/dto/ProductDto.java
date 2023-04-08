package app.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {
    private final String name;
    private final long amdPrice;

    public ProductDto(@JsonProperty("name") String name, @JsonProperty("rublePrice") long rublePrice) {
        this.name = name;
        this.amdPrice = rublePrice;
    }

    public String getName() {
        return name;
    }

    public long getAmdPrice() {
        return amdPrice;
    }
}
