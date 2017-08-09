import spark.Request;
import spark.utils.IOUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class ParseRequestUtil {

    public static String getStringForPart(Request req, String partName){
        InputStream ip = null;
        StringWriter writer = new StringWriter();
        try {
            ip = req.raw().getPart(partName).getInputStream();
            IOUtils.copy(ip, writer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static UserRequest loadCelebrityRequest(Request req){
        UserRequest cq = new UserRequest();
        cq.setAge1(Integer.parseInt(getStringForPart(req, "age1")));
        cq.setAge2(Integer.parseInt(getStringForPart(req, "age2")));
        cq.setEthinicity(getStringForPart(req, "ethinicity"));
        cq.setGender(Gender.valueOf(getStringForPart(req, "gender")));
        try {
            cq.setImg(ImageIO.read(req.raw().getPart("image").getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return cq;
    }
}
