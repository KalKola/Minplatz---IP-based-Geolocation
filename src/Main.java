import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {

        System.out.println(getLocation(""));
    }

    public static String getLocation(String ip) {

        String ipData = "";
        if (!ip.equals("")) {
            ip = "/" + ip;
        }
        try {
            // concatenate ip (or nothing if blank) to IP info API address
            String link = "https://ipinfo.io" + ip + "/json";
            URL url = new URL(link);

            // open URL connection to API
            URLConnection conn = url.openConnection();

            // create a Buffered Reader to read in the JSON object
            BufferedReader br = new BufferedReader(
                    new BufferedReader(new InputStreamReader(conn.getInputStream())));

            // read in the result of the API call and save to string
            String line;
            while((line = br.readLine()) != null) {
                ipData = ipData + line;
            }
            br.close();

        // handle exceptions
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Malformed URL Exception";
        } catch (IOException e) {
            e.printStackTrace();
            return "IOException";
        }
    return ipData;
    }
}
