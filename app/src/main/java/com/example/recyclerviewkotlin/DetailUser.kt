package com.example.recyclerviewkotlin

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class DetailUser: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val avatar=intent.getIntExtra("image",0)
        if (avatar != 0) {
            val imgAvatar: CircleImageView = findViewById<CircleImageView>(R.id.img_avatar).apply{
                visibility = View.VISIBLE
                setImageResource(avatar)
            }
        }
        val name=intent.getStringExtra("name")
        val username=intent.getStringExtra("username")
        val repository=intent.getStringExtra("repository")
        val follower=intent.getStringExtra("follower")
        val following=intent.getStringExtra("following")

        Log.d("asd", "onCreate: "+name)


        val tvName: TextView = findViewById<TextView>(R.id.tv_name).apply{
            text = name
        }
        val tvUsername: TextView = findViewById<TextView>(R.id.tv_username).apply{
            text = username
        }
        val tvRepository: TextView = findViewById<TextView>(R.id.tv_repository).apply{
            text = repository
        }
        val tvFollower: TextView = findViewById<TextView>(R.id.tv_follower).apply{
            text = follower
        }
        val tvFollowing: TextView = findViewById<TextView>(R.id.tv_following).apply{
            text = following
        }

    }
}