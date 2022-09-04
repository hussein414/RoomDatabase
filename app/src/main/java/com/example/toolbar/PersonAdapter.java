package com.example.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    List<Person> list;

    public PersonAdapter( List<Person> list ) {
        this.list = list;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        return new PersonViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_card, parent, false));
    }

    @Override
    public void onBindViewHolder( @NonNull PersonViewHolder holder, int position ) {
        holder.setBindView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView name, family;

        public PersonViewHolder( @NonNull View itemView ) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            family = itemView.findViewById(R.id.textFamily);
        }

        void setBindView( Person person ) {
            name.setText(person.getName());
            family.setText(person.getFamily());
        }
    }
}
