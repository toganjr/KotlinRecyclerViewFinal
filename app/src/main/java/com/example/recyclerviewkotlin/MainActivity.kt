package com.example.recyclerviewkotlin

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rv_user)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }

//    private fun showRecyclerList() {
//        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            rvUsers.layoutManager = GridLayoutManager(this,2)
//        } else {
//            rvUsers.layoutManager = LinearLayoutManager(this)
//        }
//
//        val listUserAdapter = ListUserAdapter(list)
//        rvUsers.adapter = listUserAdapter
//        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback{
//            override fun onNameClicked(data: String) {
//                Toast.makeText(
//                    applicationContext,
//                    data,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//
//            override fun onItemClicked(data: User) {
//                showSelectedUser(data)
//            }
//
//        })
//
//    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this,2)
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this)
        }

        val listUserAdapter = ListUserAdapter(list,::onItemClicked,::onNameClicked)
        rvUsers.adapter = listUserAdapter
    }

    private fun onNameClicked(data: String) {
        Toast.makeText(
            this@MainActivity,
            data,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun onItemClicked(data: User) {
        showSelectedUser(data)
    }

    private fun showSelectedUser(user: User){
//        Toast.makeText(this,user.name,Toast.LENGTH_SHORT).show()
        val moveToDetail = Intent(this@MainActivity, DetailUser::class.java).apply {
            putExtra("image", user.avatar)
            putExtra("name",user.name)
            putExtra("username",user.username)
            putExtra("repository",user.repository)
            putExtra("follower",user.follower)
            putExtra("following",user.following)
        }
        startActivity(moveToDetail)
    }

    private val listUsers: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.username)
            val dataName = resources.getStringArray(R.array.name)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataVerified = resources.getStringArray(R.array.verified)
            val listUser= ArrayList<User>()

            for (position in dataName.indices){
                val user = User(
                    dataUsername[position],
                    dataName[position],
                    dataAvatar.getResourceId(position,0),
                    dataCompany[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataFollower[position],
                    dataFollowing[position],
                    dataVerified[position].toBoolean()
                )
                listUser.add(user)
            }
            return listUser
        }



}