package com.someware.bitacoraviajes.views.ui.viewPagerUI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.someware.bitacoraviajes.R;
import com.someware.bitacoraviajes.databinding.FragmentOutboundRouteBinding;


public class OutboundRouteFragment extends Fragment {
    FragmentOutboundRouteBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOutboundRouteBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }
}