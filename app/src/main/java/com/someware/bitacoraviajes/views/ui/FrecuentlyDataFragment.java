package com.someware.bitacoraviajes.views.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.someware.bitacoraviajes.R;
import com.someware.bitacoraviajes.databinding.FragmentFrecuentlyDataBinding;


public class FrecuentlyDataFragment extends Fragment {
    FragmentFrecuentlyDataBinding binding;
    SharedPreferences sharedPreferences;
    private static final String PREFERENCES_NAME = "license_plates";
    private final String PRIMARY_PLATE = "pri_plate";
    private final String SECONDARY_PLATE = "sec_plate";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFrecuentlyDataBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        sharedPreferences = requireContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        binding.etPlateTruck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();

                text = text.replace("-", "");

                if (text.length() >= 3) {
                    text = text.substring(0, 3) + "-" + text.substring(3);
                }

                binding.etPlateTruck.removeTextChangedListener(this);
                binding.etPlateTruck.setText(text);
                binding.etPlateTruck.setSelection(text.length());
                binding.etPlateTruck.addTextChangedListener(this);
            }
        });
        binding.etPlatePlatform.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();

                text = text.replace("-", "");

                if (text.length() >= 3) {
                    text = text.substring(0, 3) + "-" + text.substring(3);
                }

                binding.etPlatePlatform.removeTextChangedListener(this);
                binding.etPlatePlatform.setText(text);
                binding.etPlatePlatform.setSelection(text.length());
                binding.etPlatePlatform.addTextChangedListener(this);
            }
        });

        if (verifyExist(sharedPreferences, PRIMARY_PLATE, SECONDARY_PLATE)) {
            binding.etPlateTruck.setText(sharedPreferences.getString(PRIMARY_PLATE, ""));
            binding.etPlatePlatform.setText(sharedPreferences.getString(SECONDARY_PLATE, ""));
        }
        binding.btnSaveData.setOnClickListener(v -> {
            String secondaryStr = binding.etPlatePlatform.getText().toString();
            String primaryStr = binding.etPlateTruck.getText().toString();
            if (!primaryStr.isEmpty()){
                saveData(PRIMARY_PLATE,primaryStr);
            }
            if(!secondaryStr.isEmpty()){
                saveData(SECONDARY_PLATE,secondaryStr);
            }
        });
        return view;
    }

    boolean verifyExist(SharedPreferences sharedPreferences, String key1, String key2) {
        if (sharedPreferences.contains(key1) && sharedPreferences.contains(key2))
            return true;
        return false;
    }

    void saveData(String key, String info) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, info);
        editor.apply();
    }
}