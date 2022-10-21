package com.example.dictionaryapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapi.R;
import com.example.dictionaryapi.models.Meanings;
import com.example.dictionaryapi.view_holders.MeaningsViewHolder;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningsViewHolder> {

    private Context context;
    private List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meanings_list_item, parent, false);
        return new MeaningsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        Meanings meanings = meaningsList.get(position);
        holder.text_parts_of_speech.setText("Parts Of Speech : " + meanings.getPartOfSpeech());

        holder.recycler_definition.setHasFixedSize(true);
        holder.recycler_definition.setLayoutManager(new GridLayoutManager(context, 1));

        DefinitionAdapter adapter = new DefinitionAdapter(context, meanings.getDefinitions());
        holder.recycler_definition.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
