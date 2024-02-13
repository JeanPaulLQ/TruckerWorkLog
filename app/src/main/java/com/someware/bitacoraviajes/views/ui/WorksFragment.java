package com.someware.bitacoraviajes.views.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.someware.bitacoraviajes.R;
import com.someware.bitacoraviajes.databinding.FragmentWorksBinding;


public class WorksFragment extends Fragment {
    FragmentWorksBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorksBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.completedBtnGroup.setOnClickListener(v->{
            Toast.makeText(requireContext(), "Completo", Toast.LENGTH_SHORT).show();
        });
        binding.pendingBtnGroup.setOnClickListener(v->{
            Toast.makeText(requireContext(), "Pendientes ", Toast.LENGTH_SHORT).show();
        });
        binding.floatBtnCreateWork.setOnClickListener(v->{
            Toast.makeText(requireContext(), "Crear Nuevo Viaje ", Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}