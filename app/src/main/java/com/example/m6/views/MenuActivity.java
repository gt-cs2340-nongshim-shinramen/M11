package com.example.m6.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.m6.R;
import com.example.m6.model.Player;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Menu activity
 */
@SuppressWarnings({"ChainedMethodCall", "CyclicClassDependency"})
public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private Player player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //noinspection ChainedMethodCall
        player = (Player)getIntent().getSerializableExtra("player");
        //this log checks whether player instance import successfully
        Log.d("player", player.getName()+" is into MenuActivity successfully" );
        Button buyButton = findViewById(R.id.buy_button);
        buyButton.setOnClickListener(this);

        Button sellButton = findViewById(R.id.sell_button);
        sellButton.setOnClickListener(this);

        Button infoButton = findViewById(R.id.system_info_button);
        infoButton.setOnClickListener(this);

        Button playerButton = findViewById(R.id.player_info_button);
        playerButton.setOnClickListener(this);

        Button saveButton = findViewById(R.id.menu_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCurrentPlayerInstance();
            }
        });
        Button loadButton = findViewById(R.id.menu_load);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(
                        new ValueEventListener() {
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
    }

    private void openBuyGoods() {
        Intent intent = new Intent(this, BuyGoodsActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }

    private void openSellGoods() {
        Intent intent = new Intent(this, SellGoodsActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
    private void openSystem(){
        Intent intent = new Intent(this, CurrentPlanetActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
    private void openPlayerInformation(){
        Intent intent = new Intent(this, player_information.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }


    private void saveCurrentPlayerInstance() {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date = new Date();
        String currentTime = dateFormat.format(date);

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference ref = mDatabase.getReference("players");
        ref.setValue(player);
        Toast.makeText(getApplicationContext(),
                "your player data is safely saved", Toast.LENGTH_LONG).show();
        openMainActivity();
    }

    @SuppressWarnings("TypeMayBeWeakened")
    private void openCurrentPlanet(Player player){
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
        }
    }
    private void openMainActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
