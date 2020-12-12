package com.example.withbash.ui.events;

import com.google.firebase.firestore.DocumentId;

public class EventListModel {

    @DocumentId
    private String event_id;
    private String name,description,image;

    public EventListModel(){}

    public EventListModel(String event_id, String name, String description, String image) {
        this.event_id = event_id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }
}
