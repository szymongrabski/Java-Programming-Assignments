import java.util.ArrayList;

public class GradeList {
    private ArrayList<Double> gradeList = new ArrayList<>();

    public void addGrade(double grade) {
        gradeList.add(grade);
    }

    public boolean isEmpty() {
        return gradeList.isEmpty();
    }

    public double getAverageGrade() {
        double sum = 0;
        for (double grade : gradeList) {
            sum += grade;
        }
         return sum / gradeList.size();
    }

    public double getMaxGrade() {
        double maxGrade = gradeList.get(0);
        for (double grade : gradeList) {
            if (grade > maxGrade) {
                maxGrade = grade;
            }
        }
        return maxGrade;
    }

    public double getMinGrade() {
        double minGrade = gradeList.get(0);
        for (double grade : gradeList) {
            if (grade < minGrade) {
                minGrade = grade;
            }
        }
        return minGrade;
    }
}
