package hudiilfeld.theshoppingequalizer;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import hudiilfeld.theshoppingequalizer.sources.MegaUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.RamiLeviUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.ShuferSalUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.SubCategoryNameAndInfo;
import hudiilfeld.theshoppingequalizer.sources.ViktoryUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.YenotBitanUrlDataSource;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {

    private static final String TITLES = "param1";
    private static final String SHOP_CODE = "param2";
    static int shopCode;
    RecyclerView rvSubTitles;

    public static MenuFragment newInstance(int titles, int shopCode) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putInt(TITLES, titles);
        args.putInt(SHOP_CODE, shopCode);
        fragment.setArguments(args);
        return fragment;
    }

    ConstraintLayout menuRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_menu, container, false);
        rvSubTitles = (RecyclerView) v.findViewById(R.id.rvSubTitles);
        menuRoot = (ConstraintLayout) v.findViewById(R.id.menuRoot);
        int position = getArguments().getInt(TITLES);
        shopCode = getArguments().getInt(SHOP_CODE);
        ArrayList<SubCategoryNameAndInfo> getTitles = RamiLeviUrlDataSource.getTitles();

        switch (shopCode){
            case 1:
                getTitles = RamiLeviUrlDataSource.getTitles();
                break;
            case 2:
                getTitles = ShuferSalUrlDataSource.getTitles();
                break;
            case 3:
                getTitles = MegaUrlDataSource.getTitles();
                break;
            case 4:
                getTitles = ViktoryUrlDataSource.getTitles();
                break;
            case 5:
                getTitles = YenotBitanUrlDataSource.getTitles();
                break;
        }

        ArrayList<SubCategoryNameAndInfo> getSpecificTitles = new ArrayList<>();

        switch (position){
            case 1: //לחמים
                for (int i = 0; i <= 3 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 2: //ירקות
                for (int i = 4; i <= 6 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 3: //בשרים
                for (int i = 7; i <= 13 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 4: //חלב וביצים
                for (int i = 14; i <= 24 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 5: //אורגני
                for (int i = 25; i <= 27 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 6: //קפואים
                for (int i = 28; i <= 34 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 7: //שימורים
                for (int i = 35; i <= 61 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 8: //דגנים
                for (int i = 62; i <= 70 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;
            case 9: //מתוקים
                for (int i = 71; i <= 81 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 10: //טיפוח ותינוקות
                for (int i = 82; i <= 105 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 11: //חד פעמי
                for (int i = 106; i <= 107 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 12: //ביגוד
                for (int i = 108; i <= 110 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 13: //אחזקת הבית
                for (int i = 111; i <= 128 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;

            case 14: //שתייה
                for (int i = 129; i <= 142 ; i++) {
                    getSpecificTitles.add(getTitles.get(i));
                }
                break;
        }
        rvSubTitles.setAdapter(new MenuAdapter(getActivity(), getSpecificTitles));
        rvSubTitles.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    public static class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

        LayoutInflater inflater;
        FragmentActivity fragmentActivity;
        List<SubCategoryNameAndInfo> getMenuTitles;

        public MenuAdapter(FragmentActivity fragmentActivity, List<SubCategoryNameAndInfo> getMenuTitles) {
            this.fragmentActivity = fragmentActivity;
            this.getMenuTitles = getMenuTitles;
            this.inflater = LayoutInflater.from(fragmentActivity);
        }

        @Override
        public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.menu_item, parent, false);
            return new MenuViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MenuViewHolder holder, int position) {
            String title = getMenuTitles.get(position).getTitle();
            String[] url = getMenuTitles.get(position).getUrl();
            int id = getMenuTitles.get(position).getId();
            holder.bind(title, url, id);
        }

        @Override
        public int getItemCount() {
            return getMenuTitles.size();
        }

         class MenuViewHolder extends RecyclerView.ViewHolder{
            TextView tvSubCategory;
            CardView cardView;

            public MenuViewHolder(View itemView){
                super(itemView);
                tvSubCategory = (TextView) itemView.findViewById(R.id.tvSubCategory);
                cardView = (CardView) itemView.findViewById(R.id.subCategoryRoot);
            }

            public void bind(final String data, final String[] url, final int id){
                Typeface myCustomFont = Typeface.createFromAsset(fragmentActivity.getAssets(), "fonts/Assistant-ExtraLight.ttf");
                tvSubCategory.setTypeface(myCustomFont);

                cardView.setVisibility(View.INVISIBLE);
                Animation startAnimation = AnimationUtils.loadAnimation(fragmentActivity, R.anim.fade_in_animation);
                cardView.startAnimation(startAnimation);
                cardView.setVisibility(View.VISIBLE);

                tvSubCategory.setText(data);

                tvSubCategory.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        fragmentActivity.getSupportFragmentManager()
                       .beginTransaction()
                                .replace(R.id.frame, new ItemsFragment().newInstance(url, id, shopCode))
                                .addToBackStack(null)
                                .commit();
                    }
                });
            }
        }
    }

}