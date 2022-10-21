package com.example.dictionaryapi.view_holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapi.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {
    public TextView text_view_definition, text_view_example, text_view_synonyms, text_view_antonyms;

    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);

        text_view_definition = itemView.findViewById(R.id.text_view_definition);
        text_view_example = itemView.findViewById(R.id.text_view_example);
        text_view_synonyms = itemView.findViewById(R.id.text_view_synonyms);
        text_view_antonyms = itemView.findViewById(R.id.text_view_antonyms);
    }
}
