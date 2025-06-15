import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        if (numberOfSubjects <= 0) {
            System.out.println("Invalid number of subjects.");
            return;
        }

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (0 to 100): ");
            int input = scanner.nextInt();

            if (input < 0 || input > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; // Retry this subject
                continue;
            }

            marks[i] = input;
            totalMarks += input;
        }

        double average = (double) totalMarks / numberOfSubjects;

        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
