package com.example.m6.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.m6.R;

@SuppressWarnings("ALL")
public class BuyDialog extends AppCompatDialogFragment {

    private int price;
    private String goodstype;

    public interface BuyDialogListener{
        void onInputData(String input);
        void buyItem(String goods, int price);
    }

    private BuyDialogListener call;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            call = (BuyDialogListener) activity;
        } catch(ClassCastException e) {
            Log.d("test", "activity doesn't implement");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            price = bundle.getInt("price");
            goodstype = bundle.getString("goodstype");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        @SuppressWarnings("ChainedMethodCall") LayoutInflater inflater = getActivity().getLayoutInflater();
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.buy_dialog, null);
        final EditText input = (EditText)view.findViewById(R.id.buy_input);
        //noinspection ChainedMethodCall,ChainedMethodCall,ChainedMethodCall
        builder.setView(view)
                .setTitle("Enter the amount of items")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         @SuppressWarnings("ChainedMethodCall") String inputStr = input.getText().toString();
//
                         call.onInputData(inputStr);
                         call.buyItem(goodstype, price);
                        dismiss();
                    }
                });


        return builder.create();
    }
}
