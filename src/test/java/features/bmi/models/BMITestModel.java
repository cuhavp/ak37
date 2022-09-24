package features.bmi.models;

public class BMITestModel {

    String age;
    String gender;
    String height;
    String weight;
    String expectedResult;

    public BMITestModel(String age, String gender, String height, String weight, String expectedResult) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.expectedResult = expectedResult;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }
}
