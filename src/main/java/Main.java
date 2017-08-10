import spark.Request;
import javax.servlet.MultipartConfigElement;
import static spark.Spark.get;
import static spark.Spark.post;


public class Main {

    static CorsFilter corsFilter = new CorsFilter();

    public static void main(String[] args) {

        corsFilter.apply();
        get("/ping", (req, res) -> {
            res.type("application/json");
            return "{\"message\" :\"pong\"}";
        });

        post("/predictions", "multipart/form-data", (request, response) -> {
            response.type("application/json");
            setMultiPartConfig(request);
            //System.out.println(request.body());
            //System.out.println(request.body());
            UserRequest cq = ParseRequestUtil.loadCelebrityRequest(request);

            if (cq == null) {
                response.status(400);
                return "{\"message\":\"Bad request\"}";
            }
            return PredictUtil.getPredictions(cq);
        });
    }

    public static void setMultiPartConfig(Request request){
        String location = "/Users/mohit.sh/temp";          // the directory location where files will be stored
        long maxFileSize = 100000000;                      // the maximum size allowed for uploaded files
        long maxRequestSize = 100000000;                   // the maximum size allowed for multipart/form-data requests
        int fileSizeThreshold = 1024;                      // the size threshold after which files will be written to disk
        request.raw().setAttribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement(
                                                                                location, maxFileSize, maxRequestSize, fileSizeThreshold));
    }
}
