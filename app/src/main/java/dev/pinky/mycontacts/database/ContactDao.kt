package dev.pinky.mycontacts.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.pinky.mycontacts.models.Contact

@Dao
interface ContactDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertContact (contact : Contact)

    @Query("SELECT * FROM  contacts")
    fun getAllContacts () : LiveData<List<Contact>>

    @Query("select * FROM  contacts WHERE  contactId = :contactId")
    fun getContactById (contactId : Int) : LiveData<Contact>
}