package kredivation.mrchai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kredivation.mrchai.R;


public class NewUserActivity extends AppCompatActivity {
    private Spinner spin, emailId;
    private TextView signIn;
    Fragment fr;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        spin = (Spinner) findViewById(R.id.phoneno);
        emailId = (Spinner) findViewById(R.id.emailId);
        signIn = (TextView) findViewById(R.id.signIn);
        setPhoneCode();
        setEmailId();
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewUserActivity.this, LoiginActivity.class);
                startActivity(i);
            }
        });
    }


    public void setPhoneCode() {
        List<String> categories = new ArrayList<String>();
        categories.add("+91 INDIA");
        categories.add("+1 US");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);

    }

    public void setEmailId() {
        List<String> categories = new ArrayList<String>();
        categories.add("npsemwal93@gmail.com");
        categories.add("test@gmail.com");
        categories.add("ajay@gmail.com");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emailId.setAdapter(dataAdapter);

    }


}
