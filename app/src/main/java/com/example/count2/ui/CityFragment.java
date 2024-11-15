package com.example.count2.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.count2.R;
import com.example.count2.databinding.FragmentCitiesBinding;

public class CityFragment extends Fragment {

    private FragmentCitiesBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCitiesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String country = getArguments() != null ? getArguments().getString("Country") : "Country not specified";
        String capital = getArguments() != null ? getArguments().getString("Capital") : "Capital not available";
        String flagUrl = getArguments() != null ? getArguments().getString("FlagUrl") : "";

        binding.tvCountry.setText("Capital of " + country + " is " + capital);

        assert flagUrl != null;
        if (!flagUrl.isEmpty()) {
            Glide.with(this)
                    .load(flagUrl)
                    .into(binding.ivCountry);
        }
    }
}