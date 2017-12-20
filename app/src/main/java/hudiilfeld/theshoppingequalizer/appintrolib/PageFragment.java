package hudiilfeld.theshoppingequalizer.appintrolib;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import hudiilfeld.theshoppingequalizer.R;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */



public class PageFragment extends Fragment {

    public static PageFragment newInstance(String title, String msg, int thumb) {
        PageFragment fragment = new PageFragment();

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("msg", msg);
        args.putInt("thumb", thumb);
        fragment.setArguments(args);

        return fragment;
    }

    TextView message;
    TextView title;
    ImageView imageView;
    ConstraintLayout introLayout;
    static CirclePageIndicator circleIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_intro, container, false);

        String title1 = getArguments().getString("title");
        String msg = getArguments().getString("msg");
        int thumb = getArguments().getInt("thumb");


        message = (TextView) view.findViewById(R.id.msg);
        title = (TextView) view.findViewById(R.id.title);
        introLayout = (ConstraintLayout) view.findViewById(R.id.fragId);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        circleIndicator = (CirclePageIndicator) view.findViewById(R.id.circleIndicator);

        setTextFonts();

        title.setText(title1);
        message.setText(msg);
        introLayout.setBackgroundResource(thumb);


        return view;
    }

    static class SwipeAdapter extends FragmentStatePagerAdapter {

        List<IntroPageInfo> allInfo = getItem();

        public SwipeAdapter (FragmentManager fm){
            super(fm);
        }

        public List<IntroPageInfo> getItem() {
            List<IntroPageInfo> allInfo = new ArrayList<>();

            allInfo.add(new IntroPageInfo("1. בחר חנות",
                    "בחר לך אחד מרשתות המזון המובילות מהרשימה שאנחנו מציעים.",
                    R.drawable.nature3));
            allInfo.add(new IntroPageInfo("2. בחר קטגוריית מזון",
                    "אנו מציעים מגוון רחב של כלל קטגוריות המזון האפשריות.",
                    R.drawable.nature5));
            allInfo.add(new IntroPageInfo("3. הוסף לסל",
                    "על כל מוצר ישנה כפתור המאפשר לך להוסיף אותו לסל האישי שלך.",
                    R.drawable.nature4));
            allInfo.add(new IntroPageInfo("4. השוואת מחירים",
                    "כחלק מהשירותים שאנו מציעים אנו מבצעים השוואת מחירים על כל הסל האישי, עם רשתות מזון מתחרות בכדי להשיג את המחיר הנוח ביותר.",
                    R.drawable.nature2));
            allInfo.add(new IntroPageInfo("5. בצע קנייה:)",
                    "וכעת לשלב הסופי, כעת תוכל להזמין את המוצרים שבחרת דרך האפליקציה",
                    R.drawable.nature6));

            return allInfo;
        }


        @Override
        public Fragment getItem(int i) {
            IntroPageInfo info = allInfo.get(i);
            PageFragment fragment = new PageFragment().newInstance(info.title, info.message, info.image);
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }


    static class IntroPageInfo {
        String title;
        String message;
        int image;

        public IntroPageInfo(String title, String message, int image) {
            this.title = title;
            this.message = message;
            this.image = image;
        }
    }


    private void setTextFonts() {
        Typeface textFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-SemiBold.ttf");
        message.setTypeface(textFont);
        title.setTypeface(textFont);
    }
}
