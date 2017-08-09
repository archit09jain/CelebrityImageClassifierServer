import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class PredictUtil {

    public static void filterCelebrities(Predictions ps, UserRequest cq){
        List<Celebrity> tempCl = new ArrayList<>();
        tempCl.addAll(ps.getCelebrities());
        for(Celebrity p : tempCl){
            if(p.getAge() < cq.getAge1()
                    || p.getAge() > cq.getAge2()
                    || !(cq.getGender().equals(Gender.ALL) || p.getGender().equals(cq.getGender()))
                    || !(cq.getEthinicity().equals("ANY") || p.getEthinicity().equals(cq.getEthinicity())))
            {
                ps.getCelebrities().remove(p);
            }

        }
    }

    public static Predictions getPredictionsObject(UserRequest cq){
        Predictions predictions = new Predictions();
        predictions.setAge(PredictAge.getPredictedAge(cq.img));
        predictions.setGender(PredictGender.getPredictedGender(cq.img));
        predictions.setEthinicity(PredictEthinicity.getEthinicity(cq.img));
        predictions.setCelebrities(PredictCelebrity.getpredictedCelebrities(cq.img));
        filterCelebrities(predictions, cq);
        System.out.println(predictions.getCelebrities().size());
        return predictions;
    }

    public static String getPredictions(UserRequest cq){
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(getPredictionsObject(cq));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
