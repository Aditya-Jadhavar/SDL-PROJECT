package com.example.withbash.ui.pay;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.withbash.R;
import com.example.withbash.ui.DataHolder;

import java.util.List;

/*public class CartAdapter extends ArrayAdapter{
    private Activity mContext;
    List<DataHolder> Data;

    public CartAdapter(Activity mContext, List<DataHolder> Data){
        super(mContext, R.layout.cart_items_list,Data);
        this.mContext = mContext;
        this.Data = Data;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
       // View listItemView = inflater.inflate(R.layout.cart_items_list,null,attachToRoot: true);
        @SuppressLint("ViewHolder") View listItemView = inflater.inflate(R.layout.cart_items_list,null,true);

        TextView tvName = listItemView.findViewById(R.id.cart_title);
        TextView tvPackage =listItemView.findViewById(R.id.cart_package);
        TextView tvPrice = listItemView.findViewById(R.id.total_Price);

        DataHolder Uid = Data.get(position);

        tvName.setText(Uid.getEventName());
        tvPackage.setText(Uid.getPackages());
        tvPrice.setText(Uid.getCost());


        return listItemView;

    }
}
*/
