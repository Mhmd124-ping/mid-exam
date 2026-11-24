package com.example.mid_exam_mohamedhamdan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TabFragment extends Fragment {

    private static final String ARG_TITLE = "arg_title";

    public static TabFragment newInstance(String title) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        TextView tvTabTitle = view.findViewById(R.id.tvTabTitle);

        if (getArguments() != null) {
            tvTabTitle.setText(getArguments().getString(ARG_TITLE));
        }
        return view;
    }
}