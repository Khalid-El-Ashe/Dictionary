package com.example.dictionaryapi.adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapi.R;
import com.example.dictionaryapi.models.Phonetics;
import com.example.dictionaryapi.view_holders.PhoneticViewHolder;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {

    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.phonatic_list_item, parent, false);
        return new PhoneticViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
        Phonetics phonetics = phoneticsList.get(position);
        holder.text_view_phonetic.setText(phonetics.getText());

        holder.img_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this is to run the music
                MediaPlayer mediaPlayer = new MediaPlayer();
                try {
                    if (!mediaPlayer.isPlaying()) {
//                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                        mediaPlayer.setDataSource("https:" + phonetics.getAudio());
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "something is wrong.. check the internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
