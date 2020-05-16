package org.misha.domain;

import java.util.UUID;

public class Client extends JsonWritable {
    private UUID consumerId;
    private String name;
    private Address address;

    public UUID getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(final UUID consumerId) {
        this.consumerId = consumerId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }
}
