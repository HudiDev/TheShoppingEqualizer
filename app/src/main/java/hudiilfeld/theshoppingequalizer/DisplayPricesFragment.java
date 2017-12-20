package hudiilfeld.theshoppingequalizer;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import hudiilfeld.theshoppingequalizer.sources.CategoryItemsDataSource;
import hudiilfeld.theshoppingequalizer.sources.MegaUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.RamiLeviUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.ShuferSalUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.SubCategoryNameAndInfo;
import hudiilfeld.theshoppingequalizer.sources.ViktoryUrlDataSource;
import hudiilfeld.theshoppingequalizer.sources.YenotBitanUrlDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayPricesFragment extends Fragment implements View.OnClickListener {

    static List<ProductItem> myBasketList = new ArrayList<>();

    public static AtomicInteger atomicInteger = new AtomicInteger();

    RecyclerView rvMissingItems;

    static List<ProductItem> ramiLeviPrices, shuferSalPrices,
            megaPrices, viktoryPrices, yenotBitanPrices;

    List<String> missingRamiLeviProducts, missingShuferSalProducts,
                missingMegaProducts, missingViktoryProducts, missingYenotBitanProducts;

    TextView tvRamiLevi, tvShuferSal, tvMega, tvViktory, tvYenotbitan, tvMain;

    List<ArrayList> allShopsData;
    private int id;

    Button warningRamiLevi, warningShuferSal,
            warningMega, warningViktory, warningYenotBitan;

    static int check = 0;

    int maxTaskIterations;

    ProgressBar progressBar;


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_display_prices, container, false);



        progressBar = v.findViewById(R.id.pricesProgressBar);

        warningRamiLevi = (Button) v.findViewById(R.id.warningRamiLevi);
        warningShuferSal = (Button) v.findViewById(R.id.warningShuferSal);
        warningMega = (Button) v.findViewById(R.id.warningMega);
        warningViktory = (Button) v.findViewById(R.id.warningViktory);
        warningYenotBitan = (Button) v.findViewById(R.id.warningYenotBitan);

        tvRamiLevi = (TextView) v.findViewById(R.id.tvRamiLevi);
        tvShuferSal = (TextView) v.findViewById(R.id.tvShuferSal);
        tvMega = (TextView) v.findViewById(R.id.tvMega);
        tvViktory = (TextView) v.findViewById(R.id.tvViktory);
        tvYenotbitan = (TextView) v.findViewById(R.id.tvYenotBitan);


        warningRamiLevi.setOnClickListener(this);
        warningShuferSal.setOnClickListener(this);
        warningMega.setOnClickListener(this);
        warningViktory.setOnClickListener(this);
        warningYenotBitan.setOnClickListener(this);

        tvMain = (TextView) v.findViewById(R.id.tvMain);

        Typeface myCustomFontMainTitle = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-Light.ttf");
        tvMain.setTypeface(myCustomFontMainTitle);

        setButtonFonts();
        setWarningButtonFonts();
        setWarningsVisibility();

        ramiLeviPrices = new ArrayList<>();
        shuferSalPrices = new ArrayList<>();
        megaPrices = new ArrayList<>();
        viktoryPrices = new ArrayList<>();
        yenotBitanPrices = new ArrayList<>();


        missingRamiLeviProducts = new ArrayList<>();
        missingShuferSalProducts = new ArrayList<>();
        missingMegaProducts = new ArrayList<>();
        missingViktoryProducts = new ArrayList<>();
        missingYenotBitanProducts = new ArrayList<>();


        myBasketList = MyBasketFragment.myBasketList;

        if (myBasketList.size() > 0) {
            doStuff();
        } else {
            Toast.makeText(getContext(), "לא הוספת כלום לסל!!", Toast.LENGTH_LONG).show();
        }

        return v;
    }

    public void doStuff() {
        allShopsData = new ArrayList<>();

        setShopData();

        maxTaskIterations = myBasketList.size() * allShopsData.size();
        atomicInteger.set(maxTaskIterations);

        for (int i = 0; i < myBasketList.size(); i++) {

        final int index = i;

        id = myBasketList.get(i).getId();


        int shopNumber = 0;

        for (ArrayList<SubCategoryNameAndInfo> shop : allShopsData) {

                shopNumber++;

                final int shopNum = shopNumber;

                SubCategoryNameAndInfo subCategory = shop.get(id);

                String[] url = subCategory.getUrl();

                CategoryItemsDataSource.getCategoryItemsData(url, new CategoryItemsDataSource.OnCategoryItemsDataArrived() {
                    @Override
                    public void onCategoryItemsDataArrived(List<ProductItem> data, Exception e) {

                        if (e == null) {

                            check++;

                            final String basketProductsName = myBasketList.get(index).getProductName();
                            final int count = myBasketList.get(index).getCount();

                            int counter = 0;


                            outerloop:
                            for (ProductItem item : data) {

                                    counter++;

                                    switch (shopNum) {
                                        case 1:
                                            if (item.getProductName().equals(basketProductsName)) {
                                                ramiLeviPrices.add(new ProductItem(item.getproductPrice(), count));
                                                break outerloop;
                                            } else {
                                                isContaining(missingRamiLeviProducts, basketProductsName, counter, data.size());
                                            }

                                            break;
                                        case 2:
                                            if (item.getProductName().equals(basketProductsName)) {
                                                shuferSalPrices.add(new ProductItem(item.getproductPrice(), count));
                                                break outerloop;
                                            } else {
                                                isContaining(missingShuferSalProducts, basketProductsName, counter, data.size());
                                            }
                                            break;
                                        case 3:
                                            if (item.getProductName().equals(basketProductsName)) {
                                                megaPrices.add(new ProductItem(item.getproductPrice(), count));
                                                break outerloop;
                                            } else {
                                                isContaining(missingMegaProducts, basketProductsName, counter, data.size());
                                            }
                                            break;
                                        case 4:
                                            if (item.getProductName().equals(basketProductsName)) {
                                                viktoryPrices.add(new ProductItem(item.getproductPrice(), count));
                                                break outerloop;
                                            } else {
                                                isContaining(missingViktoryProducts, basketProductsName, counter, data.size());
                                            }
                                            break;
                                        case 5:
                                            if (item.getProductName().equals(basketProductsName)) {
                                                yenotBitanPrices.add(new ProductItem(item.getproductPrice(), count));
                                                break outerloop;
                                            } else {
                                                isContaining(missingYenotBitanProducts, basketProductsName, counter, data.size());
                                            }
                                            break;
                                    }

                            }

                            if(atomicInteger.get() == 0) {
                                getActivity().runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {

                                        progressBar.setVisibility(View.INVISIBLE);

                                        Log.d("myBasketSize", String.valueOf(myBasketList.size()));

                                        for (int j = 0; j < allShopsData.size(); j++) {
                                            switch (j) {
                                            case 0:
                                                displayPrices(ramiLeviPrices, tvRamiLevi, warningRamiLevi, missingRamiLeviProducts, "״רמי לוי״");
                                                break;
                                            case 1:
                                                displayPrices(shuferSalPrices, tvShuferSal, warningShuferSal, missingShuferSalProducts, "שופרסל״");
                                                break;
                                            case 2:
                                                displayPrices(megaPrices, tvMega, warningMega, missingMegaProducts, "״מגה״");
                                                break;
                                            case 3:
                                                displayPrices(viktoryPrices, tvViktory, warningViktory, missingViktoryProducts, "״ויקטורי״");
                                                break;
                                            case 4:
                                                displayPrices(yenotBitanPrices, tvYenotbitan, warningYenotBitan, missingYenotBitanProducts, "״יינות ביתן״");
                                                break;
                                                }
                                        }
                                        setTextViewFonts();
                                    }

                                });
                            }
                        }
                    }
                });
            }
        }
    }

    private void isMissingItems(List<ProductItem> shopPrices, Button warningBtn) {
        if(shopPrices.size() < myBasketList.size()) {
            warningBtn.setVisibility(View.VISIBLE);

        }
    }

    private void isContaining (List<String> missingShopItems, String productName, int count, int max) {
        if(count == max){
            missingShopItems.add(productName);
        }
    }

    private void displayPrices (List<ProductItem> shopPrices, TextView tvShop, Button btn, List<String> shopMissingProducts, String shopName) {
        double totalShop = sumOfItems(shopPrices);
        String displayPrice = String.format("%.2f", totalShop) + "₪";
        String shopDisplay = "מחיר הסל שלך ב" + shopName + " הינו:" + displayPrice;
        tvShop.setText(shopDisplay);
        isMissingItems(shopPrices, btn);
    }

    private void setShopData(){
        allShopsData.add(RamiLeviUrlDataSource.getTitles());
        allShopsData.add(ShuferSalUrlDataSource.getTitles());
        allShopsData.add(MegaUrlDataSource.getTitles());
        allShopsData.add(ViktoryUrlDataSource.getTitles());
        allShopsData.add(YenotBitanUrlDataSource.getTitles());
    }

    public double sumOfItems(List<ProductItem> shopPrices){
        double totalPrice = 0.0;
        for (int i = 0; i < shopPrices.size(); i++) {
            double num = Double.valueOf(shopPrices.get(i).getproductPrice().replace("₪", "").replace("*", "")
                    .replaceAll("\\s", ""));
            double sum = num * shopPrices.get(i).getCount();
            totalPrice += sum;
        }
        return totalPrice;
    }


    private void setButtonFonts() {
        Typeface fontAwesomePhoneIcon = Typeface.createFromAsset(getActivity().getAssets(), "fontawesome-webfont.ttf");

        warningRamiLevi.setTypeface(fontAwesomePhoneIcon);
        warningShuferSal.setTypeface(fontAwesomePhoneIcon);
        warningMega.setTypeface(fontAwesomePhoneIcon);
        warningViktory.setTypeface(fontAwesomePhoneIcon);
        warningYenotBitan.setTypeface(fontAwesomePhoneIcon);
    }

    private void setTextViewFonts() {
        Typeface myCustomFontMainTitle = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-Light.ttf");
        tvMain.setTypeface(myCustomFontMainTitle);
        tvRamiLevi.setTypeface(myCustomFontMainTitle);
        tvShuferSal.setTypeface(myCustomFontMainTitle);
        tvMega.setTypeface(myCustomFontMainTitle);
        tvViktory.setTypeface(myCustomFontMainTitle);
        tvYenotbitan.setTypeface(myCustomFontMainTitle);
    }

    private void setWarningButtonFonts() {
        Typeface fontAwesomeWarningIcon = Typeface.createFromAsset(getActivity().getAssets(), "fontawesome-webfont.ttf");
        warningRamiLevi.setTypeface(fontAwesomeWarningIcon);
        warningShuferSal.setTypeface(fontAwesomeWarningIcon);
        warningMega.setTypeface(fontAwesomeWarningIcon);
        warningViktory.setTypeface(fontAwesomeWarningIcon);
        warningYenotBitan.setTypeface(fontAwesomeWarningIcon);
    }

    private  void setWarningsVisibility () {
        warningRamiLevi.setVisibility(View.INVISIBLE);
        warningShuferSal.setVisibility(View.INVISIBLE);
        warningMega.setVisibility(View.INVISIBLE);
        warningViktory.setVisibility(View.INVISIBLE);
        warningYenotBitan.setVisibility(View.INVISIBLE);
    }

    public void alertDialogItems (List<String> data) {

        Button btnDismiss;
        TextView tvTitle;

        AlertDialog.Builder showMissingItems = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.dialog_missing_items, null);

        rvMissingItems = mView.findViewById(R.id.rvMissingItems);
        btnDismiss  = mView.findViewById(R.id.btnDismiss);
        tvTitle = mView.findViewById(R.id.tvTitle);

        Typeface myCustomFontMainTitle = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-Light.ttf");
        tvTitle.setTypeface(myCustomFontMainTitle);

        rvMissingItems.setAdapter(new MissingItemsRecyclerAdapter(data, getActivity()));
        rvMissingItems.setLayoutManager(new LinearLayoutManager(getActivity()));

        showMissingItems.setView(mView);
        final AlertDialog dialog = showMissingItems.create();
        dialog.show();

        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.warningRamiLevi:
                alertDialogItems(missingRamiLeviProducts);
                break;

            case R.id.warningShuferSal:
                alertDialogItems(missingShuferSalProducts);
                break;

            case R.id.warningMega:
                alertDialogItems(missingMegaProducts);
                break;

            case R.id.warningViktory:
                alertDialogItems(missingViktoryProducts);
                break;

            case R.id.warningYenotBitan:
                alertDialogItems(missingYenotBitanProducts);
                break;
        }
    }

    static class MissingItemsRecyclerAdapter extends RecyclerView.Adapter<MissingItemsRecyclerAdapter.ItemViewHolder> {

        List<String> data;
        FragmentActivity context;
        LayoutInflater inflater;

        public MissingItemsRecyclerAdapter(List<String> data, FragmentActivity context) {
            this.data = data;
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.missing_item, parent, false);
            return new ItemViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ItemViewHolder holder, int position) {
            String missingItemName = data.get(position);

            holder.textView.setText(missingItemName);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }




        class ItemViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            public ItemViewHolder(View itemView) {
                super(itemView);
                textView =  itemView.findViewById(R.id.tvMissingName);

                Typeface myCustomFontMainTitle = Typeface.createFromAsset(context.getAssets(), "fonts/Assistant-Light.ttf");
                textView.setTypeface(myCustomFontMainTitle);
            }
        }
    }
}
