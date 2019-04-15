package com.example.m6.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.m6.R;
import com.example.m6.model.Player;
import com.example.m6.model.SolarSystem;
import com.example.m6.model.Spaceship;
import com.example.m6.model.chainingTest;
import com.example.m6.model.test;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buyButton, sellButton, infoButton, playerButton, saveButton, loadButton;
    private FirebaseDatabase mDatabase;
    private DatabaseReference ref;
    private Player player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        player = (Player)getIntent().getSerializableExtra("player");
        //this log checks whether player instance import successfully
        Log.d("player", player.getName()+" is into MenuActivity sucessfully" );
        buyButton = findViewById(R.id.buy_button);
        buyButton.setOnClickListener(this);

        sellButton = findViewById(R.id.sell_button);
        sellButton.setOnClickListener(this);

        infoButton = findViewById(R.id.system_info_button);
        infoButton.setOnClickListener(this);

        playerButton = findViewById(R.id.player_info_button);
        playerButton.setOnClickListener(this);

        saveButton = findViewById(R.id.menu_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCurrentPlayerInstance();
            }
        });
        loadButton = findViewById(R.id.menu_load);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(new ValueEventListener() {
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
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void openBuyGoods() {
        Intent intent = new Intent(this, BuyGoodsActivity.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+" sent from MenuActivity to buyactivity sucessfully" );
        startActivity(intent);
    }

    public void openSellGoods() {
        Intent intent = new Intent(this, SellGoodsActivity.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+" sent from MenuActivity to sellactivity sucessfully" );
        startActivity(intent);
    }
    public void openSystem(){
        Intent intent = new Intent(this, CurrentPlanetActivity.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+" sent from MenuActivity to CurrentPlanetactivity sucessfully" );
        startActivity(intent);
    }
    public void openPlayerInformation(){
        Intent intent = new Intent(this, player_information.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+" sent from MenuActivity to playerInformationActivity sucessfully" );
        startActivity(intent);
    }


    public void saveCurrentPlayerInstance() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date = new Date();
        String currentTime = dateFormat.format(date);

        mDatabase = FirebaseDatabase.getInstance();
//        ref = mDatabase.getReference("players");
        ref = mDatabase.getReference("players/");
//        DatabaseReference playerRef = ref.child("players");
//        test user = new test();
//        user.setName("lim");
//        user.setUsernumber(333);
//        user.setInstance(new chainingTest("1"));
//        Map<String, Player> map = new HashMap<>();
//        map.put(currentTime, player);
        ref.setValue(player);
//        playerRef.push().setValue(player);
//        String uID =  mDatabase.child("player").push().getKey();
//        mDatabase.child("player").child(uID).setValue(player);
//        mDatabase.child("players").setValue(player);
        Toast.makeText(getApplicationContext(), "your player data is safely saved", Toast.LENGTH_LONG).show();
        openMainActivity();
    }

    public void openCurrentPlanet(Player player){
        Intent intent = new Intent(this, CurrentPlanetActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_button:
                openBuyGoods();
                break;
            case R.id.sell_button:
                openSellGoods();
                break;
            case R.id.system_info_button:
                Log.d("test", "system_info_button is clicked");
                openSystem();
                break;
            case R.id.player_info_button:
                openPlayerInformation();
                break;
//            case R.id.menu_save:
//                Log.d("test2", "clicked!");
//                saveCurrentPlayerInstance();
        }
    }
    public void openMainActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
