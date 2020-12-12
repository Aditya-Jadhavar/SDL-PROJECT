package com.example.withbash.ui.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.withbash.R;
import com.flaviofaria.kenburnsview.KenBurnsView;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {

    public List<EventListModel>eventListModels;

    public void setEventListModels(List<EventListModel> eventListModels) {
        this.eventListModels = eventListModels;
    }
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item,parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        holder.listTitle.setText(eventListModels.get(position).getName());
        String imageUrl=eventListModels.get(position).getImage();
        Glide
                .with(holder.itemView.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.placeholder_image)
                .into(holder.kbvLocation);
        holder.description.setText(eventListModels.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        if (eventListModels== null) {
            return 0;
        }else {
            return eventListModels.size();
        }
    }



    public class EventViewHolder extends RecyclerView.ViewHolder {

        public KenBurnsView kbvLocation;
        public TextView listTitle;
        //public ImageView listImage;
        public TextView description;
        public Button listBtn;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocation=itemView.findViewById(R.id.kbvlocation);
            listBtn=itemView.findViewById(R.id.list_btn);
           // listImage=itemView.findViewById(R.id.list_image);
            description=itemView.findViewById(R.id.list_desc);
            listTitle=itemView.findViewById((R.id.list_title));

        }

        }
    }
