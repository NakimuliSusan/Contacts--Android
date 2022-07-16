package dev.pinky.mycontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
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
        Picasso.get()
            .load(currentContact.image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .resize(350,350)
            .centerCrop()
            .into(holder.binding.ivContact) // instance to  get an object
    }
    override fun getItemCount(): Int {
        return  contactList.size
    }
}
class ContactViewHolder(var binding :ContactListItemBinding):  // reference to individual items in the cards
    RecyclerView.ViewHolder(binding.root){
}