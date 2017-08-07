package kredivation.mrchai.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import kredivation.mrchai.R;
import kredivation.mrchai.adapter.CartListAdapter;
import kredivation.mrchai.adapter.CustomListAdapter;
import kredivation.mrchai.database.MyCart;
import kredivation.mrchai.models.ProductItem;


/**
 * Created by Natayan Semwal on 03-08-2017.
 */

public class CartActivity extends AppCompatActivity {

    LinearLayout continueshopping, checkout;
    ArrayList<ProductItem> productPojoArrayList;
    ListView lv;
    CartListAdapter adapter;
    public static double total = 1562.000;
    public static TextView totalprice;
    ImageView product_quantity_dec, product_quantity_inc;
    public static MyCart mycartdb;


    ListView list;
    String[] itemname = {
            "Tea",
            "Water",
            "Shakes",
            "Hot Tea",
            "Cold Tea",
            "Chai",
            "Lamon Chai",
            "Tea"
    };

    Integer[] imgid = {
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mycartdb = new MyCart(CartActivity.this);
        lv = (ListView) findViewById(R.id.cartlist);
        productPojoArrayList = new ArrayList<ProductItem>();
        totalprice = (TextView) findViewById(R.id.totalprice);
        continueshopping = (LinearLayout) findViewById(R.id.continueshopping);
        checkout = (LinearLayout) findViewById(R.id.checkout);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

        continueshopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list = (ListView)findViewById(R.id.cartlist);
        list.setAdapter(adapter);
        totalprice.setText("RM " + String.valueOf(125));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getBaseContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });




       /* lv = (ListView) findViewById(R.id.cartlist);
        totalprice = (TextView) findViewById(R.id.totalprice);
        continueshopping = (LinearLayout) findViewById(R.id.continueshopping);
        checkout = (LinearLayout) findViewById(R.id.checkout);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });*/



//        DATABASE
        //MyCart mycartdb=new MyCart(CartActivity.this);

      /*  mycartdb.open();
        Cursor c = mycartdb.getAllData();
        if (c.moveToFirst()) {
            do {

                ProductItem item = new ProductItem();
                item.setProductid(c.getString(1));
                item.setProductname(c.getString(2));
                item.setProductimage(c.getString(3));
                item.setProductprice(c.getString(4));
                item.setProductquantity(c.getString(6));
                //total+= Double.parseDouble(c.getString(5));
                productPojoArrayList.add(item);
            } while (c.moveToNext());
        }

        updatetotal(100);
        mycartdb.close();
        adapter = new CartListAdapter(CartActivity.this, R.layout.cart_table_list_item, productPojoArrayList);
        lv.setAdapter(adapter);*/

    }

    public static void updatetotal(long val) {

       // mycartdb.open();
        Cursor c = mycartdb.getAllData();
        total = 0;
        if (c.moveToFirst()) {
            do {

//                int i=Integer.parseInt(c.getString(6));

                total += (Double.parseDouble(c.getString(5))) * Integer.parseInt(c.getString(6));

            } while (c.moveToNext());
        }
        totalprice.setText("RM " + String.valueOf(total));


        mycartdb.close();
    }
}