package eb.egonb.jokerapp.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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

    private SearchView.OnQueryTextListener searchListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            adapter.getFilter().filter(newText);
            return false;
        }
    };
    private JokeAdapter adapter;

    public JokeListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_joke_list, container, false);

        setHasOptionsMenu(true);

        //verwijzing naar UI
        RecyclerView rvJokes = rootView.findViewById(R.id.rv_jokes);

        //manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        //manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        //manager = new GridLayoutManager(getContext(), 2);

        //Opvulling recycler, kan als lijst of grid afh van manager
        rvJokes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        //adapter, nodig om data om te zetten in iets visueel
        adapter = new JokeAdapter();
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

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.mi_search).getActionView();
        searchView.setOnQueryTextListener(searchListener);

        super.onCreateOptionsMenu(menu, inflater);
    }
}
