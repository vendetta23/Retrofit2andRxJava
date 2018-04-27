package com.hcmute.tin3p.retrofit2andrxjava.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hcmute.tin3p.retrofit2andrxjava.R;
import com.hcmute.tin3p.retrofit2andrxjava.model.Post;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<Post> postList;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.txt_author.setText(String.valueOf(postList.get(position).userId));
        holder.txt_title.setText(String.valueOf(postList.get(position).title));
        holder.txt_content.setText(new StringBuilder(postList.get(position).body.substring(0,20))
        .append("...").toString());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
