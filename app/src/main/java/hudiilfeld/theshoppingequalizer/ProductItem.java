package hudiilfeld.theshoppingequalizer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ibm on 16/07/2017.
 */

public class ProductItem {
    private String productName;
    private String productQuantity;
    private String productPrice;
    private String thumbUrl;
    private int id;
    private int shopCode;
    boolean clicked = false;
    private int count;

    public ProductItem(String productName, String productQuantity, String productPrice, String thumbUrl, int count, int id, int shopCode) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.thumbUrl = thumbUrl;
        this.count =  count;
        this.id = id;
        this.shopCode = shopCode;

    }

    public ProductItem(String productName, String productQuantity, String productPrice, String thumbUrl) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.thumbUrl = thumbUrl;
    }

    public ProductItem(String productPrice, int count) {
        this.productPrice = productPrice;
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public String getproductPrice() {
        return productPrice;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public int getId() {
        return id;
    }

    public int getShopCode() {
        return shopCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }





}
