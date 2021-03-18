package com.ruiz211.imagelistview.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruiz211.imagelistview.R;
import com.ruiz211.imagelistview.model.Person;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<Person> people;

    public ListAdapter(List<Person> objects) {
        this.people = objects;
    }

    public List<Person> getPeople() {
        return people;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list_view, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.image.setImageResource(getPeople().get(position).getImage());
        holder.name.setText(getPeople().get(position).getName());
        holder.age.setText(String.valueOf(getPeople().get(position).getAge()));
    }

    @Override
    public int getItemCount() {
        return getPeople().size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView age;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
        }
    }
}
