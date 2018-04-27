package com.hcmute.tin3p.retrofit2andrxjava.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hcmute.tin3p.retrofit2andrxjava.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView txt_title,txt_content,txt_author;
    public PostViewHolder(View itemView) {
        super(itemView);
        txt_author=itemView.findViewById(R.id.id_txt_author);
        txt_title=itemView.findViewById(R.id.id_txt_title);
        txt_content=itemView.findViewById(R.id.id_txt_content);
    }
}
