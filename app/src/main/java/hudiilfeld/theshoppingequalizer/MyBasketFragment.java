package hudiilfeld.theshoppingequalizer;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyBasketFragment extends Fragment {

    public static List<ProductItem> myBasketList = new ArrayList<>();


    RecyclerView rvMyBasket;
    static TextView tvTotalSum;
    double totalPrice;
    String displayPrice;
    TextView tvTitle;
    List<ProductItem> productsOfOtherShops;
    List<String> totalUnitPrices;
    Button btnCompare, btnCleanUp;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View mView = inflater.inflate(R.layout.fragment_my_basket, container, false);

        tvTitle = (TextView) mView.findViewById(R.id.tvTitle);


        rvMyBasket = (RecyclerView) mView.findViewById(R.id.rvMyBasket);
        tvTotalSum = (TextView) mView.findViewById(R.id.tvTotalSum);

        btnCompare = (Button) mView.findViewById(R.id.btnCompare);
        btnCleanUp = mView.findViewById(R.id.btnCleanUp);

        totalPrice = sumOfItems();

        totalUnitPrices =  new ArrayList<>();

        productsOfOtherShops = new ArrayList<>();



        if(myBasketList.size() > 0){

            final MyBasketAdapter mAdapter = new MyBasketAdapter(getActivity(), myBasketList);

            rvMyBasket.setAdapter(mAdapter);
            rvMyBasket.setLayoutManager(new LinearLayoutManager(getContext()));
            displayPrice = String.format("%.2f", totalPrice) + "₪";
            tvTotalSum.setText(displayPrice);
            btnCompare.setVisibility(View.VISIBLE);
            btnCleanUp.setVisibility(View.VISIBLE);

            btnCompare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame, new DisplayPricesFragment())
                            .addToBackStack(null)
                            .commit();
                }
            });

            btnCleanUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myBasketList.clear();
                    mAdapter.notifyDataSetChanged();
                    tvTotalSum.setText("0.00₪");
                }
            });


        } else{
            Toast.makeText(getContext(), "לא הוספת כלום לסל!!", Toast.LENGTH_LONG).show();
        }

        setTitleFont();
        setPriceFont();
        setBtnCleanUpFont();

        return mView;
    }


    static class MyBasketAdapter extends RecyclerView.Adapter<MyBasketAdapter.MyBasketViewHolder>{

        LayoutInflater inflater;
        List<ProductItem> selectedItems;
        FragmentActivity fragmentActivity;



        public MyBasketAdapter(FragmentActivity fragmentActivity, List<ProductItem> selectedItems) {
            this.fragmentActivity = fragmentActivity;
            this.inflater = LayoutInflater.from(fragmentActivity);
            this.selectedItems = selectedItems;
        }


        @Override
        public MyBasketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View mView = inflater.inflate(R.layout.pricing_item, parent, false);

            return new MyBasketViewHolder(mView);
        }

        @Override
        public void onBindViewHolder(MyBasketViewHolder holder, int position) {
            ProductItem item = myBasketList.get(position);
            holder.productName.setText(item.getProductName());
            holder.quantity.setText(item.getProductQuantity());
            double num = Double.valueOf(item.getproductPrice().replace("₪", "")
                    .replaceAll("\\s", ""));
            double totalProductPrice = num * item.getCount();
            String displayPrice = String.format("%.2f", totalProductPrice) + "₪";
            holder.tvPrice.setText(String.valueOf(displayPrice));
            holder.btnDisplayQuantity.setText(String.valueOf(item.getCount()));

            Picasso.with(fragmentActivity).load(item.getThumbUrl()).into(holder.imgProduct);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return myBasketList.size();
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        class MyBasketViewHolder extends RecyclerView.ViewHolder{

            TextView productName, quantity, tvPrice;
            Button btnDisplayQuantity, btnAdd, btnRemove;
            ImageView imgProduct;

            public MyBasketViewHolder(final View itemView) {
                super(itemView);
                productName = (TextView) itemView.findViewById(R.id.productName);
                quantity = (TextView) itemView.findViewById(R.id.manufacturer);
                tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
                imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);

                btnDisplayQuantity = (Button) itemView.findViewById(R.id.btnAddToBasket);
                btnAdd = itemView.findViewById(R.id.btnAdd);
                btnRemove = itemView.findViewById(R.id.btnRemove);

                Typeface myCustomFont = Typeface.createFromAsset(fragmentActivity.getAssets(), "fonts/Assistant-SemiBold.ttf");
                Typeface fontAwesomeIcon = Typeface.createFromAsset(fragmentActivity.getAssets(), "fontawesome-webfont.ttf");

                btnDisplayQuantity.setTypeface(fontAwesomeIcon);
                btnAdd.setTypeface(fontAwesomeIcon);
                btnRemove.setTypeface(fontAwesomeIcon);

                quantity.setTypeface(myCustomFont);
                productName.setTypeface(myCustomFont);
                tvPrice.setTypeface(myCustomFont);
                btnDisplayQuantity.setTypeface(myCustomFont);

            }

            public void bind(final ProductItem item){


                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int count = item.getCount();
                        count++;
                        sumOfItemUnits(item, tvPrice, tvTotalSum, btnAdd);
                        item.setCount(count);
                        btnDisplayQuantity.setText(String.valueOf(item.getCount()));
                    }
                });

                btnRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int count = item.getCount();
                        count--;

                        if (count > 0) {
                            sumOfItemUnits(item, tvPrice, tvTotalSum, btnRemove);
                            item.setCount(count);
                            btnDisplayQuantity.setText(String.valueOf(item.getCount()));
                        } else {
                            fragmentActivity.runOnUiThread(new Runnable() {
                                String displayPrice;
                                @Override
                                public void run() {
                                    item.clicked = true;
                                    myBasketList.remove(getAdapterPosition());
                                    double totalPrice;
                                    totalPrice = sumOfItems();
                                    displayPrice = String.format("%.2f", totalPrice) + "₪";
                                    tvTotalSum.setText(displayPrice);
                                    notifyItemRemoved(getAdapterPosition());
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    public static double sumOfItems(){
        double totalPrice = 0.0;
        for (int i = 0; i < myBasketList.size(); i++) {
            double num = Double.valueOf(myBasketList.get(i).getproductPrice().replace("₪", "")
                    .replaceAll("\\s", ""));
            double totalUnits = num * myBasketList.get(i).getCount();
            totalPrice += totalUnits;
        }
        return totalPrice;
    }

    public static double sumOfItemUnits(ProductItem item, TextView tv, TextView tvTotal, Button btn){
        double num = Double.valueOf(item.getproductPrice().replace("₪", "")
                .replaceAll("\\s", ""));
        double totalPrice;
        double updatedPriceNum;
        double sum = sumOfItems();

        if (btn.getId() == R.id.btnAdd) {
            updatedPriceNum = sum + num;
            totalPrice = num * (item.getCount() + 1);
        } else {
            updatedPriceNum = sum - num;
            totalPrice = num * (item.getCount() - 1);
        }

        String displayPrice = String.format("%.2f", totalPrice) + "₪";
        String updatedPrice = String.format("%.2f", updatedPriceNum) + "₪";
        tv.setText(displayPrice);
        tvTotal.setText(updatedPrice);
        return totalPrice;
    }

    private void setTitleFont(){
        Typeface myCustomFontMainTitle = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-Light.ttf");
        tvTitle.setTypeface(myCustomFontMainTitle);
    }

    public void setPriceFont(){
        Typeface myCustomFontPrice = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-SemiBold.ttf");
        tvTotalSum.setTypeface(myCustomFontPrice);
    }

    public void setBtnCleanUpFont() {
        Typeface fontAwesomeIcon = Typeface.createFromAsset(getActivity().getAssets(), "fontawesome-webfont.ttf");
        btnCleanUp.setTypeface(fontAwesomeIcon);
    }

}
