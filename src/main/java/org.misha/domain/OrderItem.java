package org.misha.domain;

public class OrderItem extends JsonWritable {
    private Product product;
    private int pieces;

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(final int pieces) {
        this.pieces = pieces;
    }
}
