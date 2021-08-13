package com.example.post

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")

  fun getPosts(): Call<List<Post<Any?>>>
  @GET("posts/{id}")
  fun getPostById(@Path("id")postId:Int):Call<Post<Any?>>
  @GET("posts/{id}")
  fun  getPostId(@Path("id")postId: Int):Call<List<comments>>
}