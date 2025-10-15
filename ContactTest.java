// Author: John Chomen — CS:320 — Project One
// ContactTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    void construct_validContact_ok() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test
    void id_mustNotBeNull_orOver10_and_isImmutable() {
        assertThrows(NullPointerException.class, () -> new Contact(null, "A","B","1234567890","Addr"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901","A","B","1234567890","Addr"));
        Contact c = new Contact("1","A","B","1234567890","Addr");
        // no setter exists; just ensure getter returns original
        assertEquals("1", c.getContactId());
    }

    @Test
    void firstName_constraints() {
        assertThrows(NullPointerException.class, () -> new Contact("1", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "ABCDEFGHIJK", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void lastName_constraints() {
        assertThrows(NullPointerException.class, () -> new Contact("1", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "ABCDEFGHIJK", "1234567890", "123 Main St"));
    }

    @Test
    void phone_constraints() {
        assertThrows(NullPointerException.class, () -> new Contact("1", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "12345abcde", "123 Main St"));
    }

    @Test
    void address_constraints() {
        assertThrows(NullPointerException.class, () -> new Contact("1", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "John", "Doe", "1234567890", "x".repeat(31)));
    }

    @Test
    void setters_updateFields() {
        Contact c = new Contact("1","J","D","0123456789","A");
        c.setFirstName("First");
        c.setLastName("Last");
        c.setPhone("1112223333");
        c.setAddress("123 Avenue");
        assertEquals("First", c.getFirstName());
        assertEquals("Last", c.getLastName());
        assertEquals("1112223333", c.getPhone());
        assertEquals("123 Avenue", c.getAddress());
    }
}
