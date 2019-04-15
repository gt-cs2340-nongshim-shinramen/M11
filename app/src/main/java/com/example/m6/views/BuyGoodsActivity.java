package com.example.m6.views;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m6.R;
import com.example.m6.model.Goods;
import com.example.m6.model.Player;
import com.example.m6.viewmodels.c;

@SuppressWarnings("ALL")
public class BuyGoodsActivity extends AppCompatActivity implements BuyDialog.BuyDialogListener {
    Player player;
    TextView waterPrice;
    TextView furPrice;
    TextView foodPrice;
    TextView orePrice;
    TextView firearmPrice;
    TextView gamePrice;
    TextView medicinePrice;
    TextView machinePrice;
    TextView narcorticsPrice;
    TextView robotPrice;
    int water;
    int fur;
    int food;
    int ore;
    int firearm;
    int game;
    int medicine;
    int machine;
    int narcortics;
    int robot;
    TextView credit;
    TextView bay;
    Button buy_water;
    Button buy_furs;
    Button buy_food;
    Button buy_ore;
    Button buy_games;
    Button buy_firearms;
    Button buy_medicine;
    Button buy_machine;
    Button buy_narcortics;
    Button buy_robot;
    Button waterMax;
    Button furMax;
    Button foodMax;
    Button oreMax;
    Button firearmMax;
    Button gameMax;
    Button medicineMax;
    Button machineMax;
    Button narcorticsMax;
    Button robotMax;
    String inputStr = "0";
    Button menuButton;

    @SuppressWarnings("FeatureEnvy")
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_goods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //noinspection ChainedMethodCall
        player = (Player) getIntent().getSerializableExtra("player");

        menuButton = findViewById(R.id.buy_menu_button);
        menuButton.setText("Menu");
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        credit = findViewById(R.id.buy_credit);
        credit.setText(String.valueOf(player.getCredit()) + " Cr");

        bay = findViewById(R.id.buy_bays);
        //noinspection ChainedMethodCall
        bay.setText(String.valueOf(player.getCargo()) + "/" + player.getSpaceship().getBay());

        setupPrice();


        waterMax = findViewById(R.id.buy_max_water);
        clickMaxButton(waterMax, water, Goods.WATER);

        furMax = findViewById(R.id.buy_max_furs);
        clickMaxButton(furMax, fur, Goods.FURS);

        foodMax = findViewById(R.id.buy_max_food);
        clickMaxButton(foodMax, food, Goods.FOOD);

        oreMax = findViewById(R.id.buy_max_ore);
        clickMaxButton(oreMax, ore, Goods.ORE);

        firearmMax = findViewById(R.id.buy_max_firearms);
        clickMaxButton(firearmMax, firearm, Goods.FIREARMS);

        gameMax = findViewById(R.id.buy_max_games);
        clickMaxButton(gameMax, game, Goods.GAMES);

        medicineMax = findViewById(R.id.buy_max_medicine);
        clickMaxButton(medicineMax, medicine, Goods.MEDICINE);

        machineMax = findViewById(R.id.buy_max_machine);
        clickMaxButton(machineMax, machine, Goods.MACHINES);

        narcorticsMax = findViewById(R.id.buy_max_narcortics);
        clickMaxButton(narcorticsMax, narcortics, Goods.NARCOTICS);

        robotMax = findViewById(R.id.buy_max_robots);
        clickMaxButton(robotMax, robot, Goods.ROBOTS);

        buy_water = findViewById(R.id.buy_num_water);
        clickNumButton(buy_water, water, Goods.WATER);



        buy_furs = findViewById(R.id.buy_num_furs);
        clickNumButton(buy_furs, fur, Goods.FURS);

        buy_food = findViewById(R.id.buy_num_food);
        clickNumButton(buy_food, food, Goods.FOOD);

        buy_ore = findViewById(R.id.buy_num_ore);
        clickNumButton(buy_ore, ore, Goods.ORE);

        buy_games = findViewById(R.id.buy_num_game);
        clickNumButton(buy_games, game, Goods.GAMES);

        buy_firearms = findViewById(R.id.buy_num_firearms);
        clickNumButton(buy_firearms, firearm, Goods.FIREARMS);

        buy_medicine = findViewById(R.id.buy_num_medicine);
        clickNumButton(buy_medicine, medicine, Goods.MEDICINE);

        buy_machine = findViewById(R.id.buy_num_machine);
        clickNumButton(buy_machine, machine, Goods.MACHINES);

        buy_narcortics = findViewById(R.id.buy_num_narcotics);
        clickNumButton(buy_narcortics, narcortics, Goods.NARCOTICS);

        buy_robot = findViewById(R.id.buy_num_robot);
        clickNumButton(buy_robot, robot, Goods.ROBOTS);

        setupStock();
        //this is test for stock that the planet has
        for (Goods g : Goods.values()) {
            //noinspection ChainedMethodCall,ChainedMethodCall,ChainedMethodCall,ChainedMethodCall
            Log.d("stock", g.toString() + " " + String.valueOf(player.getCurrentplanet()
                    .getStock().get(g.toString().toLowerCase())) + " in " +
                    player.getCurrentplanet().getName());
        }

    }
    @SuppressWarnings("FeatureEnvy")
    public void clickMaxButton(Button button, final int price, final Goods goods) {
        //noinspection FeatureEnvy
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(IsAble(goods)) {
                    @SuppressWarnings("ChainedMethodCall") int max = Math.min(player.getSpaceship().getBay() - player.getCargo(),
                            player.getCredit() / price);
                    if (max > 0) {
                        //noinspection ChainedMethodCall,ChainedMethodCall,ChainedMethodCall
                        player.getInven().put(goods.toString().toLowerCase(),
                                player.getInven().get(goods.toString().toLowerCase())+max);
                        player.setCargo(player.getCargo() + max);
                        player.setCredit(player.getCredit() - max * price);
                        //noinspection ChainedMethodCall
                        bay.setText(String.valueOf(player.getCargo()) + "/" +
                                player.getSpaceship().getBay());
                        credit.setText(String.valueOf(player.getCredit()) + " Cr");
                        Toast.makeText(getApplicationContext(), "You bought " + max + " " +
                                goods.toString(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "You can not buy anymore. " +
                                "Check your bay or credit.", Toast.LENGTH_LONG).show();
                    }
                } else {
                        openAlert();
                }
            }
        });
    }
    public void clickNumButton(final Button button, final int price, final Goods goods){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(IsAble(goods)){
                    openBuy(goods.toString(), price);
                } else {
                    openAlert();
                }
            }
        });
    }

    @SuppressWarnings("FeatureEnvy")
    public void setupPrice() {
        String price;

        waterPrice = findViewById(R.id.buy_price_water);
        if (IsAble(Goods.WATER)){
            water = c.calculatePrice(Goods.WATER, player.getCurrentplanet());
            price = water + " cr";
        }
        else {
            price = "N/A";
        }
        waterPrice.setText(price);

        furPrice = findViewById(R.id.buy_price_furs);
        if (IsAble(Goods.FURS)){
            fur = c.calculatePrice(Goods.FURS, player.getCurrentplanet());
            price = fur + " cr";
        }  else {
            price = "N/A";
        }
        furPrice.setText(price);

        foodPrice = findViewById(R.id.buy_price_food);
        if (IsAble(Goods.FOOD)) {
            food = c.calculatePrice(Goods.FOOD, player.getCurrentplanet());
            price = food +" cr";
        } else {
            price = "N/A";
        }
        foodPrice.setText(price);

        orePrice = findViewById(R.id.buy_price_ore);
        if (IsAble(Goods.ORE)) {
            ore = c.calculatePrice(Goods.ORE, player.getCurrentplanet());
            price = ore + " cr";
        } else {
            price = "N/A";
        }
        orePrice.setText(price);

        gamePrice = findViewById(R.id.buy_price_games);
        if (IsAble(Goods.GAMES)) {
            game = c.calculatePrice(Goods.GAMES, player.getCurrentplanet());
            price = game +" cr";
        } else {
            price = "N/A";
        }
        gamePrice.setText(price);

        firearmPrice = findViewById(R.id.buy_price_firearms);
        if (IsAble(Goods.FIREARMS)) {
            firearm = c.calculatePrice(Goods.FIREARMS, player.getCurrentplanet());
            price = firearm+" cr";
        } else {
            price = "N/A";
        }
        firearmPrice.setText(price);

        medicinePrice = findViewById(R.id.buy_price_medicine);
        if (IsAble(Goods.MEDICINE)){
            medicine = c.calculatePrice(Goods.MEDICINE, player.getCurrentplanet());
            price = medicine + " cr";
        } else {
            price = "N/A";
        }
        medicinePrice.setText(price);

        machinePrice = findViewById(R.id.buy_price_machine);
        if (IsAble(Goods.MACHINES)) {
            machine = c.calculatePrice(Goods.MACHINES, player.getCurrentplanet());
            price = machine +" cr";
        } else {
            price = "N/A";
        }
        machinePrice.setText(price);

        narcorticsPrice = findViewById(R.id.buy_price_narcortics);
        if (IsAble(Goods.NARCOTICS)){
            narcortics = c.calculatePrice(Goods.NARCOTICS, player.getCurrentplanet());
            price = narcortics+ " cr";
        } else {
            price = "N/A";
        }
        narcorticsPrice.setText(price);

        robotPrice = findViewById(R.id.buy_price_robots);
        if (IsAble(Goods.ROBOTS)){
            robot = c.calculatePrice(Goods.ROBOTS, player.getCurrentplanet());
            price = robot +" cr";
        } else {
            price = "N/A";
        }
        robotPrice.setText(price);

    }

    @SuppressWarnings("FeatureEnvy")
    public void setupStock(){
        String n;


        if(IsAble(Goods.WATER)){
            //noinspection ChainedMethodCall,ChainedMethodCall
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.WATER.toString().toLowerCase()));
//            Log.d("stock", n);
        } else {
            n="N/A";

        }

        buy_water.setText(n);

        if(IsAble(Goods.FURS)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.FURS.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_furs.setText(n);

        if(IsAble(Goods.FOOD)){
            //noinspection ChainedMethodCall
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.FOOD.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_food.setText(n);

        if(IsAble(Goods.ORE)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.ORE.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_ore.setText(n);

        if(IsAble(Goods.GAMES)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.GAMES.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_games.setText(n);

        if(IsAble(Goods.FIREARMS)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.FIREARMS.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_firearms.setText(n);

        if(IsAble(Goods.MEDICINE)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.MEDICINE.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_medicine.setText(n);

        if(IsAble(Goods.MACHINES)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.MACHINES.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_machine.setText(n);

        if(IsAble(Goods.NARCOTICS)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.NARCOTICS.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_narcortics.setText(n);

        if(IsAble(Goods.ROBOTS)){
            n = String.valueOf(player.getCurrentplanet().getStock()
                    .get(Goods.ROBOTS.toString().toLowerCase()));
        } else {
            n="N/A";
        }
        buy_robot.setText(n);


    }


    boolean IsAble(Goods goods) {
        return player.getCurrentplanet().getTechLevel() - goods.getMTLP() >= 0;
    }
    public void openAlert(){
        AlertWindow alert = new AlertWindow();
        alert.show(getSupportFragmentManager(), "alert");
    }
    public void openBuy(String goods, int price) {
        DialogFragment frag = new BuyDialog();

        Bundle bundle = new Bundle();
        bundle.putString("goodstype", goods);
        bundle.putInt("price", price);
        frag.setArguments(bundle);


        frag.show(getSupportFragmentManager(), "dialog");

    }

    @Override
    public void onInputData(String input) {
        Toast.makeText(this, input+" items is purchased", Toast.LENGTH_LONG).show();
        inputStr =(input);
    }

    @SuppressWarnings({"FeatureEnvy", "UnclearExpression"})
    @SuppressLint("SetTextI18n")
    @Override
    public void buyItem(String goods, int price) {
        int max = Math.min(Math.min(player.getSpaceship().getBay() - player.getCargo(),
                player.getCredit() / price),
                player.getCurrentplanet().getStock().get(goods.toLowerCase()));

        if (max > 0) {
            if(player.getCredit() - Integer.parseInt(inputStr) * price >= 0 && player.getCargo() +
                    Integer.parseInt(inputStr)<=player.getSpaceship().getBay()) {
                player.getInven().put(goods.toLowerCase(),
                        player.getInven().get(goods.toLowerCase())+Integer.parseInt(inputStr));
                player.setCargo(player.getCargo() + Integer.parseInt(inputStr));
                player.setCredit(player.getCredit() - Integer.parseInt(inputStr) * price);
                bay.setText(String.valueOf(player.getCargo()) + "/" +
                        player.getSpaceship().getBay());
                credit.setText(String.valueOf(player.getCredit()) + " Cr");
                player.getCurrentplanet().getStock().put(goods.toLowerCase(),
                        player.getCurrentplanet().getStock().get(goods.toLowerCase())
                                - Integer.parseInt(inputStr));
                setupStock();
                Toast.makeText(getApplicationContext(), "You bought " + inputStr + " " +
                        goods, Toast.LENGTH_LONG).show();
            } else if(player.getCredit() - Integer.parseInt(inputStr) * price <= 0) {
                Toast.makeText(getApplicationContext(), "You do not have enough credit.",
                        Toast.LENGTH_LONG).show();
            } else if(player.getSpaceship().getBay() - player.getCargo() <=0){
                Toast.makeText(getApplicationContext(),
                        "You do not have enough room in your cargo.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(),
                        "you are trying to buy more than planet has", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),
                    "You can not buy anymore. Check your bay or credit.", Toast.LENGTH_LONG).show();
        }
    }

    public void openMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("player", player);
        finish();
        startActivity(intent);
    }

    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Discard Or Not");
        builder.setMessage("Do you want to discard this? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
