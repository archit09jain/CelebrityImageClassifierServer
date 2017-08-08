import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class Utils {

    public static CelebrityRequest loadCelebrityRequest(String reqBody){
        ObjectMapper mapper = new ObjectMapper();
        CelebrityRequest cq = null;
        try {
            cq = mapper.readValue(reqBody, CelebrityRequest.class);
        } catch (IOException e) {
            System.out.println("Something is wrong with the request!!!");
            e.printStackTrace();
        }
        return cq;
    }
}
