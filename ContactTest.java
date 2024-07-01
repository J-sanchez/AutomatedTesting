package ContactService;

import static org.junit.Assert.*;

import org.junit.Test;


public class ContactTest {
    
    @Test
    public void testContact() {
        Contact contact = new Contact("12345", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        /*Check that the contact has been added, the test should return true if it has been added*/
        // contactService.addContact(contact);
        assertTrue(contact.getContactID().equals("12345"));
        assertTrue(contact.getFirstName().equals("Jonathan"));
        assertTrue(contact.getLastName().equals("Sanchez"));
        assertTrue(contact.getPhoneNumber().equals("5555555555"));
        assertTrue(contact.getAddress().equals("123 Main St"));
    }

    @Test
    public void testIDToLong() {
        assertThrows(IllegalArgumentException.class, () -> {
        new Contact("123456789123", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        });
    }
    
    @Test
    public void testFirstNameToLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Jonathan C. Sanchez", "Sanchez", "5555555555", "123 Main St");
        });
    }
    @Test
    public void testLastNameToLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Jonathan", "Jonathan C. Sanchez", "5555555555", "123 Main St");
        });
    }
    @Test
    public void testPhoneNumberToLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Jonathan", "Sanchez", "555555555555", "123 Main St");
        });
    }
    
    @Test
    public void testAddressToLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Jonathan", "Sanchez", "5555555555", "123 Main St 123 Main St 123 Main St 123 Main St");
        });
    }
    @Test
    public void testIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Jonathan", "Sanchez", "5555555555", "123 Main St");
        });
    }
    @Test
    public void testFirstNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", null, "Sanchez", "5555555555", "123 Main St");
        });
    }
    @Test
    public void testLastNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Jonathan", null, "5555555555", "123 Main St");
        });
    }
    @Test
    public void testPhoneNumberIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789123", "Jonathan", "Sanchez", null, "123 Main St");
        });
    }
    
    @Test
    public void testAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789123", "Jonathan", "Sanchez", "5555555555", null);
        });
    }
}
