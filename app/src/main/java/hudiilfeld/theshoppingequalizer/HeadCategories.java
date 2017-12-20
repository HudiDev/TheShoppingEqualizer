package hudiilfeld.theshoppingequalizer;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeadCategories extends Fragment {


    @BindView(R.id.breads)
    Button breads;
    @BindView(R.id.vegetables)
    Button vegetables;
    @BindView(R.id.meats)
    Button meats;
    @BindView(R.id.eggs)
    Button eggs;
    @BindView(R.id.healthy)
    Button healthy;
    @BindView(R.id.frozens)
    Button frozens;
    @BindView(R.id.pickles)
    Button pickles;
    @BindView(R.id.cereals)
    Button cereals;
    @BindView(R.id.sweets)
    Button sweets;
    Unbinder unbinder;
    ScrollView rootElement;
    @BindView(R.id.cosmetics)
    Button cosmetics;
    @BindView(R.id.disposable)
    Button disposable;
    @BindView(R.id.clothing)
    Button clothing;
    @BindView(R.id.maintenance)
    Button maintenance;
    @BindView(R.id.drinks)
    Button drinks;

    @BindViews({ R.id.breads, R.id.vegetables, R.id.meats, R.id.eggs, R.id.healthy, R.id.frozens,
                    R.id.pickles, R.id.cereals, R.id.sweets, R.id.cosmetics, R.id.disposable,
                     R.id.clothing, R.id.maintenance, R.id.drinks})
    List<Button> nameViews;

    ImageView shopLogo;

    private static final String ARG_PARAM1 = "param1";
    int shopCode;

    public HeadCategories() {
        // Required empty public constructor
    }

    public static HeadCategories newInstance(int shopCode) {
        HeadCategories fragment = new HeadCategories();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, shopCode);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_head_categories, container, false);
        rootElement = (ScrollView) v.findViewById(R.id.rootElement);
        shopCode = getArguments().getInt(ARG_PARAM1);

        shopLogo = (ImageView) v.findViewById(R.id.shopLogo);

        switch (shopCode) {
            case 1:
                shopLogo.setImageResource(R.drawable.rami_levi_icon);
                break;
            case 2:
                shopLogo.setImageResource(R.drawable.shufersal_icon);
                break;
            case 3:
                shopLogo.setImageResource(R.drawable.mega_icon);
                break;
            case 4:
                shopLogo.setImageResource(R.drawable.viktory_icon);
                break;
            case 5:
                shopLogo.setImageResource(R.drawable.yenot_bitan_logo);
                break;
        }
        unbinder = ButterKnife.bind(this, v);

        final Typeface myCustomFontSubMain = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-SemiBold.ttf");

        final ButterKnife.Action<View> SetTypeFont = new ButterKnife.Action<View>() {
            @Override
            public void apply(@NonNull View view, int index) {
                if (view instanceof Button) {
                    ((Button) view).setTypeface(myCustomFontSubMain);
                }
            }

        };

        ButterKnife.apply(nameViews, SetTypeFont);




        //breads.getBackground().setAlpha(0.5f);
        return v;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.breads, R.id.vegetables, R.id.meats, R.id.eggs, R.id.healthy, R.id.frozens, R.id.pickles, R.id.cereals, R.id.sweets,
            R.id.cosmetics, R.id.disposable, R.id.clothing, R.id.maintenance, R.id.drinks})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.breads:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(1, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.vegetables:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(2, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.meats:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(3, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.eggs:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(4, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.healthy:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(5, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.frozens:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(6, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.pickles:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(7, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.cereals:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(8, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.sweets:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(9, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.cosmetics:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(10, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.disposable:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(11, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.clothing:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(12, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.maintenance:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(13, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.drinks:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MenuFragment().newInstance(14, shopCode))
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }


}
