package dev.pinky.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.pinky.mycontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayContact()
    }

    fun displayContact () {
        var contact1 = Contact("Susan","0706112100","nakimulimarysusan@gmail.com","Kampala,Uganda","https://media-exp2.licdn.com/dms/image/C4D03AQEt6zmUwr7obA/profile-displayphoto-shrink_800_800/0/1657292484131?e=1663200000&v=beta&t=clGXy8F8-BED5ad19UitpYA_dZp7wO_wvm_8MS_SXwY")
        var contact2 = Contact("Nasser Kawesa","0703694246","kaweesanasser@gmail.com","Naalya","https://images.unsplash.com/photo-1589156280159-27698a70f29e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmxhY2slMjBwZW9wbGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60")
        var contact3 = Contact("Mummy ","0706947218","busingyevalentine@gmail.com","Mukono","https://images.unsplash.com/photo-1505421031134-e57263cae630?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjV8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact4 = Contact("Aicets","0759121970","nalubwamastecia@gmail.com","Nakawa","https://images.unsplash.com/photo-1533435137002-455932c8538f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NDR8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact5 = Contact("Levis Byamukama","0706879087","levisbyamukama@gmail.com","Bulindo Kira","https://images.unsplash.com/photo-1588694673509-be778c806a6d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzl8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact6 = Contact("Prossy","0750426633","prossy@gmail.com","Namanve","https://images.unsplash.com/photo-1589156229687-496a31ad1d1f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjR8fGJsYWNrJTIwcGVvcGxlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contactList = listOf(contact1,contact2,contact3,contact4,contact5,contact6)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        binding.rvContacts.adapter = ContactsRvAdapter(contactList)

    }
}