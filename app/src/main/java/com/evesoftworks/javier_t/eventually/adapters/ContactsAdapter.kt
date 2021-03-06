package com.evesoftworks.javier_t.eventually.adapters

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evesoftworks.javier_t.eventually.R
import com.evesoftworks.javier_t.eventually.activities.ContactProfileActivity
import com.evesoftworks.javier_t.eventually.databaseobjects.User
import kotlinx.android.synthetic.main.single_contact.view.*

class ContactsAdapter(val contacts: ArrayList<User>): RecyclerView.Adapter<ContactsAdapter.Companion.ContactViewHolder>() {

    companion object {
        class ContactViewHolder(val cardView: CardView): RecyclerView.ViewHolder(cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.single_contact, parent, false)
        return ContactViewHolder(v as CardView)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        // definir imagen
        holder.cardView.contact_username.text = contacts[position].username
        holder.cardView.contact_friends.text = "${contacts[position].friends.count()} amigos"

        holder.cardView.contact_image.setOnClickListener({
            val intent = Intent(holder.cardView.context, ContactProfileActivity::class.java)
            val bundle = Bundle()

            bundle.putParcelable("aContact", contacts[position])
            intent.putExtras(bundle)
            holder.cardView.context.startActivity(intent)
        })
    }
}