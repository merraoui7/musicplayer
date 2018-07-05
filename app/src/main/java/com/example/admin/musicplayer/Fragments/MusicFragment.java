package com.example.admin.musicplayer.Fragments;


import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.musicplayer.Model.Music;
import com.example.admin.musicplayer.R;
import com.example.admin.musicplayer.RecyclerViewAdapters.MusicListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {


    private List<Music> datalist =new ArrayList <>();
    RecyclerView recyclerView;
    MusicListAdapter musicListAdapter;

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicListAdapter = new MusicListAdapter(getContext(),datalist);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.musiclist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dostuff();



        return view;
    }
    public void dostuff(){
        datalist.clear();

        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String[] projection = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION
        };

        Cursor cursor = getActivity().managedQuery(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null);


        while(cursor.moveToNext()){
            datalist.add(new Music(cursor.getString(3),cursor.getString(2),cursor.getString(5)));
        }
        recyclerView.setAdapter(musicListAdapter);

    }

}
