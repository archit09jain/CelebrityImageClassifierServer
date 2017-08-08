import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class PredictCelebrity {
    public static List <CelebrityDetail> getpredictedCelebrities(BufferedImage img){
        List<CelebrityDetail> l = new ArrayList<>();
        for(int i= 0; i<10; i++) {
            l.add(new CelebrityDetail(20, "Asian", Gender.MALE, i));
        }
        return l;
    }
}
