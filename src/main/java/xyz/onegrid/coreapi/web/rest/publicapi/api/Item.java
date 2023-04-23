package xyz.onegrid.coreapi.web.rest.publicapi.api;

import java.time.Instant;

public class Item {

    private final Long id;
    private final String name;
    private final Instant createdAt;

    public Item() {
        this.id = null;
        this.name = null;
        this.createdAt = null;
    }

    public Item(Long id, String name, Instant createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public static final class Builder {

        private Long id;
        private String name;
        private Instant createdAt;

        private Builder() {}

        public static Builder anItem() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCreatedAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Item build() {
            return new Item(id, name, createdAt);
        }
    }
}
