package eb.egonb.jokerapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import eb.egonb.jokerapp.R;
import eb.egonb.jokerapp.model.Joke;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView setupTV = rootView.findViewById(R.id.tv_details_setup);
        TextView punchlineTV = rootView.findViewById(R.id.tv_details_punchline);

        Bundle data = getArguments();
        if(data != null) {
            if (data.containsKey("passedJoke")){
                Joke joke =  (Joke) data.getSerializable("passedJoke");
                setupTV.setText(joke.getSetup());
                punchlineTV.setText(joke.getPunchline());
            }
        }
        return rootView;
    }

}
