package com.example.withbash.ui;
import android.content.ContentValues.*;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.withbash.R;
import com.example.withbash.ui.events.EventListAdapter;
import com.example.withbash.ui.events.EventListModel;
import com.example.withbash.ui.events.EventListViewModel;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.List;


public class DetailsFragment extends Fragment implements View.OnClickListener{

    private NavController navController;
    private com.example.withbash.ui.events.EventListViewModel eventListViewModel;
    private int position;

    public KenBurnsView kbvLocation;
    public TextView detailsTitle;
    public TextView description;
    public Button detailsBtn;



    public DetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController= Navigation.findNavController(view);
        position=DetailsFragmentArgs.fromBundle(getArguments()).getPosition();

        //initialize ui elements
        kbvLocation=view.findViewById(R.id.kbvlocation);
        description=view.findViewById(R.id.details_desc);
        detailsTitle=view.findViewById(R.id.details_title);
        detailsBtn=view.findViewById(R.id.details_btn);
        detailsBtn.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        eventListViewModel= new ViewModelProvider(requireActivity()).get(EventListViewModel.class);
        eventListViewModel.getEventListModelData().observe(getViewLifecycleOwner(), new Observer<List<EventListModel>>() {
            @Override
            public void onChanged(List<EventListModel> eventListModels) {

                Glide
                        .with(getContext())
                        .load(eventListModels.get(position).getImage())
                        .centerCrop()
                        .placeholder(R.drawable.placeholder_image)
                        .into(kbvLocation);
                description.setText(eventListModels.get(position).getDescription());
                detailsTitle.setText(eventListModels.get(position).getName());

            }
        });
    }


    @Override
    public void onClick(View v) {
        navController.navigate(R.id.action_detailsFragment_to_eventInfo);
    }
}