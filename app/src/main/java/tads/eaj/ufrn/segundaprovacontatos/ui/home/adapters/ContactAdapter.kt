package tads.eaj.ufrn.segundaprovacontatos.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprovacontatos.databinding.ContactItemBinding
import tads.eaj.ufrn.segundaprovacontatos.model.Contact

class ContactAdapter : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(ContactDiffUtilCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact)
    }

    class ContactViewHolder private constructor(var binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(contact: Contact) {
            binding.textName.text = contact.firstName
            binding.textLastname.text = contact.lastName
            binding.textStreet.text = contact.street
            binding.textNumberHouse.text = contact.numberHouse.toString()
            binding.textPhone.text = contact.phone
            binding.textAreaCode.text = contact.areaCode.toString()
            binding.textRelationship.text = contact.relationship

            binding.textName.setOnClickListener {
                Toast.makeText(binding.root.context, "CLicou no texto", Toast.LENGTH_SHORT).show()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ContactViewHolder {

                val inflater = LayoutInflater.from(parent.context)
                val binding = ContactItemBinding.inflate(inflater, parent, false)
                return ContactViewHolder(binding)
            }
        }
    }

    class ContactDiffUtilCallback : DiffUtil.ItemCallback<Contact>(){
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id.equals(newItem.id)
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.equals(newItem)
        }

    }
}