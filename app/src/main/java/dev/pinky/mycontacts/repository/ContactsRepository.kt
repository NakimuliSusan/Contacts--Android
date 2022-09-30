package dev.pinky.mycontacts.repository

import androidx.lifecycle.LiveData
import dev.pinky.mycontacts.MyContacts
import dev.pinky.mycontacts.database.ContactDb
import dev.pinky.mycontacts.models.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactDb.getDatabase(MyContacts.appContext)


    suspend fun saveContact (contact: Contact) {
        withContext(Dispatchers.IO) {
            database.contactDao().insertContact(contact)
        }
    }
    fun getContactById(contactId: Int): LiveData<Contact> {
        return database.contactDao().getContactById(contactId)
    }

    fun fetchContacts():LiveData<List<Contact>> {
        return database.contactDao().getAllContacts()

    }
}