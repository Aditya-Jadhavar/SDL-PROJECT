package com.example.withbash.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.example.withbash.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private List<Location>locations;

    public LocationAdapter(List<Location> locations) {
        this.locations = locations;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_location,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.setLocationData(locations.get(position));
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    static class LocationViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kbvLocation;
        private TextView textTitle,textLocation,textStarRating;
         LocationViewHolder(@NonNull View itemView) {
            super(itemView);

            kbvLocation=itemView.findViewById(R.id.kbvlocation);
            textLocation=itemView.findViewById(R.id.textLocation);
            textStarRating=itemView.findViewById(R.id.textStarRating);
            textTitle=itemView.findViewById(R.id.textTitle);
        }
        void setLocationData(Location location){
            Picasso.get().load(location.imageUrl).into(kbvLocation);
            textTitle.setText(location.title);
            textStarRating.setText(String.valueOf(location.starRating));
            textLocation.setText(location.location);
        }
    }
}
