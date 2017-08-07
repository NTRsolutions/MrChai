package kredivation.mrchai.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import kredivation.mrchai.R;


/**
 * Created by Natayan Semwal on 04-08-2017.
 */

public class ImageChoiceView extends LinearLayout {

    private boolean isChecked;
    protected TextView titleView,description;
    protected ImageView imageView;
    protected View view;

    public ImageChoiceView(Context context) {
        this(context, null, 0);
    }

    public ImageChoiceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImageChoiceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    protected void init() {
        if (this.isInEditMode()) {
            return;
        }
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fn_img_choice_view, this, true);
        titleView = (TextView) view.findViewById(R.id.title);
        description= (TextView) view.findViewById(R.id.desription);
        imageView = (ImageView) view.findViewById(R.id.bgimage);
    }

    public void setTitle(String title) {
        if (this.titleView == null) {
            return;
        }
        this.titleView.setText(title);
    }
    public void setDescription(String description) {
        if (this.description == null) {
            return;
        }
        this.titleView.setText(description);
    }
    public void setTitle(@StringRes int title) {
        if (this.titleView == null) {
            return;
        }
        this.titleView.setText(title);
    }

    public void setTitleColor(int colorId) {
        if (this.titleView == null) {
            return;
        }
        // int resId = FNUIUtil.getColor(getContext(), colorId);
        if (colorId != 0) {
            this.titleView.setTextColor(colorId);
        } else {
            this.titleView.setTextColor(colorId);
        }
    }

    public void setImageDrawable(Drawable icon) {
        if (this.imageView == null) {
            return;
        }
        this.imageView.setVisibility(View.VISIBLE);
        if (icon != null) {
            this.imageView.setImageDrawable(icon);
        }
    }

    public boolean isChecked() {
        return isChecked;
    }


    public void setImageDrawable(int id) {
        imageView.setImageResource(id);
    }
}
