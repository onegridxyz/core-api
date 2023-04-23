package xyz.onegrid.coreapi.web.rest.publicapi.api;

public class Category {

    private final Long id;
    private final String name;
    private final Integer quantity;

    public Category() {
        this.id = null;
        this.name = null;
        this.quantity = null;
    }

    public Category(Long id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public static final class Builder {

        private Long id;
        private String name;
        private Integer quantity;

        private Builder() {}

        public static Builder aCategory() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Category build() {
            return new Category(id, name, quantity);
        }
    }
}
