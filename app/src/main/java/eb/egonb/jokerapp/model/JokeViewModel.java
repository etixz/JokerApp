package eb.egonb.jokerapp.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class JokeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Joke>> jokes;

    public MutableLiveData<ArrayList<Joke>> getJokes(){
        if(jokes == null){
            jokes = new MutableLiveData<>();
            loadJokes();
        }
        return jokes;
    }

    private void loadJokes() {
        //in het echt komt dit uit een backnd of database
        ArrayList<Joke> newJokes = new ArrayList<>();

        newJokes.add(new Joke("Het is Blauw en weegt niet veel", "Lichtblauw"));
        newJokes.add(new Joke("Het is zwart en als het uit een boom valt is uw kachel kapot", "Uw kachel"));
        newJokes.add(new Joke("Het is grijs en als het in uw vliegt zijt ge dood", "Nen Boeing"));

        jokes.setValue(newJokes);
    }
}
