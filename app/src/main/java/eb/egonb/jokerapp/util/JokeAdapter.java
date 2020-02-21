package eb.egonb.jokerapp.util;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import eb.egonb.jokerapp.R;
import eb.egonb.jokerapp.model.Joke;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

     class JokeViewHolder extends RecyclerView.ViewHolder{

        final TextView tvSetup;
        final Button btnPunchline;

        final View.OnClickListener detailListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //welke card?
                int position = getAdapterPosition();
                //data in bundel om door te geven
                Bundle data = new Bundle();
                data.putSerializable("passedJoke", items.get(position));
                //navigatie starten
                Navigation.findNavController(v).navigate(R.id.jokelist_to_detail, data);
            }
        };

        public JokeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSetup = itemView.findViewById(R.id.tv_setup);
            btnPunchline = itemView.findViewById(R.id.btn_punchline);

            btnPunchline.setOnClickListener(detailListener);
        }


    }

    ArrayList<Joke> items;

    public JokeAdapter() {
        items = new ArrayList<>();
    }


    @NonNull
    @Override
    public JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View card = layoutInflater.inflate(R.layout.joker_card, parent, false);

        return new JokeViewHolder(card);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeViewHolder holder, int position) {
        Joke currentJoke = items.get(position);
        holder.tvSetup.setText(currentJoke.getSetup());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems(ArrayList<Joke> jokes){
        items.addAll(jokes);
    }
}
