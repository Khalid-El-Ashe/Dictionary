package com.example.dictionaryapi.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapi.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
    public TextView text_parts_of_speech;
    public RecyclerView recycler_definition;

    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);

        text_parts_of_speech = itemView.findViewById(R.id.text_view_partsOfSpeech);
        recycler_definition = itemView.findViewById(R.id.recycler_definitions);
    }
}
