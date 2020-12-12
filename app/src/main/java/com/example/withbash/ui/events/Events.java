package com.example.withbash.ui.events;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.withbash.R;
import com.example.withbash.ui.DetailsFragment;
import com.google.android.gms.tasks.OnCompleteListener;

import java.util.List;
import java.util.Objects;


public class Events extends Fragment {

    private RecyclerView listView;
    private EventListViewModel eventListViewModel;

    private EventListAdapter adapter;
    public Events() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView=view.findViewById(R.id.list_view);
        adapter=new EventListAdapter();

        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.setHasFixedSize(true);
        listView.setAdapter(adapter);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        eventListViewModel= new ViewModelProvider(requireActivity()).get(EventListViewModel.class);
        eventListViewModel.getEventListModelData().observe(getViewLifecycleOwner(), new Observer<List<EventListModel>>() {
            @Override
            public void onChanged(List<EventListModel> eventListModels) {
               adapter.setEventListModels(eventListModels);
               adapter.notifyDataSetChanged();
            }
        });

    }


}