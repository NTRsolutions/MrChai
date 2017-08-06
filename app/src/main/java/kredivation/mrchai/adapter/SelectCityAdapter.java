package kredivation.mrchai.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import kredivation.mrchai.R;
import kredivation.mrchai.models.Data;
import kredivation.mrchai.utilities.FontManager;


public class SelectCityAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Data> cityList;

    private Context mContext;
    private Typeface materialDesignIcons, roboto_regular;
    private Boolean addNewAddressFlage;

    public SelectCityAdapter(Context mContext, List<Data> list) {
        mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.cityList = list;
        this.materialDesignIcons = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
        this.roboto_regular = FontManager.getFontTypeface(mContext, "fonts/roboto.regular.ttf");
    }

    public SelectCityAdapter(Context mContext, List<Data> list, Boolean addNewAddressFlage) {
        mInflater = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.cityList = list;
        this.addNewAddressFlage = addNewAddressFlage;
        this.materialDesignIcons = FontManager.getFontTypefaceMaterialDesignIcons(mContext, "fonts/materialdesignicons-webfont.otf");
        this.roboto_regular = FontManager.getFontTypeface(mContext, "fonts/roboto.regular.ttf");
    }

    @Override
    public int getCount() {

        return cityList.size();
    }


    @Override
    public Object getItem(int arg0) {

        return null;
    }

    @Override
    public long getItemId(int arg0) {

        return 0;
    }

    @Override
    public View getView(final int position, View convertview, ViewGroup parent) {
        ViewHolder holder;
        if (convertview == null) {
            convertview = mInflater.inflate(R.layout.state_item, null);
            holder = new ViewHolder();
            {
                holder.title = (TextView) convertview.findViewById(R.id.name);
                //holder.icon = (TextView) convertview.findViewById(R.id.icon);
                //holder.icon.setTypeface(custom_fontawesome);
                holder.title.setTypeface(roboto_regular);
                // holder.icon.setText(Html.fromHtml("&#xf19c;"));
                convertview.setTag(holder);
            }
        } else {
            holder = (ViewHolder) convertview.getTag();
        }
        return convertview;
    }

    public static class ViewHolder {
        TextView title, icon;

    }
}
