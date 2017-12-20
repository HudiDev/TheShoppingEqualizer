package hudiilfeld.theshoppingequalizer;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import hudiilfeld.theshoppingequalizer.sources.CategoryItemsDataSource;
import com.squareup.picasso.Picasso;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment implements CategoryItemsDataSource.OnCategoryItemsDataArrived{

    RecyclerView rvContent;
    ProgressBar progressBar;
    private static final String SPECIFIC_URL = "PARAM_DATA";
    private static final String ID = "PARAM_ID";
    private static final String SHOP_CODE = "PARAM_CODE";
    private int id;
    private int shopCode;

    static AtomicInteger atomic = new AtomicInteger();


    public static ItemsFragment newInstance(String[] url, int id, int shopCode){

        Bundle args = new Bundle();
        args.putStringArray(SPECIFIC_URL, url);
        args.putInt(ID, id);
        args.putInt(SHOP_CODE, shopCode);
        ItemsFragment fragment = new ItemsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_items, container, false);

        String[] url = getArguments().getStringArray(SPECIFIC_URL);
        id = getArguments().getInt(ID);
        shopCode = getArguments().getInt(SHOP_CODE);
        CategoryItemsDataSource.getCategoryItemsData(url, this);

        rvContent = (RecyclerView) v.findViewById(R.id.rvContent);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);



        AlertDialog.Builder addToBasketDialog = new AlertDialog.Builder(getContext());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.dialog_error, null);
        addToBasketDialog.setView(mView);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fabBasket);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new MyBasketFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
        return v;
    }





    @Override
    public void onCategoryItemsDataArrived(final List<ProductItem> data, final Exception e) {
        final Typeface myCustomFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Assistant-Regular.ttf");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(e == null){

                    progressBar.setVisibility(View.INVISIBLE);
                    rvContent.setAdapter(new ItemsRecyclerAdapter(data, getActivity(), id, shopCode));
                    rvContent.setLayoutManager(new LinearLayoutManager(getActivity()));



                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    View mView = getActivity().getLayoutInflater().inflate(R.layout.dialog_error, null);
                    TextView tvErrorMessage = (TextView) mView.findViewById(R.id.tvErrorMessage);
                    tvErrorMessage.setTypeface(myCustomFont);
                    final Button goBack = (Button) mView.findViewById(R.id.goBack);
                    builder.setView(mView);

                    final AlertDialog dialog = builder.create();
                    dialog.show();
                    goBack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.hide();
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.frame, new HeadCategories())
                                    .commit();
                        }
                    });
                }
            }
        });
    }


    static class ItemsRecyclerAdapter extends RecyclerView.Adapter<ItemsRecyclerAdapter.ItemsViewHolder>{

        FragmentActivity fragmentActivity;
        List<ProductItem> data;
        LayoutInflater inflater;
        private int id;
        private int shopCode;

        public ItemsRecyclerAdapter(List<ProductItem> data, FragmentActivity fragmentActivity, int id, int shopCode) {
            this.fragmentActivity = fragmentActivity;
            this.data = data;
            this.inflater = LayoutInflater.from(fragmentActivity);
            this.id = id;
            this.shopCode = shopCode;
        }

        @Override
        public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = inflater.inflate(R.layout.pricing_item, parent, false);

            return new ItemsViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ItemsViewHolder holder, final int position) {
            ProductItem itemPrice = data.get(position);
            holder.productName.setText(itemPrice.getProductName());
            holder.quantity.setText(itemPrice.getProductQuantity());
            holder.tvPrice.setText(itemPrice.getproductPrice());
            Picasso.with(fragmentActivity).load(itemPrice.getThumbUrl()).into(holder.imgProduct);

            holder.bind(itemPrice);

            if(itemPrice.clicked){
                holder.btnAddToBasket.setOnClickListener(null);

                holder.btnAddToBasket.setText(String.valueOf(itemPrice.getCount()));
                holder.btnAdd.setVisibility(View.VISIBLE);
                holder.btnRemove.setVisibility(View.VISIBLE);

            } else {
                holder.btnAddToBasket.setText("\uf291");
                holder.btnAdd.setVisibility(View.INVISIBLE);
                holder.btnRemove.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ItemsViewHolder extends RecyclerView.ViewHolder {

            TextView productName, quantity, tvPrice;
            ImageView imgProduct;
            Button btnAddToBasket, btnAdd, btnRemove;

            Typeface myCustomFont = Typeface.createFromAsset(fragmentActivity.getAssets(), "fonts/Assistant-SemiBold.ttf");

            public ItemsViewHolder(View itemView) {
                super(itemView);
                productName = (TextView) itemView.findViewById(R.id.productName);
                quantity = (TextView) itemView.findViewById(R.id.manufacturer);
                tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
                imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
                btnAddToBasket = (Button) itemView.findViewById(R.id.btnAddToBasket);
                btnAdd = itemView.findViewById(R.id.btnAdd);
                btnRemove = itemView.findViewById(R.id.btnRemove);

                btnAdd.setVisibility(View.INVISIBLE);
                btnRemove.setVisibility(View.INVISIBLE);

                quantity.setTypeface(myCustomFont);
                productName.setTypeface(myCustomFont);
                tvPrice.setTypeface(myCustomFont);

                Typeface fontAwesomeBasketIcon = Typeface.createFromAsset(fragmentActivity.getAssets(), "fontawesome-webfont.ttf");
                btnAddToBasket.setTypeface(fontAwesomeBasketIcon);
                btnAdd.setTypeface(fontAwesomeBasketIcon);
                btnRemove.setTypeface(fontAwesomeBasketIcon);


            }

            public void bind(final ProductItem item) {

                btnAddToBasket.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        removeContaining(item);

                        item.clicked = true;
                        int count = item.getCount();
                        count++;
                        item.setCount(count);

                        Toast.makeText(fragmentActivity, "נוסף מוצר לסל האישי", Toast.LENGTH_SHORT).show();

                        notifyDataSetChanged();

                        MyBasketFragment.myBasketList
                                .add(new ProductItem(item.getProductName(), item.getProductQuantity(),
                                        item.getproductPrice(), item.getThumbUrl(), item.getCount(), id, shopCode)
                                );
                    }
                });

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        removeContaining(item);

                        int count = item.getCount();
                        count++;
                        item.setCount(count);
                        btnAddToBasket.setText(String.valueOf(item.getCount()));

                        MyBasketFragment.myBasketList
                                .add(new ProductItem(item.getProductName(), item.getProductQuantity(),
                                        item.getproductPrice(), item.getThumbUrl(), item.getCount(), id, shopCode)
                                );
                    }
                });

                btnRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        removeContaining(item);

                        int count = item.getCount();
                        count--;
                        item.setCount(count);
                        if (item.getCount() > 0) {
                            btnAddToBasket.setText(String.valueOf(item.getCount()));

                            MyBasketFragment.myBasketList
                                    .add(new ProductItem(item.getProductName(), item.getProductQuantity(),
                                            item.getproductPrice(), item.getThumbUrl(), item.getCount(), id, shopCode)
                                    );
                        } else {
                            btnAddToBasket.setText("\uf291");
                            item.setCount(0);
                        }
                    }
                });
            }

            private void removeContaining (ProductItem item) {
                for (Iterator<ProductItem> iterator = MyBasketFragment.myBasketList.iterator();  iterator.hasNext();) {
                    String name = iterator.next().getProductName();
                    if (name.equals(item.getProductName())) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}


