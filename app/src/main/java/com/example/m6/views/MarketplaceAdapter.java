package com.example.m6.views;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.m6.R;
import com.example.m6.model.Goods;
import com.example.m6.model.Player;
import com.example.m6.viewmodels.c;

import java.util.Arrays;
import java.util.List;

/**
 * market place adapter for recycler view
 */
@SuppressWarnings({"ChainedMethodCall", "CanBeFinal"})
public class MarketplaceAdapter extends RecyclerView.Adapter<MarketplaceAdapter
        .MarketplaceViewHolder> {
//    private List<Goods> goodsList = new ArrayList<>();
    @SuppressWarnings("FieldMayBeFinal")
    private List<Goods> goodsList = Arrays.asList(Goods.values());
    @SuppressWarnings("FieldMayBeFinal")
    private Player player;

    /**
     * market place adapter with player
     * @param mplayer player class
     */
    public MarketplaceAdapter(Player mplayer){
//        goodsList = goods;
        player = mplayer;
    }

    @NonNull
    @Override
    public MarketplaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        @SuppressWarnings("ChainedMethodCall") View itemView =
                LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.marketplace_item, viewGroup, false);
        return new MarketplaceViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MarketplaceViewHolder viewHolder, int i) {

        Goods goods = goodsList.get(i);
        viewHolder.item.setText(goods.toString());
        //noinspection LawOfDemeter
        viewHolder.stock.setText(String.valueOf(player.getCurrentplanet().getStock()
                .get(goods.toString().toLowerCase())));
        viewHolder.price.setText(String.valueOf(c.calculatePrice(goods, player.getCurrentplanet()))
                +" cr");
    }

    @Override
    public int getItemCount() {
        int count = goodsList.size();
        for(Goods g: goodsList) {
            //noinspection LawOfDemeter
            if (((player.getCurrentplanet().getTechLevel() - g.getMTLP()) < 0)) {
                count--;
            }
        }
        return count;
    }

    @SuppressWarnings("CanBeFinal")
    public class MarketplaceViewHolder extends RecyclerView.ViewHolder{

        TextView item;
        TextView stock;
        TextView price;

        MarketplaceViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.marketplace_item);
            stock = itemView.findViewById(R.id.marketplace_stock);
            price = itemView.findViewById(R.id.marketplace_price);
        }
    }
}
