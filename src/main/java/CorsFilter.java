import spark.Request;

import java.util.HashMap;
import spark.Filter;
import spark.Response;
import spark.Spark;
/**
 * Created by mohit.sh on 10/08/17.
 */
public class CorsFilter {

    private final HashMap<String, String> corsHeaders = new HashMap<>();

    public CorsFilter() {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "http://172.16.44.253");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }

    public void apply() {
        Filter filter = new Filter() {
            @Override
            public void handle(Request request, Response response) throws Exception {
                corsHeaders.forEach((key, value) -> {
                    response.header(key, value);
                });
            }
        };
        Spark.after(filter);
    }
}
