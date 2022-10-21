package com.example.dictionaryapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapi.R;
import com.example.dictionaryapi.models.Definitions;
import com.example.dictionaryapi.view_holders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {

    private Context context;
    private List<Definitions> definitionsList;

    public DefinitionAdapter(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.definitions_list_items, parent, false);
        return new DefinitionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        Definitions definitions = definitionsList.get(position);
        holder.text_view_definition.setText("Definition : " + definitions.getDefinition());
        holder.text_view_example.setText("Example : " + definitions.getExample());

        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitions.getSynonyms());
        antonyms.append(definitions.getAntonyms());

        holder.text_view_synonyms.setText(synonyms);
        holder.text_view_antonyms.setText(antonyms);

        holder.text_view_synonyms.setSelected(true);
        holder.text_view_antonyms.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
