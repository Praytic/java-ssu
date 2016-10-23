package com.vchernogorov;

import com.vchernogorov.task2.Dish;
import com.vchernogorov.task2.Menu;
import com.vchernogorov.task2.Order;
import com.vchernogorov.task5.Serializer;
import com.vchernogorov.task5.SerializerException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class Task5Test {

    @Test
    public void dishSerialization() throws IOException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Dish expected = new Dish("name", 0, 0);
        assertTrue(file.length() == 0);
        serializer.serialize(expected);
        Dish actual = serializer.deserialize(Dish.class);
        assertEquals(expected.toString(), actual.toString());
        assertFalse(file.length() == 0);
    }

    @Test
    public void menuSerialization() throws IOException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Menu expected = new Menu(Collections.singletonList(new Dish("name", 0, 0)));
        assertTrue(file.length() == 0);
        serializer.serialize(expected);
        Menu actual = serializer.deserialize(Menu.class);
        assertEquals(expected.toString(), actual.toString());
        assertFalse(file.length() == 0);
    }

    @Test
    public void orderSerialization() throws IOException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Order expected = new Order("customer", Collections.singletonList(new Dish("name", 0, 0)));
        assertTrue(file.length() == 0);
        serializer.serialize(expected);
        Order actual = serializer.deserialize(Order.class);
        assertEquals(expected.toString(), actual.toString());
        assertFalse(file.length() == 0);
    }

    @Test
    public void serializerException() throws IOException {
        File file = createTempFile();
        Serializer serializer = new Serializer(file);
        Dish expected = new Dish("name", 0, 0);
        assertTrue(file.length() == 0);
        assertThrows(SerializerException.class, () -> serializer.deserialize(Dish.class));
        serializer.serialize(expected);
        assertThrows(SerializerException.class, () -> serializer.deserialize(Order.class));

    }

    private File createTempFile() throws IOException {
        return File.createTempFile("tmp", String.valueOf(System.nanoTime()));
    }
}
