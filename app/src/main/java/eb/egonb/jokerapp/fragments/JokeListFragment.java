package eb.egonb.jokerapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import eb.egonb.jokerapp.R;
import eb.egonb.jokerapp.model.Joke;
import eb.egonb.jokerapp.model.JokeViewModel;
import eb.egonb.jokerapp.util.JokeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeListFragment extends Fragment {


    public JokeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_joke_list, container, false);

        //verwijzing naar UI
        RecyclerView rvJokes = rootView.findViewById(R.id.rv_jokes);

        //manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        //manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        //manager = new GridLayoutManager(getContext(), 2);

        //Opvulling recycler, kan als lijst of grid afh van manager
        rvJokes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        //adapter, nodig om data om te zetten in iets visueel
        JokeAdapter adapter = new JokeAdapter();
        rvJokes.setAdapter(adapter);

        //verwijzen naar ViewModel, waar staat alle data
        JokeViewModel model = new ViewModelProvider(this).get(JokeViewModel.class);
        model.getJokes().observe(getViewLifecycleOwner(), new Observer<ArrayList<Joke>>() {
            @Override
            public void onChanged(ArrayList<Joke> jokes) {
                adapter.addItems(jokes);
            }
        });

        return rootView;
    }

}
