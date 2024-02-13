package com.someware.bitacoraviajes.views.ui.viewPagerUI;

import static com.someware.bitacoraviajes.utils.dataValidator.validatePlate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.someware.bitacoraviajes.R;
import com.someware.bitacoraviajes.ViewModels.WorkServiceViewModel;
import com.someware.bitacoraviajes.data.models.WorkService;
import com.someware.bitacoraviajes.databinding.FragmentGeneralDataBinding;

import java.util.List;


public class GeneralDataFragment extends Fragment {
    String plateTruck;
    String platePlatform;
    boolean validatedData = false;
    WorkServiceViewModel workViewModel;
    FragmentGeneralDataBinding binding;
    private SharedPreferences sharedPreferences;
    public static WorkService service ;
    private final String PRIMARY_PLATE = "pri_plate";
    private final String SECONDARY_PLATE = "sec_plate";
    private static final String PREFERENCES_NAME = "license_plates";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGeneralDataBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        workViewModel = new ViewModelProvider(this).get(WorkServiceViewModel.class);
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
        sharedPreferences = requireContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        //verifyExist() verify that platform plate and truck plate exist in the sharedPreferences
        if (verifyExist()) {
            binding.etPlateTruck.setText(sharedPreferences.getString(PRIMARY_PLATE, ""));
            binding.etPlatePlatform.setText(sharedPreferences.getString(SECONDARY_PLATE, ""));
        }
        //button create listener
        binding.btnCreate.setOnClickListener(v -> {
            if (validateStarterData()) {
                service = new WorkService();
                service.setLicensePlateTruck(binding.etPlateTruck.getText().toString());
                service.setLicensePlatePlatform(binding.etPlatePlatform.getText().toString());
                service.setStatus(0);
                workViewModel.insertWork(service);
                Snackbar.make(view,"Viaje nuevo creado ",Snackbar.LENGTH_SHORT).show();
            } else
                Toast.makeText(requireContext(), "Escriba una placa valida.", Toast.LENGTH_SHORT).show();
        });
        return view;
    }

    boolean validateStarterData() {
        platePlatform = binding.etPlatePlatform.getText().toString();
        plateTruck = binding.etPlateTruck.getText().toString();
        if (!plateTruck.isEmpty() && !platePlatform.isEmpty()) {
            if (validatePlate(platePlatform) && validatePlate(plateTruck))
                return true;
        }
        return false;
    }

    boolean verifyExist() {
        if (sharedPreferences.contains(PRIMARY_PLATE) && sharedPreferences.contains(SECONDARY_PLATE))
            return true;
        return false;
    }
}