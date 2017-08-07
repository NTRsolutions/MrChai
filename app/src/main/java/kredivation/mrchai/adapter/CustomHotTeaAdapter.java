package kredivation.mrchai.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import kredivation.mrchai.R;


public class CustomHotTeaAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] itemprice;

    public CustomHotTeaAdapter(Activity context, String[] itemname, String[] itemprice, Integer[] imgid) {
        super(context, R.layout.hot_tea_fragment, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.imgid = imgid;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.hot_tea_fragment, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.product_list_name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img_product);
        TextView extratxt = (TextView) rowView.findViewById(R.id.price);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText(""+itemprice[position]);
        return rowView;

    }

    ;


       /*
        ArrayAdapter<HteaItemObject> {

    private LayoutInflater lInflater;
    private ArrayList<HteaItemObject> listStorage = new ArrayList<>();
    Context context;


    public CustomHotTeaAdapter(Context context, int resourceId, List<HteaItemObject> items) {
        super(context, resourceId, items);
        this.context = context;
    }

  *//*  public CustomHotTeaAdapter(Context context, ArrayList<HteaItemObject> customizedListView) {
        this.context = context;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (customizedListView != null) {
            listStorage = customizedListView;

        }
    }*//*

    @Override
    public int getCount() {
        return listStorage.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        HteaItemObject rowItem = getItem(position);
        if (convertView == null) {
            listViewHolder = new ViewHolder();
            convertView = lInflater.inflate(R.layout.fragment_list, parent, false);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            listViewHolder.img_product = (ImageView) convertView.findViewById(R.id.img_product);
            listViewHolder.product_list_name = (TextView) convertView.findViewById(R.id.product_list_name);
            listViewHolder.price = (TextView) convertView.findViewById(R.id.price);
            listViewHolder.addtocart = (ImageView) convertView.findViewById(R.id.addtocart);
            listViewHolder.removefromcart = (ImageView) convertView.findViewById(R.id.removefromcart);
            convertView.setTag(listViewHolder);
        } else
            listViewHolder = (ViewHolder) convertView.getTag();

        listViewHolder.product_list_name.setText(rowItem.getProduct_list_name());
        listViewHolder.price.setText(rowItem.getPrice());
        listViewHolder.img_product.setImageResource(rowItem.getImg_product_url());


        return convertView;
    }

    static class ViewHolder {
        TextView product_list_name;
        TextView price;
        ImageView img_product;
        ImageView addtocart;
        ImageView removefromcart;
    }*/
}
