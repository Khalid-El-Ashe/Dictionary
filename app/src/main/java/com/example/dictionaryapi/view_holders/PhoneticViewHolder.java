package com.example.dictionaryapi.view_holders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapi.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
    public TextView text_view_phonetic;
    public ImageButton img_audio;

    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);

        text_view_phonetic = itemView.findViewById(R.id.text_phonetic);
        img_audio = itemView.findViewById(R.id.img_btn_audio);
    }
}
