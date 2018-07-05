package com.example.admin.musicplayer.RecyclerViewAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.musicplayer.Model.Music;
import com.example.admin.musicplayer.R;

import java.util.List;

/**
 * Created by admin on 7/4/2018.
 */

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    Context context;
    private List<Music> datalist;

    public MusicListAdapter(Context context, List <Music> datalist) {
        this.context = context;
        this.datalist = datalist;
    }


    @NonNull
    @Override
    public MusicListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicListAdapter.ViewHolder holder, int position) {
        holder.name.setText(datalist.get(position).getName());
        holder.duration.setText(datalist.get(position).getDuration());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name ,duration;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.musicnamelist);
            duration = (TextView) itemView.findViewById(R.id.musicdurationlist);
        }
    }
}
