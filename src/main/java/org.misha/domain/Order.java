package org.misha.domain;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

public class Order extends JsonWritable implements Iterable<OrderItem> {
    private UUID orderId;
    private Client client;
    private Status status;
    private LocalDateTime creationDate;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {
        this.orderId = UUID.randomUUID();
        this.creationDate = LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(final UUID orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(final LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Nonnull
    @Override
    public Iterator<OrderItem> iterator() {
        return orderItems.iterator();
    }

    @Override
    public void forEach(final Consumer<? super OrderItem> action) {
        orderItems.forEach(action);
    }

    public BigDecimal getOrderTotal() {
        return orderItems.stream().map(item -> {
            Product product = item.getProduct();
            BigDecimal price = product.getPrice();
            Integer productPieces = item.getPieces();
            return price.multiply(new BigDecimal(productPieces));
        }).reduce((totalLeft, totalRight) -> totalLeft.add(totalRight)).orElse(new BigDecimal(0));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Order that = (Order) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(client, that.client) &&
                status == that.status &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(orderItems, that.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, client, status, creationDate, orderItems);
    }

    public void addProductPieces(final Product product, final int pieces) {
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setPieces(pieces);
        orderItems.add(item);
    }
}
