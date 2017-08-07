package kredivation.mrchai.activity;

import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kredivation.mrchai.R;

/**
 * Created by Narayan Semwal on 03-08-2017.
 */

public class SearchActivity extends AppCompatActivity {
    private LayerDrawable mCartMenuIcon;
    private MenuItem mSearchMenu, cart;
    private Button search;
    private EditText searchtext;
    RecyclerView searchrecycle;

    public static long countproductoncart = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        searchrecycle = (RecyclerView) findViewById(R.id.searchrecycle);

        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false);
        searchrecycle.setLayoutManager(verticalLayoutmanager);

        search = (Button) findViewById(R.id.search);
        searchtext = (EditText) findViewById(R.id.searchtext);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.cart, menu);
        mCartMenuIcon = (LayerDrawable) menu.findItem(R.id.action_cart).getIcon();
        mSearchMenu = (MenuItem) menu.findItem(R.id.action_search);
        mSearchMenu.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

}