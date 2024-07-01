package ContactService;
/**
 * Contact
 */
public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        /*The contact object shall have a required unique contact ID String that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable. */
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid ContactID");
        }
        /*The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null. */
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        /*The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null. */
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        /*The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null. */
        if (phoneNumber == null || phoneNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        /*The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.*/
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }

}