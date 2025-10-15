// Author: John Chomen — CS:320 — Project One
// ContactServiceTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setup() {
        service = new ContactService();
        service.addContact("1","Jane","Doe","1112223333","456 Oak");
    }

    @Test
    void addContact_uniqueId_ok_and_duplicate_throws() {
        service.addContact("2","John","Smith","2223334444","789 Pine");
        assertTrue(service.getAll().containsKey("2"));
        assertThrows(IllegalArgumentException.class, () -> service.addContact("1","X","Y","0001112222","Z"));
    }

    @Test
    void deleteContact_missing_throws_then_ok() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("404"));
        service.addContact("3","A","B","3334445555","Addr");
        service.deleteContact("3");
        assertFalse(service.getAll().containsKey("3"));
    }

    @Test
    void update_fields_ok_and_missingId_throws() {
        service.updateFirstName("1","NewFirst");
        service.updateLastName("1","NewLast");
        service.updatePhone("1","9998887777");
        service.updateAddress("1","NewAddr");
        Contact c = service.getAll().get("1");
        assertEquals("NewFirst", c.getFirstName());
        assertEquals("NewLast", c.getLastName());
        assertEquals("9998887777", c.getPhone());
        assertEquals("NewAddr", c.getAddress());

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("X","A"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("X","B"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("X","0001112222"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("X","Addr"));
    }
}
