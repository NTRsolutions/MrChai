package kredivation.mrchai.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kredivation.mrchai.R;
import kredivation.mrchai.utilities.FontManager;

public class LoiginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spin;
    private TextView forgotPassword, newUserRegister, newuserfont;
    private Button sigininButon;
    Fragment fr;
    public final static String ICON_FILE = "fonts/fontawesome-webfont.ttf";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loigin);
        Typeface font = FontManager.getFontTypeface(this, ICON_FILE);
        spin = (Spinner) findViewById(R.id.phoneno);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        newuserfont = (TextView) findViewById(R.id.newuserfont);
        newUserRegister = (TextView) findViewById(R.id.newUserRegister);
        sigininButon = (Button) findViewById(R.id.sigininButon);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        usernameWrapper.setHint("Mobile No");
        setPhoneCode();
        newuserfont.setTypeface(font);
        newuserfont.setText(getString(R.string.icon_arrow_right));
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPasswordFragment();
            }
        });

        newUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewUserFragment();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void setPhoneCode() {
        List<String> categories = new ArrayList<String>();
        categories.add("+91 INDIA");
        categories.add("+1 US");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(dataAdapter);

    }

    public void openForgotPasswordFragment() {
        Intent i = new Intent(this, ForgetPaddword.class);
        startActivity(i);

    }

    public void openNewUserFragment() {
        Intent i = new Intent(this, NewUserActivity.class);
        startActivity(i);

    }


}
