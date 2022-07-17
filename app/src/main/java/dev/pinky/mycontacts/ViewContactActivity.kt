package dev.pinky.mycontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.pinky.mycontacts.databinding.ActivityViewContactBinding

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding : ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }

    fun getExtras () {
        val extras = intent.extras
        val name = extras?.getString("NAME","")
        binding.tvName1.text = name
        val email = extras?.getString("EMAIL","")
        binding.tvemail.text = email
        val phonenumber = extras?.getString("PHONENUMBER","")
        binding.tvphonenumber.text = phonenumber
        val address = extras?.getString("ADDRESS","")
        binding.tvaddress.text = address
        val image = extras?.getString("IMAGE","")
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .resize(350,350)
            .centerCrop()
            .into(binding.imgProfile)
        Toast.makeText(this, "$name : $email", Toast.LENGTH_LONG).show()

        binding.imgBack.setOnClickListener {
            val  intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}