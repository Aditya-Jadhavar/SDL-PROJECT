package com.example.withbash.ui.events;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Objects;

public class FirebaseRepository {

    private final OnFirestoreTaskComplete onFirestoreTaskComplete;


    private final FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private final CollectionReference eventRef=firebaseFirestore.collection("EventList");

    public FirebaseRepository(OnFirestoreTaskComplete onFirestoreTaskComplete) {
        this.onFirestoreTaskComplete = onFirestoreTaskComplete;
    }


    public void getEventData(){
        eventRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    onFirestoreTaskComplete.eventListDataAdded(Objects.requireNonNull(task.getResult()).toObjects(EventListModel.class));
                }else {
                    onFirestoreTaskComplete.onError(task.getException());
                }
            }
        });
    }
    public interface OnFirestoreTaskComplete{
        void eventListDataAdded(List<EventListModel>eventListModelsList);
        void onError(Exception e);
    }
}
