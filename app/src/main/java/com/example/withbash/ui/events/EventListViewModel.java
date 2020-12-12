package com.example.withbash.ui.events;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import androidx.lifecycle.ViewModel;

import java.util.List;

public class EventListViewModel extends ViewModel implements FirebaseRepository.OnFirestoreTaskComplete {

    public MutableLiveData<List<EventListModel>> eventListModelData = new MutableLiveData<>();
    public LiveData<List<EventListModel>> getEventListModelData() {
        return eventListModelData;
    }
    public FirebaseRepository firebaseRepository = new FirebaseRepository(this);

    public EventListViewModel() {
        firebaseRepository.getEventData();
    }
    @Override
    public void eventListDataAdded(List<EventListModel> eventListModelsList) {
        eventListModelData.setValue(eventListModelsList);
    }

    @Override
    public void onError(Exception e) {

    }




}
