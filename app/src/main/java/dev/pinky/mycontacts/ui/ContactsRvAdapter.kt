package dev.pinky.mycontacts.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.pinky.mycontacts.models.Contact
import dev.pinky.mycontacts.R
import dev.pinky.mycontacts.databinding.ContactListItemBinding

class ContactsRvAdapter (var contactList : List<Contact>):
RecyclerView.Adapter<ContactViewHolder> ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding =
            ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) { // binds data to a view
        var currentContact = contactList.get(position)
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvPhoneNumber.text = currentContact.phoneNumber
        holder.binding.tvEmail.text = currentContact.email
        holder.binding.tvAddress.text = currentContact.address
//        holder.binding.ivContact= currentContact.image
//        Picasso.get()
//            .load(currentContact.image)
//            .placeholder(R.drawable.ic_baseline_person_24)
//            .error(R.drawable.ic_baseline_error_outline_24)
//            .resize(350,350)
//            .centerCrop()
//            .into(holder.binding.ivContact) // instance to  get an object
          val context = holder.itemView.context
          holder.binding.ivContact.setOnClickListener{
             Toast.makeText(context, "You have clicked on ${currentContact.name}' image", Toast.LENGTH_SHORT).show()
          }
        holder.binding.cvContact.setOnClickListener {
            val intent = Intent(context, ViewContactActivity::class.java)
            intent.putExtra("NAME", currentContact.name)
            intent.putExtra("EMAIL",currentContact.email)
            intent.putExtra("PHONENUMBER", currentContact.phoneNumber)
            intent.putExtra("ADDRESS", currentContact.address)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return  contactList.size
    }
}
class ContactViewHolder(var binding :ContactListItemBinding):  // reference to individual items in the cards
    RecyclerView.ViewHolder(binding.root){
}