import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.servlet.annotation.MultipartConfig;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class CelebrityRequest {
    int age1;
    int age2;
    Gender gender;
    String ethinicity;
    Object img;

    @JsonCreator
    public CelebrityRequest(@JsonProperty("age1") int age1, @JsonProperty("age2") int age2,
                            @JsonProperty("gender") Gender gender, @JsonProperty("ethinicity") String ethinicity){
        this.age1 = age1;
        this.age2 = age2;
        this.gender = gender;
        this.ethinicity = ethinicity;
        System.out.println(age1);
        System.out.println(age2);
        System.out.println(gender);
        System.out.println(ethinicity);
        //System.out.println(img);
    }

   /* @JsonCreator
    public CelebrityRequest(@JsonProperty("age1") int age1, @JsonProperty("age2") int age2,
                @JsonProperty("gender") Gender gender, @JsonProperty("ethinicity") String ethinicity, @JsonProperty("image") Object []image){
        this.age1 = age1;
        this.age2 = age2;
        this.gender = gender;
        this.ethinicity = ethinicity;
        this.img = image[0];
        System.out.println(age1);
        System.out.println(age2);
        System.out.println(gender);
        System.out.println(ethinicity);
        System.out.println(img);
    }*/

}
