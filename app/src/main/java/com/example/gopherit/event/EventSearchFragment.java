package com.example.gopherit.event;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gopherit.R;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;

import static com.example.gopherit.event.EventInfoFragment.EVENT_TITLE_MESSAGE;

public class EventSearchFragment extends Fragment implements View.OnClickListener {

    private EventSearchViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_search_fragment, container, false);

        Button button = view.findViewById(R.id.button3);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(EventSearchViewModel.class);
        // TODO: Use the ViewModel
    }

    private ArrayList<EventModel> createSampleData() {
        ArrayList<EventModel> items = new ArrayList<>();
        items.add(new EventModel("First item"));
        items.add(new EventModel("Second item"));
        items.add(new EventModel("Third item"));
        items.add(new EventModel("The ultimate item"));
        items.add(new EventModel("Last item"));
        items.add(new EventModel("Lorem ipsum"));
        items.add(new EventModel("Dolor sit"));
        items.add(new EventModel("Some random word"));
        items.add(new EventModel("guess who's back"));
        return items;
    }

    @Override
    public void onClick(View v) {
        SimpleSearchDialogCompat<EventModel> dialog = new SimpleSearchDialogCompat<>(EventSearchFragment.this.getContext(), "Search...",
                "Search Events", null, createSampleData(),
                new SearchResultListener<EventModel>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat dialog,
                                           EventModel item, int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString(EVENT_TITLE_MESSAGE, item.getTitle());
                        Fragment newFragment = new EventInfoFragment();
                        newFragment.setArguments(bundle);
                        getFragmentManager().beginTransaction()
                                .replace(R.id.nav_host_fragment, newFragment)
                                .addToBackStack(null)
                                .commit();
                        dialog.hide();
                    }
                });
        dialog.show();
    }

}
