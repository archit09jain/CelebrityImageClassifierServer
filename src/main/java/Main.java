import spark.Request;

import javax.imageio.ImageIO;
import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;
import static spark.Spark.get;
import static spark.Spark.post;


public class Main {

    public static void main(String[] args) {
        get("/ping", (req, res) -> {
            res.type("application/json");
            return "{\"message\" :\"pong\"}";
        });

        post("/predictions", "multipart/form-data", (request, response) -> {
            response.type("application/json");
            setMultiPartConfig(request);
            String resp = "{\"message\":\"done\"}";
            CelebrityRequest cq = Utils.loadCelebrityRequest(request);

            if (cq == null) {
                response.status(400);
                resp = "{\"message\":\"Bad request\"}";
            } else {
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

    public static void display(CelebrityRequest cq){
        System.out.println(cq.getAge1());
        System.out.println(cq.getAge2());
        System.out.println(cq.getEthinicity());
        System.out.println(cq.getGender());
        try {
            ImageIO.write(cq.getImg(), "jpg", new File("/Users/mohit.sh/Desktop/sk1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
