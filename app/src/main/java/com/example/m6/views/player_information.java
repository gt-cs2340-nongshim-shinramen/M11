package com.example.m6.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m6.R;
import com.example.m6.model.Player;

/**
 * player information class
 */
@SuppressWarnings({"FieldCanBeLocal", "ChainedMethodCall",
        "ConstantConditions", "CyclicClassDependency"})
public class player_information extends AppCompatActivity
        implements refuelDialog.refuelDialogListener {

    private TextView player_credits;
    private TextView spaceship_fuel;

    private Button menu_button;
    private Button marketplace_button;
    private Button warp_button;
    private Button refuel_button;
    private Player player;
    @SuppressWarnings("FeatureEnvy")
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_information);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        player = (Player)getIntent().getSerializableExtra("player");
        //this log checks whether player instance import successfully
        Log.d("player", player.getName()+" is into MenuActivity successfully" );

        TextView player_name = findViewById(R.id.player_name);
        player_name.setText(player.getName());

        TextView player_planet = findViewById(R.id.curr_planet);
        //noinspection LawOfDemeter
        player_planet.setText(player.getCurrentplanet().getName());

        player_credits = findViewById(R.id.player_credits);
        player_credits.setText(String.valueOf(player.getCredit()));

        spaceship_fuel = findViewById(R.id.spaceship_fuel);
        spaceship_fuel.setText(player.getFuel()+ " L / 100 L");

        menu_button = findViewById(R.id.button_menu);
        menu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        marketplace_button = findViewById(R.id.button_market_info);
        marketplace_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMarketPlace();
            }
        });

        refuel_button = findViewById(R.id.button_spaceship_refuel);
        refuel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refillFuel();
            }
        });

        warp_button = findViewById(R.id.button_warp);
        warp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWarp();
            }
        });
    }
    private void refillFuel(){
        DialogFragment frag = new refuelDialog();

        frag.show(getSupportFragmentManager(), "dialog");
    }

    private void openMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+
                " sent from playerInformation to MenuActivity successfully" );
        startActivity(intent);
    }
    private void openMarketPlace(){
        Intent intent = new Intent(this, Marketplace.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+
                " sent from playerInformationActivity to marketplaceActivity successfully" );
        startActivity(intent);
    }
    private void openWarp(){
        Intent intent = new Intent(this, Warp.class);
        intent.putExtra("player", player);
        //noinspection MagicNumber
        startActivityForResult(intent, 151);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //noinspection MagicNumber
        if (requestCode == 151) {
            if(resultCode == Activity.RESULT_OK) {
                player = (Player) data.getSerializableExtra("player");
                Intent intent = new Intent(this, CurrentPlanetActivity.class);
                intent.putExtra("player", player);
                finish();
                startActivity(intent);

            }
        }
    }

    @SuppressWarnings("FeatureEnvy")
    @SuppressLint("SetTextI18n")
    @Override
    public void buyFuel(String fuel) {
        int input = Integer.parseInt(fuel);

        if(input <= (100 - player.getFuel())) {
            player.setFuel(player.getFuel()+input);
            int unitFuelPrice = 4;
            player.setCredit(player.getCredit() - (input * unitFuelPrice));
            spaceship_fuel.setText(player.getFuel()+ " L / 100 L");
            player_credits.setText(String.valueOf(player.getCredit()));
        } else {
            //noinspection ChainedMethodCall
            Toast.makeText(getApplicationContext(),
                    "you are trying to refill more than full tank", Toast.LENGTH_LONG).show();
        }
    }
}
