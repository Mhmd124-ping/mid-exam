package com.example.mid_exam_mohamedhamdan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabsAdapter extends FragmentStateAdapter {

    private final String[] tabTitles = {"First", "Second", "Third"};

    public TabsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return TabFragment.newInstance(tabTitles[position] + " Tab");
    }

    @Override
    public int getItemCount() {
        return tabTitles.length;
    }
}