package com.example.gopherit.event;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gopherit.R;

public class EventInfoFragment extends Fragment {

    private EventInfoViewModel viewModel;

    private TextView textView;

    public static EventInfoFragment newInstance() {
        return new EventInfoFragment();
    }

    public static final String EVENT_TITLE_MESSAGE = "com.example.gopherit.EVENT_TITLE_MESSAGE";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_info_fragment, container, false);
        textView = view.findViewById(R.id.textView);
        textView.setText(getArguments().getString(EVENT_TITLE_MESSAGE));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(EventInfoViewModel.class);
        // TODO: Use the ViewModel
    }

}
