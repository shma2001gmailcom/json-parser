package org.misha;

import org.misha.domain.Address;
import org.misha.domain.Client;
import org.misha.domain.Order;
import org.misha.domain.Product;
import org.misha.domain.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TestOrderFactory {
    private static final String PRODUCT = "product";
    private static final LocalDateTime date = LocalDateTime.of(1991,
                                                               12,
                                                               31,
                                                               3,
                                                               37,
                                                               21,
                                                               593000000);

    public Order createTestOrder() {
        Address address = makeAddress();
        Client client = makeClient(address);
        Order expected = makeOrder(client);
        addTestItems(expected);
        return expected;
    }

    private void addTestItems(final Order expected) {
        UUID[] productIds = new UUID[]{
                UUID.fromString("62326c84-6c20-430c-b90e-c33013b85f1e"),
                UUID.fromString("eb0a7812-21a2-4dc9-8a75-002b4a38b319"),
                UUID.fromString("82d4ab00-c1dc-4d95-8b9b-0e9a26ed05e5")
        };
        for (int i = 0; i < 3; ++i) {
            final Product product = Product.create(PRODUCT + i + " description",
                                                   PRODUCT + i,
                                                   new BigDecimal(i));
            product.setProductId(productIds[i]);
            expected.addProductPieces(product, 1 + i);
        }
    }

    private Order makeOrder(final Client client) {
        Order result = new Order();
        result.setCreationDate(date);
        result.setClient(client);
        result.setStatus(Status.NEW);
        return result;
    }

    private Client makeClient(final Address address) {
        Client client = new Client();
        client.setAddress(address);
        client.setConsumerId(UUID.fromString("a6d52ef0-b45a-48ad-aab0-4b78c0e9dd08"));
        client.setName("Misha");
        return client;
    }

    private Address makeAddress() {
        Address address = new Address();
        address.setCity("Омск");
        address.setCountry("Russia");
        address.setEmail("shma2001@gmail.com");
        address.setStreet("Энтузиастов, 25");
        address.setRoom("58");
        address.setZipCode("644088");
        return address;
    }
}
