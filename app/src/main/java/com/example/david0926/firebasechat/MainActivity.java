package com.example.david0926.firebasechat;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();


    RecyclerView rcv;
    RecyleAdapter rcvAdap;
    EditText input;


    String getTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = findViewById(R.id.recycler);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcvAdap = new RecyleAdapter();
        rcv.setAdapter(rcvAdap);
        RecycleModel model = new RecycleModel();
        model.setName("hatban");
        model.setMsg("Hell World!");
        model.setTime(getTime());
        rcvAdap.add(model);
        rcvAdap.notifyDataSetChanged();

        databaseReference.child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                RecycleModel model = dataSnapshot.getValue(RecycleModel.class);
                rcvAdap.add(model);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void onSend(View view) {
        input = findViewById(R.id.chat_input);
        RecycleModel model = new RecycleModel("Hatban", input.getText().toString(), getTime());
        databaseReference.child("message").push().setValue(model);
    }


}
