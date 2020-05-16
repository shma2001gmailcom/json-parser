package org.misha;

import com.google.common.io.Resources;
import org.junit.Test;
import org.misha.domain.Order;

import java.io.IOException;
import java.util.UUID;

import static com.google.common.base.Charsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.misha.domain.JsonWritable.GSON;

public class OrderTest {
    @Test
    public void testOrder() throws IOException {
        Order expected = new TestOrderFactory().createTestOrder();
        expected.setOrderId(UUID.fromString("de4a297f-214b-43b6-9fca-1e2698b8e1ac"));
        final Order actual = fromJson(readResource("order.json"));
        assertEquals(expected.toString(), actual.toString());
    }

    private String readResource(String resourceName) throws IOException {
        return Resources.toString(Resources.getResource(resourceName), UTF_8);
    }

    private static Order fromJson(String json) {
        return GSON.fromJson(json, Order.class);
    }
}
