package com.someware.bitacoraviajes.views.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.someware.bitacoraviajes.ViewModels.WorkServiceViewModel;
import com.someware.bitacoraviajes.databinding.FragmentPanelBinding;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PanelFragment extends Fragment {
    private FragmentPanelBinding binding;
    private WorkServiceViewModel workServiceViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPanelBinding.inflate(inflater, container, false);
        workServiceViewModel = new ViewModelProvider(this).get(WorkServiceViewModel.class);

        getPendingWorks();
        getActualMonthWorks();
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void getPendingWorks() {
        int pendingWorks = workServiceViewModel.getPendingWorks();
        Toast.makeText(requireContext(), String.valueOf(pendingWorks), Toast.LENGTH_SHORT).show();
        binding.pendingWorksCant.setText(""+pendingWorks);
    }

    private void getCompletedWorks() {
        int completedWorks = workServiceViewModel.getCompletedWorks();
        binding.cantNumber.setText(String.valueOf(completedWorks));
    }

    private void getActualMonthWorks() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        Date month = new Date();
        Log.i("TAG", "getActualMonthWorks: "+sdf.format(month));
    }
}