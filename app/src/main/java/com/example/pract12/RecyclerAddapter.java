package com.example.pract12;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAddapter extends RecyclerView.Adapter<RecyclerAddapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<State> states;

    RecyclerAddapter(Context context, List<State> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerAddapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAddapter.ViewHolder holder, int position) {
        State state = states.get(position);
        holder.flagView.setImageResource(state.getFlagResource());
        holder.nameView.setText(state.getName());
        holder.capitalView.setText(state.getCapital());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Вы выбрали: " + state.getName(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(v.getContext(), DetailsActivity.class);
            intent.putExtra("name", state.getName());
            intent.putExtra("capital", state.getCapital());
            intent.putExtra("flag", state.getFlagResource());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameView, capitalView;

        ViewHolder(View view) {
            super(view);
            flagView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
        }
    }
}
