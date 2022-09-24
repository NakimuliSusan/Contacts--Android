package dev.pinky.mycontacts.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import dev.pinky.mycontacts.databinding.ActivityAddContactBinding
import dev.pinky.mycontacts.models.Contact
import dev.pinky.mycontacts.viewmodel.ContactsViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel : ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSaveContact.setOnClickListener {
            validateAddContact()
        }
    }
    fun validateAddContact () {
        var name = binding.etName.text.toString()
        var email = binding.etEmail.text.toString()
        var address = binding.etAddress.text.toString()
        var phonenumber = binding.etPhoneNumber.text.toString()

        // validate form
        var error = false

        if (name.isBlank()) {
            error = true
            binding.TilName.error = "name is required"
        }
        if (email.isBlank()) {
            error = true
            binding.tilemail.error = " Email is required"
        }
        if (address.isBlank()) {
            error = true
            binding.tiladdress.error = "Address is required"
        }
        if (phonenumber.isBlank()) {
            error = true
            binding.tilPhoneNumber.error = "PhoneNumber is required"
        }

        if (!error) {

            val contact = Contact(
                contactId = 0,
                name = name,
                phoneNumber = phonenumber,
                email = email,
                address = address,
                image = ""
            )
            contactsViewModel.saveContact(contact)
        }
    }

}