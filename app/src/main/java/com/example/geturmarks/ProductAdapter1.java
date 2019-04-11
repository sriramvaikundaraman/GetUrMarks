package com.example.geturmarks;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter1 extends RecyclerView.Adapter<ProductAdapter1.ProductViewHolder>{


    private Context mCtx;
    private List<Product1> productList1;


    public ProductAdapter1(Context mCtx, List<Product1> productList1) {
        this.mCtx = mCtx;
        this.productList1 = productList1;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list1, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product1 product1 = productList1.get(position);

        //loading the image


        holder.r.setText(product1.getRollno());
        holder.m.setText(product1.getSubject());


    }

    @Override
    public int getItemCount() {
        return productList1.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView r,m;

        public ProductViewHolder(View itemView) {
            super(itemView);

            r = itemView.findViewById(R.id.r);
            m= itemView.findViewById(R.id.m);




        }
    }
}



