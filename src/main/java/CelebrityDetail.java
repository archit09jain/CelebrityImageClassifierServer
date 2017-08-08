/**
 * Created by mohit.sh on 08/08/17.
 */
public class CelebrityDetail {
    int age;
    String ethinicity;
    Gender gender;
    int ID;

    public CelebrityDetail(int age, String ethinicity, Gender gender, int ID) {
        this.age = age;
        this.ethinicity = ethinicity;
        this.gender = gender;
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
