package com.example.recyclerviewkotlin

import android.content.Context
import android.content.Intent
import android.provider.AlarmClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.CardviewUserBinding
import com.example.recyclerviewkotlin.databinding.CardviewUserSpecialBinding
import com.example.recyclerviewkotlin.ListUserAdapter as ListUserAdapter1


class ListUserAdapter(private val listUser: ArrayList<User>, private val onItemClick: (User) -> Unit, private val onNameClick: (String) -> Unit) : RecyclerView.Adapter<ArtistViewHolder>() {

    private lateinit var binding: CardviewUserBinding
    private lateinit var bindingSpecial: CardviewUserSpecialBinding

    var data: List<User> = ArrayList(0)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

//    lateinit var onItemClickCallback: OnItemClickCallback
    lateinit var position: Any

//    fun setOnItemClickCallback(onItemClickCallback:OnItemClickCallback){
//        this.onItemClickCallback = onItemClickCallback
//    }

    override fun getItemViewType(position: Int): Int {
        val status: Boolean = listUser[position].verified
        return if (status) {
            0
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        binding = CardviewUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        bindingSpecial = CardviewUserSpecialBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return if (viewType == 0) {
            ArtistViewHolder(bindingSpecial.root){
                onItemClick(listUser[it])
            }
//            ListViewHolder(bindingSpecial.root)
//            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_user_special,parent,false)
//            ListViewHolder(view)

        } else {
            ArtistViewHolder(binding.root){
                onItemClick(listUser[it])
//            ListViewHolder(binding.root)
//            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_user,parent,false)
//            ListViewHolder(view)
            }
        }
    }


    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val (username, name, avatar, company, location, repository, follower, following, verified) = listUser[position]
        if (!verified) {

            binding.tvName.text = name
            binding.tvUsername.text = username
            binding.tvNumbOfRepository.text = repository
            binding.tvNumbOfFollower.text = follower
            binding.tvNumbOfFollowing.text = following

//            binding.tvName.setOnClickListener {
////              onItemClickCallback.onNameClicked(listUser[holder.adapterPosition])
//                onNameClick(listUser[position].name)
//            }
//
//            binding.root.setOnClickListener {
////                onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
//                onItemClick(listUser[position])
//            }

//            binding.root.setOnClickListener { view ->
//                val intent = Intent(view.context,DetailUser::class.java)
//                intent.putExtra("name",name)
//                intent.putExtra("username",username)
//                intent.putExtra("repository",repository)
//                intent.putExtra("follower",follower)
//                intent.putExtra("following",following)
//                startActivity(view.context,intent,null)
//            }
        } else {
            bindingSpecial.imgAvatar.setImageResource(avatar)
            bindingSpecial.tvName.text = name
            bindingSpecial.tvUsername.text = username
            bindingSpecial.tvNumbOfRepository.text = repository
            bindingSpecial.tvNumbOfFollower.text = follower
            bindingSpecial.tvNumbOfFollowing.text = following

//            bindingSpecial.tvName.setOnClickListener {
////                onItemClickCallback.onNameClicked(listUser[holder.adapterPosition])
//                onNameClick(listUser[position].name)
//            }
//
//            bindingSpecial.root.setOnClickListener {
//                // onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
//                onItemClick(listUser[position])
//            }

//            bindingSpecial.root.setOnClickListener { view ->
//                val intent = Intent(view.context,DetailUser::class.java)
//                intent.putExtra("image",avatar)
//                intent.putExtra("name",name)
//                intent.putExtra("username",username)
//                intent.putExtra("repository",repository)
//                intent.putExtra("follower",follower)
//                intent.putExtra("following",following)
//                startActivity(view.context,intent,null)
//            }
        }


//        holder.tvUsername.text = username
//        holder.tvName.text = name
//        holder.imgAvatar?.setImageResource(avatar)
//        holder.tvRepository.text = repository
//        holder.tvFollower.text = follower
//        holder.tvFollowing.text = following
//
//        holder.itemView.setOnClickListener { view ->
//            val intent = Intent(view.context,DetailUser::class.java)
//            if(Integer.valueOf(follower) > 4000) intent.putExtra("image",avatar)
//            intent.putExtra("name",name)
//            intent.putExtra("username",username)
//            intent.putExtra("repository",repository)
//            intent.putExtra("follower",follower)
//            intent.putExtra("following",following)
//            startActivity(view.context,intent,null)
//        }

//            holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])}
    }

    override fun getItemCount(): Int = listUser.size

//    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var imgAvatar: ImageView? = itemView.findViewById(R.id.img_avatar)
//        var tvName: TextView = itemView.findViewById(R.id.tv_name)
//        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
//        var tvRepository: TextView = itemView.findViewById(R.id.tv_numb_of_repository)
//        var tvFollower: TextView = itemView.findViewById(R.id.tv_numb_of_follower)
//        var tvFollowing: TextView = itemView.findViewById(R.id.tv_numb_of_following)
//    }


//    interface OnItemClickCallback{
//        fun onItemClicked(data: User)
//        fun onNameClicked(data: String)
//    }
}




