package com.example.m6.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.m6.R;
import com.example.m6.model.Player;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@SuppressWarnings({"ChainedMethodCall", "JavaDoc", "CyclicClassDependency"})
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button conf_button = findViewById(R.id.conf_button);
        conf_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeConfig();
            }
        });

        Button load_button = findViewById(R.id.main_load);
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();

            }
        });
    }

    /** Called when the user taps the Configuration button **/
    public void makeConfig() {
        // Do something in response to button
        Intent intent = new Intent(this, ConfigurationActivity.class);
        startActivity(intent);
    }
    private void loadData(){
        //noinspection ChainedMethodCall
        FirebaseDatabase.getInstance().getReference()
                .addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Player player = dataSnapshot.child("players").getValue(Player.class);
                openCurrentPlanet(player);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @SuppressWarnings("TypeMayBeWeakened")
    private void openCurrentPlanet(Player player){
        Intent intent = new Intent(this, CurrentPlanetActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
}
