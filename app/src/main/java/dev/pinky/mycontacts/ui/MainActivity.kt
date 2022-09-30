package dev.pinky.mycontacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.pinky.mycontacts.models.Contact
import dev.pinky.mycontacts.databinding.ActivityMainBinding
import dev.pinky.mycontacts.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel : ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactsViewModel.fetchAllcontacts()
    }

    override fun onResume() {
        super.onResume()
        binding.fanAddContact.setOnClickListener {
            startActivity(Intent(this,AddContactActivity::class.java))
        }
        contactsViewModel.contactListLiveData.observe(this, Observer { contacts ->
            displayContact(contacts)
        })

    }
    fun displayContact (contact: List<Contact>) {
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = ContactsRvAdapter(contact)

    }

}