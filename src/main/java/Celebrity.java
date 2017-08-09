/**
 * Created by mohit.sh on 08/08/17.
 */
public class Celebrity {
    int age;
    int id;
    int probability;
    String name;
    String ethinicity;
    Gender gender;
    String imgB64;


    public Celebrity(int id, int age, int probability, String name, String ethinicity, Gender gender, String imgB64) {
        this.age = age;
        this.id = id;
        this.ethinicity = ethinicity;
        this.gender = gender;
        this.imgB64 = imgB64;
        this.probability = probability;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEthinicity() {
        return ethinicity;
    }

    public void setEthinicity(String ethinicity) {
        this.ethinicity = ethinicity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImgB64() {
        return imgB64;
    }

    public void setImgB64(String imgB64) {
        this.imgB64 = imgB64;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }
}
