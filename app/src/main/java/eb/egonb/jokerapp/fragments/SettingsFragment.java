package eb.egonb.jokerapp.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import eb.egonb.jokerapp.R;

public class SettingsFragment extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
    }
}
