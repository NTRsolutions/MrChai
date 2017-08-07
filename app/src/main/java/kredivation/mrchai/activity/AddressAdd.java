package kredivation.mrchai.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kredivation.mrchai.R;

/**
 * Created by Natayan Semwal on 04-08-2017.
 */

public class AddressAdd extends AppCompatActivity {

    EditText chk_fullname, chk_mobile, chk_pincode, chk_flat, chk_colony;
    Button btnadd;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_add);
        //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Address Book");



        mProgressDialog = new ProgressDialog(AddressAdd.this);
        chk_fullname = (EditText) findViewById(R.id.chk_fullname);
        chk_mobile = (EditText) findViewById(R.id.chk_mobile);
        chk_pincode = (EditText) findViewById(R.id.chk_pincode);
        chk_flat = (EditText) findViewById(R.id.chk_flat);
        chk_colony = (EditText) findViewById(R.id.chk_colony);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk_fullname.getText().toString().trim().length() == 0 || chk_mobile.getText().toString().trim().length() == 0 || chk_pincode.getText().toString().trim().length() == 0 || chk_flat.getText().toString().trim().length() == 0 || chk_colony.getText().toString().trim().length() == 0) {
                    Toast.makeText(AddressAdd.this, "Please fill all fields.", Toast.LENGTH_SHORT).show();
                } else {
                }
            }
        });


    }

}
