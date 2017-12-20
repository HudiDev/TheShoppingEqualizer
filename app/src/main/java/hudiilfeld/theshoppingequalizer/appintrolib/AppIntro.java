package hudiilfeld.theshoppingequalizer.appintrolib;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;



import hudiilfeld.theshoppingequalizer.R;
import hudiilfeld.theshoppingequalizer.authentication.LoginActivity;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppIntro extends FragmentActivity {

    ViewPager viewPager;
    CirclePageIndicator circleIndicator;

    @BindView(R.id.fabNext)
    FloatingActionButton fabNext;
    @BindView(R.id.fabBack)
    FloatingActionButton fabBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_intro);
        ButterKnife.bind(this);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        PageFragment.SwipeAdapter swipeAdapter = new PageFragment.SwipeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdapter);

        circleIndicator = (CirclePageIndicator) findViewById(R.id.circleIndicator);
        circleIndicator.setViewPager(viewPager);
    }

    @OnClick({R.id.fabNext, R.id.fabBack})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.fabNext:
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                Log.d("currentItem", String.valueOf(viewPager.getCurrentItem()));
                if (viewPager.getCurrentItem() == 4) {
                    fabNext.setImageResource(R.drawable.ic_check_black_24dp);
                    fabNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intent);
                        }
                    });
                }
                break;
            case R.id.fabBack:
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                fabNext.setImageResource(R.drawable.ic_navigate_next_black_24dp);
                Log.d("currentItem", String.valueOf(viewPager.getCurrentItem()));
                break;
        }

        if (viewPager.getCurrentItem() > 0) {
            fabBack.setVisibility(View.VISIBLE);
        } else {
            fabBack.setVisibility(View.INVISIBLE);
        }
    }
}
