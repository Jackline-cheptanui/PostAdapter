package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.post.databinding.ActivityViewPostBinding
import com.example.post.databinding.PostItemListBinding
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

class ViewPostActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewPostBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        postId = intent.getIntExtra("POST_ID", 0)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        getPost()

    }

    fun getPost() {
        var retrofit = Apiclient.buildService(ApiInterface::class.java)
        var request = retrofit.getPostById(postId)
        request.enqueue(object : Callback<Post<Any?>> {
            override fun onResponse(call: Call<Post<Any?>>, response: Response<Post<Any?>>) {
                if (response.isSuccessful) {
                    binding.tvtitlLbl.text = response.body()?.title
                    binding.tvBodyLbl.text = response.body()?.body

                }

            }

            override fun onFailure(call: Call<Post<Any?>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()


            }

        }
        )
    }

    fun getComments() {
        var rvComments = findViewById<RecyclerView>(R.id.rvComments)
        var retrofit = Apiclient.buildService(ApiInterface::class.java)
        var request = retrofit.getPostId(postId)
        request.enqueue(object : Callback<List<comments>?> {
            override fun onResponse(
                call: Call<List<comments>?>,
                response: Response<List<comments>?>
            ) {

            }

            override fun onFailure(call: Call<List<comments>?>, t: Throwable) {

            }
        })
    }
}