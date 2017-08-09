import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class PredictCelebrity {
    public static List <Celebrity> getpredictedCelebrities(BufferedImage img){
        List<Integer> l1 = new ArrayList<>();
        for(int i= 0; i<10; i++) {
            l1.add(i);
        }
        return DataFetch.getCelebrityData(l1, l1);
    }
}
