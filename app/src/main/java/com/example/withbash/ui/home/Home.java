package com.example.withbash.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.withbash.R;
import com.example.withbash.ui.events.EventListAdapter;
import com.example.withbash.ui.events.EventListModel;
import com.example.withbash.ui.events.EventListViewModel;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment implements EventListAdapter.OnEventListItemClicked{

private ViewPager2 locationViewPager;
    private RecyclerView listView;
    private EventListViewModel eventListViewModel;
    private EventListAdapter adapter;
    private NavController navController;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //recyclerview
        navController = Navigation.findNavController(view);
        listView=view.findViewById(R.id.list_view);
        adapter=new EventListAdapter(this);

        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        listView.setHasFixedSize(true);
        listView.setAdapter(adapter);

        //horizontal recyclerView card view

        locationViewPager=view.findViewById(R.id.locationViewPager);
        List<Location> locations=new ArrayList<>();

        Location locationEiffel=new Location();
        //locationEiffel.imageUrl="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";
        locationEiffel.imageUrl="https://i.postimg.cc/52c8WbDV/pexels-skitterphoto-675960.jpg";
        locationEiffel.title="france";
        locationEiffel.location="eiffel tower";
        locationEiffel.starRating=4.4f;

        locations.add(locationEiffel);

        Location locationEiffels=new Location();
        //locationEiffels.imageUrl="data:image/jpeg;base64,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";
        locationEiffels.imageUrl="https://i.postimg.cc/y6MMJpGT/svetlana-pochatun-Dg-Ca-EOnf-Bdo-unsplash.jpg";
        locationEiffels.title="france";
        locationEiffels.location="eiffel tower";
        locationEiffels.starRating=4.4f;

        locations.add(locationEiffels);

        locationViewPager.setAdapter(new LocationAdapter(locations));


        locationViewPager.setClipToPadding(false);

        locationViewPager.setClipChildren(false);

        locationViewPager.setOffscreenPageLimit(3);

        locationViewPager.getChildAt(0 ).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositepageTransformer = new CompositePageTransformer();

        compositepageTransformer.addTransformer(new MarginPageTransformer( 40));
        compositepageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                Float r = 1 - Math.abs(position);
                page.setScaleY(0.95f +r* 0.05f);
            }
        } );

                locationViewPager.setPageTransformer(compositepageTransformer);
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

    @Override
    public void onItemClicked(int position) {
        HomeDirections.ActionNavigationHomeToDetailsFragment action=HomeDirections.actionNavigationHomeToDetailsFragment();
        action.setPosition(position);
        navController.navigate(action);
    }
}
