package com.example.post

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (var context: Context, var PostList: List<Post<Any?>>): RecyclerView.Adapter<ViewHolderPost>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        var itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_post_adapter,parent,false)
        return ViewHolderPost(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        var currentPost=PostList.get(position)
        holder.tvUserIdLbl.text=currentPost.userId.toString()
        holder.tvId.text=currentPost.id.toString()
        holder.tvTitle.text=currentPost.title
        holder.tvbodyLbl.text=currentPost.body
        holder.two.setOnClickListener{
            var intent=Intent(context,ViewPostActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return PostList.size
    }


}
class ViewHolderPost(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvUserIdLbl=itemView.findViewById<TextView>(R.id.tvUserIdLbl)
    var tvId=itemView.findViewById<TextView>(R.id.tvIdLbl)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvtitleLbl)
    var tvbodyLbl=itemView.findViewById<TextView>(R.id.tvbodyLbl)
    var two=itemView.findViewById<ConstraintLayout>(R.id.two)

}


