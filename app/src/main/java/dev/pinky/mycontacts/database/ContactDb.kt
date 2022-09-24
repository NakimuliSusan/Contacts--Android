package dev.pinky.mycontacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.pinky.mycontacts.models.Contact

@Database(entities = arrayOf(Contact::class), version = 1)
abstract class ContactDb : RoomDatabase() {

    abstract fun contactDao(): ContactDao
    companion object{
        private var database : ContactDb? = null

        fun getDatabase (context : Context):ContactDb {
            if (database == null){
                database = Room
                    . databaseBuilder(context, ContactDb::class.java, "ContactsDB")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return  database as ContactDb
        }
    }

}