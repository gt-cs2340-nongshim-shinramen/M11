package com.example.m6.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


import com.example.m6.R;
import com.example.m6.model.Player;

/**
 * Market place class
 */
@SuppressWarnings("CyclicClassDependency")
public class Marketplace extends AppCompatActivity {

    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //noinspection ChainedMethodCall
        player = (Player)getIntent().getSerializableExtra("player");
        //this log checks whether player instance import successfully

        initRecyclerView();

        Button buyButton = findViewById(R.id.button_marketplace_buy);
        Button sellButton = findViewById(R.id.button_marketplace_sell);
        Button menuButton = findViewById(R.id.button_marketplace_menu);

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBuy();
            }
            });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSell();
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

    }
    private void openBuy() {
        Intent intent = new Intent(this, BuyGoodsActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
    private void openSell() {
        Intent intent = new Intent(this, SellGoodsActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
    private void openMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("player", player);
        startActivity(intent);
    }
    private void initRecyclerView(){
        RecyclerView recyclerView  = findViewById(R.id.marketplace_recyclerView);
//        List<Goods> g = Arrays.asList(Goods.values());
        MarketplaceAdapter adapter = new MarketplaceAdapter(player);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
