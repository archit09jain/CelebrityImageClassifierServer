import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.servlet.annotation.MultipartConfig;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class UserRequest {
    int age1;
    int age2;
    Gender gender;
    String ethinicity;
    BufferedImage img;

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }

    public int getAge2() {
        return age2;
    }

    public void setAge2(int age2) {
        this.age2 = age2;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEthinicity() {
        return ethinicity;
    }

    public void setEthinicity(String ethinicity) {
        this.ethinicity = ethinicity;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
}
