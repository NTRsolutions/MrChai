package kredivation.mrchai.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import kredivation.mrchai.R;
import kredivation.mrchai.activity.CartActivity;
import kredivation.mrchai.database.MyCart;
import kredivation.mrchai.framework.LruBitmapCache;
import kredivation.mrchai.models.ProductItem;


public class CartListAdapter extends ArrayAdapter<ProductItem> {

    ArrayList<ProductItem> contactlist;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;
    ImageLoader imageLoader;
    Context context;


    public CartListAdapter(Context context, int resource, ArrayList<ProductItem> objects) {
        super(context, resource, objects);

        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        contactlist = objects;

    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.image = (ImageView) v.findViewById(R.id.img_product);
            holder.name = (TextView) v.findViewById(R.id.product_list_name);
            holder.price = (TextView) v.findViewById(R.id.price);
            holder.product_quantity = (TextView) v.findViewById(R.id.product_quantity);
            holder.product_quantity_dec = (ImageView) v.findViewById(R.id.product_quantity_dec);
            holder.product_quantity_inc = (ImageView) v.findViewById(R.id.product_quantity_inc);

            holder.totalprice = (TextView) v.findViewById(R.id.totalprice);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();

        }

        ImageLoader.ImageCache imageCache = new LruBitmapCache();
        ImageLoader imageLoader = new ImageLoader(Volley.newRequestQueue(getContext()), imageCache);
        Picasso.with(context).load(contactlist.get(position).getProductimage()).resize(100, 100).into(holder.image);
        holder.name.setText(contactlist.get(position).getProductname());
        holder.price.setText(contactlist.get(position).getProductprice());
        holder.product_quantity.setText(contactlist.get(position).getProductquantity());
        holder.product_quantity_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(contactlist.get(position).getProductquantity());
                if (qty == 1) {
                    MyCart myCartdb = new MyCart(getContext());
                    myCartdb.open();
                    myCartdb.deleteproduct(contactlist.get(position).getProductid());
                    myCartdb.close();
                    CartListAdapter.this.remove(CartListAdapter.this.getItem(position));
                    CartActivity.updatetotal(100);
                    notifyDataSetChanged();

                } else {

                    // qty=5;
                    qty = qty - 1;
                    contactlist.get(position).setProductquantity(String.valueOf(qty));
                    //Toast.makeText(getContext(), "tttt" + qty, Toast.LENGTH_SHORT).show();
                    holder.product_quantity.setText(String.valueOf(qty));
                    MyCart myCartdb = new MyCart(getContext());
                    myCartdb.open();
                    myCartdb.updateQuantity(contactlist.get(position).getProductid(), String.valueOf(qty));
                    myCartdb.close();
                    CartActivity.updatetotal(100);
                    notifyDataSetChanged();
                }
            }
        });

        holder.product_quantity_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qty = Integer.parseInt(contactlist.get(position).getProductquantity());

                // qty=5;
                qty = qty + 1;
                contactlist.get(position).setProductquantity(String.valueOf(qty));
                //Toast.makeText(getContext(),"tttt"+qty,Toast.LENGTH_SHORT).show();
                holder.product_quantity.setText(String.valueOf(qty));
                MyCart myCartdb = new MyCart(getContext());
                myCartdb.open();
                myCartdb.updateQuantity(contactlist.get(position).getProductid(), String.valueOf(qty));
                myCartdb.close();
                CartActivity.updatetotal(100);
                notifyDataSetChanged();

            }
        });
        return v;

    }

    static class ViewHolder {

        public TextView name, product_quantity, totalprice;
        public TextView price;
        public ImageView image, product_quantity_dec, product_quantity_inc;
        public TextView total;
    }

    public String checkNull(String s) {
        if (s.equals("null"))
            return "N/A";
        else
            return s;
    }
}
