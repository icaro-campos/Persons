package br.itc.persons.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.itc.persons.R
import br.itc.persons.model.Person
import com.bumptech.glide.Glide

class RecyclerViewAdapter: PagingDataAdapter<Person, RecyclerViewAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(getItem(position)!!)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)

        return MyViewHolder(inflater)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val userAvatarIV: ImageView = view.findViewById(R.id.userAvatarIV)
        val userNameTV: TextView = view.findViewById(R.id.userNameTV)
        val userEmailTV: TextView = view.findViewById(R.id.userEmailTV)

        fun bind(data: Person) {
            userNameTV.text = data.firstName.plus(" ") + data.lastName
            userEmailTV.text = data.email

            Glide.with(userAvatarIV)
                .load(data.avatar)
                .circleCrop()
                .into(userAvatarIV)

        }
    }


    class DiffUtilCallBack: DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.firstName == newItem.firstName
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem == newItem
        }

    }

}