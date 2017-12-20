package hudiilfeld.theshoppingequalizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ibm on 25/06/2017.
 */

public class IO {

    public static String getWebsitedata(String address) throws Exception {
            String content = "NO CONTENT. Sorry!!";
            URL url = new URL(address);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            //GZIPInputStream gzip = new GZIPInputStream(inputStream);
            content = getString(inputStream);
            return content;
    }

    public static String getString(InputStream in) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } finally {
            reader.close();
        }
        return builder.toString();
    }

    //System.out.println(content);
}
