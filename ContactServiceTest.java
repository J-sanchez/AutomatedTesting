package ContactService;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;


public class ContactServiceTest {


    @Before
public void testInitialContactServiceIsEmpty() {
    ContactService contactService = new ContactService();
    assertTrue(contactService.list.isEmpty());
}

    @Test

    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        /*Check that the contact has been added, the test should return true if it has been added*/
        assertTrue(contactService.addContact(contact));
        assertTrue(contact.getContactID().equals("12345"));
        assertTrue(contact.getFirstName().equals("Jonathan"));
        assertTrue(contact.getLastName().equals("Sanchez"));
        assertTrue(contact.getPhoneNumber().equals("5555555555"));
        assertTrue(contact.getAddress().equals("123 Main St"));
        //Verify that the contact exists in the list
        assertTrue(contactService.list.contains(contact));
        
        /*Check adding the same contact with the same contactID again. The test should return false if the requirement was properly implemented */
        assertFalse(contactService.addContact(contact));
    }

    @Test

    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        assertTrue(contact.getContactID().equals("12345"));
        assertTrue(contact.getFirstName().equals("Jonathan"));
        assertTrue(contact.getLastName().equals("Sanchez"));
        assertTrue(contact.getPhoneNumber().equals("5555555555"));
        assertTrue(contact.getAddress().equals("123 Main St"));
        //Check to delete a contact that no longer exists
        contactService.addContact(contact);
        contactService.deleteContact(contact);
        //Check to see if the contact exists in the list after being deleted
        // assertFalse(contactService.list.contains(contact));
        assertEquals(0, contactService.list.size());
    }


    @Test
/*Additional Test to check if I can delete a contact that does not exist */
    public void testDeleteNonExistentContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        //Try to delete a record from the list that does not exist

        assertFalse(contactService.deleteContact(contact));
        assertFalse(contactService.list.contains(contact));
        assertEquals(0, contactService.list.size());
    }

    @Test

    public void testUpdateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        /*Check that the contact has been added, the test should return true if it has been added*/
        contactService.addContact(contact);
        assertTrue(contact.getContactID().equals("12345"));
        assertTrue(contact.getFirstName().equals("Jonathan"));
        assertTrue(contact.getLastName().equals("Sanchez"));
        assertTrue(contact.getPhoneNumber().equals("5555555555"));
        assertTrue(contact.getAddress().equals("123 Main St"));
        assertTrue(contactService.list.contains(contact));

        assertFalse(contactService.updateContact(new Contact("null", "null", "null", "null", "null")));

        assertEquals(1, contactService.list.size());
    }
    //NEED TO GET BETTER TEST COVERAGE CONTACTSERVICE CURRENTLY RETURNS 66% COVERAGE

    @Test

    public void testElseCases() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        //Try to delete a record from the list that does not exist
        assertFalse(contactService.updateContact(contact));
        assertFalse(contactService.deleteContact(contact));
        assertFalse(contactService.list.contains(contact));
    }

    @Test
    public void testContactDoesNotExist() {
        // Arrange: Create a list without the contact
        ContactService contactService = new ContactService();
        Contact contact = new Contact("12345", "Jonathan", "Sanchez", "5555555555", "123 Main St");
        // Act: Call the method that checks if the contact exists
        assertFalse(contactService.list.contains(contact));

        assertEquals("12345", contact.getContactID());
        // assertThrows(NullPointerException.class, () -> contact.getContactID());

    }
}
