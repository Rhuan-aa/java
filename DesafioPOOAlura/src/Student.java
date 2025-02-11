public class Student {
    private String name;
    private float grades;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGrades() {
        return grades;
    }

    public void setGrades(float grades) {
        this.grades = grades;
    }

    public float calculateAvarage(float numOfTests){
        float avarage = this.grades/numOfTests;
        return avarage;
    }
}
