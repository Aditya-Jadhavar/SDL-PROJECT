package com.example.withbash.ui.pay;
import com.example.withbash.R;
import com.example.withbash.ui.DataHolder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

 public class Cart extends AppCompatActivity {

   /* ListView cart_events_listview;
    //ArrayAdapter<String> adapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference studentDbRef;
    FirebaseUser user;

    List<DataHolder> Data;
    String Uid;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cart_events_listview = findViewById(R.id.listview_cart);
        Data = new ArrayList<DataHolder>();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

       // user = FirebaseAuth.getInstance().getCurrentUser();

       // Uid = user.getUid();

        studentDbRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        studentDbRef.addValueEventListener(new ValueEventListener() {
            @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot){

                    Data.clear();
                for(DataSnapshot studentdatasnap : dataSnapshot.getChildren()){

                    DataHolder students = studentdatasnap.getValue(DataHolder.class);
                    Data.add(students);


                }

                //CartAdapter adapter = new ListAdapter(Cart.this,Data);
                CartAdapter adapter = new CartAdapter(Cart.this,Data);
                cart_events_listview.setAdapter(adapter);
                   // String eventName = dataSnapshot.child(Uid).child("eventName").getValue(String.class);
                  //  String packages = dataSnapshot.child(Uid).child("packages").getValue(String.class);
                  //  String cost = dataSnapshot.child(Uid).child("cost").getValue(String.class);
                  // Data.add(eventName);
                  // Data.add(packages);
                  // Data.add(cost);





                    //CartAdapter adapter = new ListAdapter(Cart.this,Data);
                 //  CartAdapter adapter = new CartAdapter(Cart.this,Data);
                   // adapter = new ArrayAdapter<>(Cart.this, android.R.layout.simple_list_item_1,Data);
                   // cart_events_listview.setAdapter(adapter);


            }

            @Override
                     public void onCancelled(@NonNull DatabaseError databaseError){
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG);

            }
        });
    }
    */
}

