package kredivation.mrchai.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import kredivation.mrchai.R;
import kredivation.mrchai.component.ImageChoiceView;
import kredivation.mrchai.fragment.HotTeaFragment;
import kredivation.mrchai.fragment.IcedTeaFragmentFragment;

import static kredivation.mrchai.utilities.BadgeDrawable.setBadgeCount;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private LinearLayout meggiLayout, hotTeaLayou, iceTeaLayout, shakesLayot;
    Fragment fr;
    private Toolbar toolbar;
    private Typeface _sTypeface;
    public final static String ICON_FILE = "fonts/fontawesome-webfont.ttf";

    private static DashboardActivity applicationObj;

    public static DashboardActivity application() {
        return applicationObj;
    }

    private LayerDrawable mCartMenuIcon;
    private MenuItem mSearchMenu, cart;
    private int mCartCount;
    ImageChoiceView firstTileImage, secondTileImage, thirdTileImge, fourthTileImge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loadView();
        allFragment();
        dataToView();

    }

    public void loadView() {
        hotTeaLayou = (LinearLayout) findViewById(R.id.hotTeaLayout);
        iceTeaLayout = (LinearLayout) findViewById(R.id.iceTealayout);
        shakesLayot = (LinearLayout) findViewById(R.id.shakesLayout);
        meggiLayout = (LinearLayout) findViewById(R.id.meggiLayout);
        firstTileImage = (ImageChoiceView) findViewById(R.id.hotTeaImage);
        secondTileImage = (ImageChoiceView) findViewById(R.id.secondTeaImage);
        thirdTileImge = (ImageChoiceView) findViewById(R.id.thirdTileImage);
        fourthTileImge = (ImageChoiceView) findViewById(R.id.fourthTileIMage);

    }

    public void dataToView() {
        firstTileImage.setTitle("Hot Dog");
        firstTileImage.setImageDrawable(R.drawable.ffr_eosubindustry);

        secondTileImage.setTitle("Hot Tea");
        secondTileImage.setImageDrawable(R.drawable.others_eoindustry);

        thirdTileImge.setTitle("Cold Tea");
        thirdTileImge.setImageDrawable(R.drawable.others_eosubindustry);

        fourthTileImge.setTitle("Shakes");
        fourthTileImge.setImageDrawable(R.drawable.retail_eoindustry);


    }


    public void allFragment() {
        hotTeaLayou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbar.setTitle("Tea Item List");
                 fr = new HotTeaFragment();
                changeFragnment(fr);
            }
        });
        iceTeaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 fr = new IcedTeaFragmentFragment();
                changeFragnment(fr);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.cart, menu);
        mCartMenuIcon = (LayerDrawable) menu.findItem(R.id.action_cart).getIcon();
        mSearchMenu = menu.findItem(R.id.action_search);
        cart = menu.findItem(R.id.action_cart);
        MenuItem itemCart = menu.findItem(R.id.action_cart);
        LayerDrawable icon = (LayerDrawable) cart.getIcon();
        setBadgeCount(this, icon, "9");
        mSearchMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(DashboardActivity.this, SearchActivity.class);
                startActivity(i);
                return false;
            }
        });

        cart.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(DashboardActivity.this, CartActivity.class);
                startActivity(i);
                return false;
            }
        });


        // setBadgeCount(this, mCartMenuIcon, String.valueOf(countproductoncart));
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_ordernow) {
            Intent intent = new Intent(DashboardActivity.this, CartActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_storelocation) {

        } else if (id == R.id.nav_faq) {

        } else if (id == R.id.nav_login) {
            Intent i = new Intent(DashboardActivity.this, LoiginActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_send) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void changeFragnment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.addToBackStack(DashboardActivity.class.getSimpleName());
        fragmentTransaction.commit();
    }

    public Typeface getIconTypeFace() {
        if (this._sTypeface == null) {
            this.initIcons();
        }
        return this._sTypeface;
    }

    public void initIcons() {
        this._sTypeface = Typeface.createFromAsset(this.getAssets(), ICON_FILE);
    }


}


