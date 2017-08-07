package kredivation.mrchai.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import kredivation.mrchai.R;


public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    int quantity;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.fragment_icedteafragment_list, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.fragment_icedteafragment_list, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.product_list_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img_product);
        TextView extratxt = (TextView) rowView.findViewById(R.id.price);

        final TextView cart_product_quantity_tv = (TextView) rowView.findViewById(R.id.cart_product_quantity_tv);
        ImageView cart_minus_img = (ImageView) rowView.findViewById(R.id.cart_minus_img);
        ImageView cart_plus_img = (ImageView) rowView.findViewById(R.id.cart_plus_img);
        cart_plus_img.setClickable(true);
        cart_minus_img.setClickable(true);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("RS. " + 155);
        cart_plus_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                cart_product_quantity_tv.setText(quantity + "");

            }
        });

        cart_minus_img.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                quantity--;
                cart_product_quantity_tv.setText(quantity + "");

            }
        });
        return rowView;

    }


}
