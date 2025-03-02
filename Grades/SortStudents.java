import java.util.*;

public class SortStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); 

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split(" ");
            String name = tokens[0];
            String grade = tokens[1];
            students.add(new Student(name, grade));
        }
        sc.close();

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int gradeCmp = compareGrades(s2.getGrade(), s1.getGrade()); // reverse order
                if (gradeCmp != 0) {
                    return gradeCmp;
                }
                else {
                    return s1.getName().compareTo(s2.getName()); // alphabetical order
                }
            }
        });

        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public static int compareGrades(String g1, String g2) {
        int g1Value = getGradeValue(g1);
        int g2Value = getGradeValue(g2);

        if (g1Value < g2Value) {
            return -1;
        }
        else if (g1Value > g2Value) {
            return 1;
        }
        else {
            int g1Mod = getGradeModifier(g1);
            int g2Mod = getGradeModifier(g2);
            if (g1Mod < g2Mod) {
                return -1;
            }
            else if (g1Mod > g2Mod) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static int getGradeValue(String grade) {
        if (grade.contains("FX")) {
            return 2;
        }
        switch (grade.charAt(0)) {
            case 'A':
                return 7;
            case 'B':
                return 6;
            case 'C':
                return 5;
            case 'D':
                return 4;
            case 'E':
                return 3;
            case 'F':
                return 1;
            default:
                return 0;
        }
    }

    public static int getGradeModifier(String grade) {
        int mod = 0;
        for (int i = 1; i < grade.length(); i++) {
            if (grade.charAt(i) == '+') {
                mod++;
            }
            else if (grade.charAt(i) == '-') {
                mod--;
            }
        }
        return mod;
    }
}

