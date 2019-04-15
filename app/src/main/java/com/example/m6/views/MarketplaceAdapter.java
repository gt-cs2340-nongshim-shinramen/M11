package com.example.m6.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.m6.R;
import com.example.m6.model.Goods;
import com.example.m6.model.Planet;
import com.example.m6.model.Player;
import com.example.m6.viewmodels.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketplaceAdapter extends RecyclerView.Adapter<MarketplaceAdapter.MarketplaceViewHolder> {
    private static final String TAG = "MarketplaceAdapter";
//    private List<Goods> goodsList = new ArrayList<>();
    private List<Goods> goodsList = Arrays.asList(Goods.values());
    private Player player;

    public MarketplaceAdapter(Player mplayer){
//        goodsList = goods;
        player = mplayer;
    }

    @NonNull
    @Override
    public MarketplaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.marketplace_item, viewGroup, false);
        return new MarketplaceViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MarketplaceViewHolder viewHolder, int i) {

        Goods goods = goodsList.get(i);
        viewHolder.item.setText(goods.toString());
        viewHolder.stock.setText(String.valueOf(player.getCurrentplanet().getStock().get(goods.toString().toLowerCase())));
        viewHolder.price.setText(String.valueOf(c.calculatePrice(goods, player.getCurrentplanet()))+" cr");
    }

    @Override
    public int getItemCount() {
        int count = goodsList.size();
        for(Goods g: goodsList) {
            if ((player.getCurrentplanet().getTechLevel() - g.getMTLP() < 0)) {
                count--;
            }
        }
        return count;
    }

    public class MarketplaceViewHolder extends RecyclerView.ViewHolder{

        TextView item, stock, price;

        public MarketplaceViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.marketplace_item);
            stock = itemView.findViewById(R.id.marketplace_stock);
            price = itemView.findViewById(R.id.marketplace_price);
        }
    }
}
