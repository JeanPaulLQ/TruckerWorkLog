package com.someware.bitacoraviajes.views.ui.viewPagerUI;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.someware.bitacoraviajes.R;
import com.someware.bitacoraviajes.databinding.FragmentIncomesExpensesBinding;


public class IncomesExpensesFragment extends Fragment {
    FragmentIncomesExpensesBinding binding;
    Chip outboundChip, returnChip, incomesChip, fuelChip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIncomesExpensesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        outboundChip = binding.outboundChip;
        returnChip = binding.returnChip;
        incomesChip = binding.incomesChip;
        fuelChip = binding.fuelChip;

        outboundChip.setOnClickListener(v -> {
            Toast.makeText(requireActivity(), "Gastos ida", Toast.LENGTH_SHORT).show();
            binding.background.setBackgroundColor(Color.CYAN);
        });
        returnChip.setOnClickListener(v -> {
            Toast.makeText(requireActivity(), "Gastos retorno", Toast.LENGTH_SHORT).show();
            binding.background.setBackgroundColor(Color.RED);
        });
        incomesChip.setOnClickListener(v -> {
            Toast.makeText(requireActivity(), "Ingresos", Toast.LENGTH_SHORT).show();
            binding.background.setBackgroundColor(Color.GREEN);
        });
        fuelChip.setOnClickListener(v -> {
            Toast.makeText(requireActivity(), "Fuel", Toast.LENGTH_SHORT).show();
            binding.background.setBackgroundColor(Color.MAGENTA);
        });
        return view;
    }
}