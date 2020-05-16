package org.misha.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Product extends JsonWritable {
    private UUID productId;
    private String productName;
    private String description;
    private BigDecimal price;

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(final UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public static Product create(String description, String name, BigDecimal price) {
        Product product = new Product();
        product.setProductId(UUID.randomUUID());
        product.setDescription(description);
        product.setPrice(price);
        product.setProductName(name);
        return product;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Product product = (Product) o;
        return Objects.equals(productId, product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
