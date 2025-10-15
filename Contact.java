// John Chomen — CS 320
import java.util.Objects;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = requireId(contactId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    private String requireId(String id) {
        Objects.requireNonNull(id, "contactId");
        if (id.length() > 10) throw new IllegalArgumentException("contactId length > 10");
        return id;
    }

    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    public void setFirstName(String firstName) {
        Objects.requireNonNull(firstName, "firstName");
        if (firstName.length() > 10) throw new IllegalArgumentException("firstName length > 10");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        Objects.requireNonNull(lastName, "lastName");
        if (lastName.length() > 10) throw new IllegalArgumentException("lastName length > 10");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        Objects.requireNonNull(phone, "phone");
        if (!phone.matches("\\d{10}")) throw new IllegalArgumentException("phone must be exactly 10 digits");
        this.phone = phone;
    }

    public void setAddress(String address) {
        Objects.requireNonNull(address, "address");
        if (address.length() > 30) throw new IllegalArgumentException("address length > 30");
        this.address = address;
    }
}
