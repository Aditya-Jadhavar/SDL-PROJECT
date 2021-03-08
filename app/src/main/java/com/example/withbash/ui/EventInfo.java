package com.example.withbash.ui;
import com.example.withbash.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EventInfo extends AppCompatActivity {

EditText t2,t3;

Spinner t4,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);


    }

    public void process(View view) {

        t1 = findViewById(R.id.eventnamee);
        t2 = (EditText) findViewById(R.id.Date);
        t3 = (EditText) findViewById(R.id.phone_no);
        t4 = findViewById(R.id.spinnerPackage);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String eventName = t1.getSelectedItem().toString();
        String Date = t2.getText().toString().trim();
        String phoneNo = t3.getText().toString().trim();
        String packages = t4.getSelectedItem().toString();

        String costy="0000";
        String s = packages;
        switch (s) {
            case "Package 1":
                if (eventName.equals("Wedding")) {
                    String cost= costy.replace("0000","1466");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Proposals")) {
                    String cost= costy.replace("0000","1340");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Anniversary")) {
                    String cost= costy.replace("0000","1340");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Birthday")) {
                    String cost= costy.replace("0000","1340");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
            case "Package 2":
                if (eventName.equals("Wedding")) {
                    String cost= costy.replace("0000","2340");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Proposals")) {
                    String cost= costy.replace("0000","2340");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Anniversary")) {
                    String cost= costy.replace("0000","2340");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Birthday")) {
                    String cost= costy.replace("0000","2340");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
            case "Package 3":
                if (eventName.equals("Wedding")) {
                    String cost= costy.replace("0000","3400");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Proposals")) {
                    String cost= costy.replace("0000","3408");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Anniversary")) {
                    String cost= costy.replace("0000","3400");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
                if (eventName.equals("Birthday")) {
                  String cost= costy.replace("0000","3400");
                    DataHolder obj=new DataHolder(Date,eventName,packages,cost);
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference("Uid");
                    assert user != null;
                    node.child(user.getUid()).child(phoneNo).setValue(obj);
                    t2.setText("");
                    t3.setText("");


                    Toast.makeText(getApplicationContext(), "Event Inserted in Payement section",Toast.LENGTH_LONG).show();
                    break;
                }
        }





    }
}