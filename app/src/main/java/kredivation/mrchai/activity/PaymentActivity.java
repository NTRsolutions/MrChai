package kredivation.mrchai.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import kredivation.mrchai.R;

/**
 * Created by Natayan Semwal on 04-08-2017.
 */

public class PaymentActivity extends AppCompatActivity {

    double shippingcharge;
    String addressid = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
       //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
