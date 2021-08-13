package com.example.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment

class RvCommentsAdapter(var commentList:List<comments>):RecyclerView.Adapter<CommentsViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_post_adapter,parent,false)
        return CommentsViewHolder(itemView)

    }
    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=commentList.get(position)
        holder.tvcommentEmail.text= currentComment.email
        holder.tvcommentName.text=currentComment.name
        holder.tvcommentbody.text=currentComment.body

    }

    override fun getItemCount(): Int {
       return commentList.size
    }
}
class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvcommentEmail=itemView.findViewById<TextView>(R.id.tvEmailLbl)
    var tvcommentName=itemView.findViewById<TextView>(R.id.tvName)
    var tvcommentbody=itemView.findViewById<TextView>(R.id.tvbodycomment)

}