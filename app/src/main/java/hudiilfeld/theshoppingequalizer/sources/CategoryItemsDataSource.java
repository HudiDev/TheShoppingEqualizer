package hudiilfeld.theshoppingequalizer.sources;

import hudiilfeld.theshoppingequalizer.DisplayPricesFragment;
import hudiilfeld.theshoppingequalizer.IO;
import hudiilfeld.theshoppingequalizer.ProductItem;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by ibm on 25/06/2017.
 */

public class CategoryItemsDataSource {

    public interface OnCategoryItemsDataArrived {
        void onCategoryItemsDataArrived(List<ProductItem> data, Exception e);
    }

    public static void getCategoryItemsData(final String[] url, final OnCategoryItemsDataArrived listener){

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<ProductItem> data = new ArrayList<>();
                    for (int i = 0; i<url.length; i++){
                        String currentUrl = url[i];
                        String xml = IO.getWebsitedata(currentUrl);
                        data.addAll(parse(xml));
                    }
                    DisplayPricesFragment.atomicInteger.decrementAndGet();
                    listener.onCategoryItemsDataArrived(data, null);
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.onCategoryItemsDataArrived(null, e);
                }
            }
        });
        service.shutdown();
    }

    public static List<ProductItem> parse(String xml) {
        String productName;
        String productQuantity;
        String productPrice;
        String thumbUrl;

        List<ProductItem> data = new ArrayList<>();

        Document document = Jsoup.parse(xml);
        Elements elements = document.getElementsByClass("NgMspProductCell");
        for (Element e : elements) {
            Element productImg = e.getElementsByClass("ImageWrp").first();
            thumbUrl = productImg.getElementsByTag("img").attr("src");
            Element productDetails = e.getElementsByClass("DetailsWrp").first();
            Element ahref = productDetails.getElementById("ProductPageUrl");
            productName = ahref.getElementsByClass("Prefix").first().text();
            productQuantity = ahref.getElementsByClass("Suffix").first().text();
            productPrice = productDetails.getElementsByClass("Price").text();
            data.add(new ProductItem(productName, productQuantity, productPrice, thumbUrl));
        }
        return data;
    }
}
