package com.example.recycleviewrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    private Context context;
    final LinkedList<Recipes> mRecipes;
    private IOnItemClickListener onItemClickListener;

    public RecipesAdapter(Context context, LinkedList<Recipes> mRecipes) {
        this.mRecipes = mRecipes;
        this.context = context;
        this.onItemClickListener = (IOnItemClickListener) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_recipes, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle;
        private TextView txtDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
           itemView.setOnClickListener(view -> {
               onItemClickListener.onItemClicked(getAdapterPosition());
           });
        }

        public void bindView(int position){

            Recipes recipes = RecipesAdapter.this.mRecipes.get(position);
            txtTitle.setText(recipes.title);
            txtDescription.setText(recipes.description);


        }
    }
}
