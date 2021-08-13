package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvmypost:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPost()
    }
    fun fetchPost(){
        var retrofit=Apiclient.buildService(ApiInterface::class.java)
        var request=retrofit.getPosts()
        request.enqueue(object :Callback<List<Post<Any?>>>{
            override fun onResponse(call: Call<List<Post<Any?>>>, response: Response<List<Post<Any?>>>) {
                if (response.isSuccessful){
                    var postList=response.body()!!
                    rvmypost=findViewById(R.id.rvmypost)
                    rvmypost.layoutManager=LinearLayoutManager(baseContext)
                    var userAdapter=MyAdapter(baseContext,postList)
                    rvmypost.adapter=userAdapter
                    Toast.makeText(baseContext,postList!!.size.toString(),Toast.LENGTH_LONG).show()

                }

            }

            override fun onFailure(call: Call<List<Post<Any?>>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).toString()
                }




        })

    }
}