package com.someware.bitacoraviajes.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.someware.bitacoraviajes.views.ui.viewPagerUI.GeneralDataFragment;
import com.someware.bitacoraviajes.views.ui.viewPagerUI.IncomesExpensesFragment;
import com.someware.bitacoraviajes.views.ui.viewPagerUI.OutboundRouteFragment;
import com.someware.bitacoraviajes.views.ui.viewPagerUI.ReturnRouteFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new GeneralDataFragment();
            case 1:
                return new OutboundRouteFragment();
            case 2:
                return new ReturnRouteFragment();
            case 3:
                return new IncomesExpensesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
