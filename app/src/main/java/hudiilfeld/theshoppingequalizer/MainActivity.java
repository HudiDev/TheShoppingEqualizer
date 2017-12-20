package hudiilfeld.theshoppingequalizer;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import hudiilfeld.theshoppingequalizer.authentication.LoginActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvMainTitle;
    TextView tvMoto;
    TextView tvWelcome;
    ImageView imgProfile;
    TextView loginNavBarName;
    View navHeaderMain;
    String userName;
    Uri userprofilePic;

    @BindView(R.id.ramiLevi)
    CircleImageView ramiLevi;
    @BindView(R.id.shufersal)
    CircleImageView shufersal;
    @BindView(R.id.mega)
    CircleImageView mega;
    @BindView(R.id.viktory)
    CircleImageView viktory;
    @BindView(R.id.yenotBitan)
    CircleImageView yenotBitan;


    private SignInButton btnGoogle;
    private GoogleApiClient mGoogleApiClient;
    private static final int RC_SIGN_IN = 1;
    private static final String TAG = "Main_Activity";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        navHeaderMain = inflater.inflate(R.layout.nav_header_main, null);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvMoto = (TextView) findViewById(R.id.tvMoto);
        tvMainTitle = (TextView) findViewById(R.id.tvMainTitle);

        tvMoto.setText("כשקנייה בסופר הופכת לטכניקה.");

        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        loginNavBarName = (TextView) navHeaderMain.findViewById(R.id.loginNavBarName);

        setTextFonts();

        userName = getIntent().getStringExtra("userName");
        userprofilePic = getIntent().getParcelableExtra("userprofilePic");

        tvWelcome.setText("ברוכים הבאים   " + userName);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View view = navigationView.getHeaderView(0);
        imgProfile = (ImageView) view.findViewById(R.id.imgProfile);

        Picasso.with(this)
                .load(userprofilePic)
                .resize(120, 120)
                .into(imgProfile);

        //Log.d("MAuserName", userName);


//        //if this is the first time the user is accesing the app then:
//        SharedPreferences prefs = getSharedPreferences("app intro", Context.MODE_PRIVATE);
//        boolean gotit = prefs.getBoolean("gotitLib", false);
//
////        if(!gotit){
//        //startActivity(new Intent(this, AppIntroLibActivity.class));
////        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                startActivity(new Intent(this, LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ramiLevi) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HeadCategories().newInstance(1))
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.shuferSal) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HeadCategories().newInstance(2))
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.mega) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HeadCategories().newInstance(3))
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.viktory) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HeadCategories().newInstance(4))
                    .addToBackStack(null)
                    .commit();
        } else if (id == R.id.yenotBitan) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new HeadCategories().newInstance(5))
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.myBasket) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new MyBasketFragment())
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.compare) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new DisplayPricesFragment())
                    .addToBackStack(null)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setTextFonts() {
        Typeface myCustomFontSubMain = Typeface.createFromAsset(this.getAssets(), "fonts/Assistant-SemiBold.ttf");
        Typeface myCustomFontMainTitle = Typeface.createFromAsset(this.getAssets(), "fonts/DancingScript-Regular.ttf");
        Typeface myCustomFontMainTitle2 = Typeface.createFromAsset(this.getAssets(), "fonts/DancingScript-Bold.ttf");
        tvMoto.setTypeface(myCustomFontSubMain);
        tvMainTitle.setTypeface(myCustomFontMainTitle);
        tvWelcome.setTypeface(myCustomFontSubMain);
    }


    @OnClick({R.id.ramiLevi, R.id.shufersal, R.id.mega, R.id.viktory, R.id.yenotBitan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ramiLevi:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HeadCategories().newInstance(1))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.shufersal:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HeadCategories().newInstance(2))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.mega:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HeadCategories().newInstance(3))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.viktory:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HeadCategories().newInstance(4))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.yenotBitan:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HeadCategories().newInstance(5))
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
