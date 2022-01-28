package com.example.recyclerviewkotlin

import android.content.Context
import android.content.Intent
import android.provider.AlarmClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewkotlin.databinding.CardviewUserBinding
import com.example.recyclerviewkotlin.databinding.CardviewUserSpecialBinding
import com.example.recyclerviewkotlin.ListUserAdapter as ListUserAdapter1


class ListUserAdapter(private val listUser: ArrayList<User>, private val onItemClick: (User) -> Unit, private val onNameClick: (String) -> Unit) : RecyclerView.Adapter<AdvancedViewHolder>() {

    lateinit var binding: CardviewUserBinding
    lateinit var bindingSpecial: CardviewUserSpecialBinding

//    var data: List<User> = ArrayList(0)
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    // Code for using Interface
//    lateinit var onItemClickCallback: OnItemClickCallback

    // Code for using Interface
//    fun setOnItemClickCallback(onItemClickCallback:OnItemClickCallback){
//        this.onItemClickCallback = onItemClickCallback
//    }

    // Code to improve performance by reducing memory usage by sending Object instead of ArrayList
    private fun sendListUser(pos: Int, listUser: ArrayList<User>) : User{
        return listUser[pos]
    }

    override fun getItemViewType(position: Int): Int {
        val status: Boolean = listUser[position].verified
        return if (status) {
            0
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvancedViewHolder {
        binding = CardviewUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        bindingSpecial =
            CardviewUserSpecialBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return if (viewType == 0) {
            // Code for Higher Order Function with Listener called in onCreateViewHolder with Binding
            AdvancedViewHolder(bindingSpecial.root,bindingSpecial.tvName,onNameClick,onItemClick) {
                sendListUser(it,listUser)
            }

            // Code for Higher Order Function with Binding but Calling OnClickListener inside OnBindViewHolder
//            ListViewHolder(bindingSpecial.root)

            // Code when not using Binding
//            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_user_special,parent,false)
//            ListViewHolder(view)

        } else {
            // Code for Higher Order Function with Listener called in onCreateViewHolder with Binding
            AdvancedViewHolder(binding.root,binding.tvName,onNameClick,onItemClick) {
                sendListUser(it,listUser)
            }

            // Code for Higher Order Function with Binding but Calling OnClickListener inside OnBindViewHolder
//            ListViewHolder(binding.root)

            // Code when not using Binding
//            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_user,parent,false)
//            ListViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: AdvancedViewHolder, position: Int) {
        val (username, name, avatar, company, location, repository, follower, following, verified) = listUser[position]
        if (!verified) {

            binding.tvName.text = name
            binding.tvUsername.text = username
            binding.tvNumbOfRepository.text = repository
            binding.tvNumbOfFollower.text = follower
            binding.tvNumbOfFollowing.text = following

            // Code for Higher Order Function with Binding but Calling OnClickListener inside OnBindViewHolder
//            binding.tvName.setOnClickListener {
//                onNameClick(listUser[position].name)
//            }

            // Code for Higher Order Function with Binding but Calling OnClickListener inside OnBindViewHolder
//          binding.root.setOnClickListener {
//                onItemClick(listUser[position])
//            }

            // Code for using Interface
//            binding.tvName.setOnClickListener {
//                onItemClickCallback.onNameClicked(listUser[holder.adapterPosition])
//            }

            // Code for using Interface
//            binding.root.setOnClickListener {
//                onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
//            }

            // Code for using traditional way
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

            // Code for Higher Order Function with Binding but Calling OnClickListener inside OnBindViewHolder
//            bindingSpecial.tvName.setOnClickListener {
//                onNameClick(listUser[position].name)
//            }

            // Code for Higher Order Function with Binding but Calling OnClickListener inside OnBindViewHolder
//            bindingSpecial.root.setOnClickListener {
//                onItemClick(listUser[position])
//            }

            // Code for using Interface
//            bindingSpecial.tvName.setOnClickListener {
//                onItemClickCallback.onNameClicked(listUser[holder.adapterPosition])
//            }

            // Code for using Interface
//            bindingSpecial.root.setOnClickListener {
//                onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
//            }

            // Code for calling OnClickListener in Adapter ( traditional way ====OLD==== )
//            bindingSpecial.root.setOnClickListener { view ->
//                val intent = Intent(view.context,DetailUser::class.java)
//                intent.putExtra("name",name)
//                intent.putExtra("username",username)
//                intent.putExtra("repository",repository)
//                intent.putExtra("follower",follower)
//                intent.putExtra("following",following)
//                startActivity(view.context,intent,null)
//            }
        }

            // Code when not using Binding
//        holder.tvUsername.text = username
//        holder.tvName.text = name
//        holder.imgAvatar?.setImageResource(avatar)
//        holder.tvRepository.text = repository
//        holder.tvFollower.text = follower
//        holder.tvFollowing.text = following

            // Code when not using Binding
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

        // Code when using Interface without Binding
//        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])}
    }

    override fun getItemCount(): Int = listUser.size

}

        // Code for Higher Order Function with Binding and other traditional ways but Calling OnClickListener inside OnBindViewHolder
//    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var imgAvatar: ImageView? = itemView.findViewById(R.id.img_avatar)
//        var tvName: TextView = itemView.findViewById(R.id.tv_name)
//        var tvUsername: TextView = itemView.findViewById(R.id.tv_username)
//        var tvRepository: TextView = itemView.findViewById(R.id.tv_numb_of_repository)
//        var tvFollower: TextView = itemView.findViewById(R.id.tv_numb_of_follower)
//        var tvFollowing: TextView = itemView.findViewById(R.id.tv_numb_of_following)
//    }

//      Code for using Interface
//    interface OnItemClickCallback{
//        fun onItemClicked(data: User)
//        fun onNameClicked(data: String)
//    }




