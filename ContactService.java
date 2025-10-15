// John Chomen — CS 320
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public Map<String, Contact> getAll() { return contacts; }

    public void addContact(String id, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(id)) throw new IllegalArgumentException("duplicate id");
        Contact c = new Contact(id, firstName, lastName, phone, address);
        contacts.put(id, c);
    }

    public void deleteContact(String id) {
        if (!contacts.containsKey(id)) throw new IllegalArgumentException("missing id");
        contacts.remove(id);
    }

    private Contact getOrThrow(String id) {
        Contact c = contacts.get(id);
        if (c == null) throw new IllegalArgumentException("missing id");
        return c;
    }

    public void updateFirstName(String id, String firstName) { getOrThrow(id).setFirstName(firstName); }
    public void updateLastName(String id, String lastName) { getOrThrow(id).setLastName(lastName); }
    public void updatePhone(String id, String phone) { getOrThrow(id).setPhone(phone); }
    public void updateAddress(String id, String address) { getOrThrow(id).setAddress(address); }
}
