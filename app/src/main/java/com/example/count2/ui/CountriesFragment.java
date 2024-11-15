package com.example.count2.ui;

import static com.example.count2.data.CountryCapitalData.getFlagUrlForCountry;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.count2.R;
import com.example.count2.adapter.CountryAdapter;
import com.example.count2.data.CountryCapitalData;
import com.example.count2.databinding.FragmentCountriesBinding;

import java.util.ArrayList;
import java.util.List;

public class CountriesFragment extends Fragment {

    private FragmentCountriesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCountriesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> countries = getArguments() != null ? getArguments().getStringArrayList("Countries") : new ArrayList<>();

        CountryAdapter countryAdapter = new CountryAdapter(country -> {
            CityFragment cityFragment = new CityFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Country", country);
            bundle.putString("Capital", getCapitalForCountry(country));
            bundle.putString("FlagUrl", getFlagUrlForCountry(country));
            cityFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, cityFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvCountries.setAdapter(countryAdapter);
        countryAdapter.submitList(countries);
    }

    private String getCapitalForCountry(String country) {
        return CountryCapitalData.getCapitalForCountry(country);
    }
}