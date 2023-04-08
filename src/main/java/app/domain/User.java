package app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("user")
public class User {
    @Id
    private String id;
    private final String name;
    private final Currency currency;

    public User(String name, Currency currency) {
        this.name = name;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public enum Currency {
        RUB, USD, EUR, AMD
    }
}

