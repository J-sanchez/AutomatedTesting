package ContactService;

import java.util.ArrayList;

public class ContactService {
    
    ArrayList<Contact> list = new ArrayList<Contact>();
    
    public boolean addContact(Contact contact) {
        boolean didAdd = false;

        if (list.size() == 0 || (!contact.getContactID().equalsIgnoreCase(contact.getContactID())) ) {
            list.add(contact);
            didAdd = true;
        } else {
            for (Contact t : list) {
                if (contact.getContactID().equalsIgnoreCase(t.getContactID())) {
                    return didAdd;
                }
            }
        }
        System.out.println(didAdd);
        return didAdd;
    }
    
    public boolean deleteContact(Contact contact) {
        boolean didDelete = false;

        if (list.size() > 1 && (contact.getContactID().equalsIgnoreCase(contact.getContactID()))) {
            list.remove(contact);
            didDelete = true;
        } else {
            for (Contact t : list) {
                if (list.size() == 0 || (!contact.getContactID().equalsIgnoreCase(t.getContactID()))) {
                    didDelete = false;
                }
            }
            list.remove(contact);
            return didDelete;
        }
        return didDelete;
    }
    
    public boolean updateContact(Contact contact) {
        boolean didUpdate = false;

        if (list.size() == 0) {
            didUpdate = false;
        } else {
            for (Contact t : list) {
                if (contact.getContactID().equalsIgnoreCase(t.getContactID())) {
                    list.set(0,contact);
                    didUpdate = true;
                }
            }
        }
        System.out.println(didUpdate);
        return didUpdate;
    }
}
    
