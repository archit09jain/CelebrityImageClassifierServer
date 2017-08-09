import java.util.List;

/**
 * Created by mohit.sh on 08/08/17.
 */
public class Predictions {
    int age;
    Gender gender;
    String ethinicity;
    List<Celebrity> celebrities;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public List<Celebrity> getCelebrities() {
        return celebrities;
    }

    public void setCelebrities(List<Celebrity> celebrities) {
        this.celebrities = celebrities;
    }
}
