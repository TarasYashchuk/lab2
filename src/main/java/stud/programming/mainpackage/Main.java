package stud.programming.mainpackage;

import stud.programming.abiturientpackage.Abiturient;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Abiturient> abiturients = createAbiturients();

        Scanner scanner = new Scanner(System.in);

        menu(scanner, abiturients);
    }
    private static void menu(Scanner scanner, ArrayList<Abiturient> abiturients) {
        System.out.println("Яка інформація вам потрібна?");
        System.out.println("Абітурієнти із певним іменем - 1");
        System.out.println("Абітурієнти, бал яких більший за певний - 2");
        System.out.println("Топ абітурієнтів із найвищим балом - 3");
        System.out.print("Ваш вибір: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Введіть ім'я: ");
                String name = scanner.nextLine();
                System.out.println("Абітурієнти із іменем " + name);
                printStudentsByName(name, abiturients);
                System.out.println();
            }
            case 2 -> {
                System.out.print("Введіть бал: ");
                double mark = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Абітурієнти, бал яких більший за " + mark);
                printStudentsByMark(mark, abiturients);
                System.out.println();
            }
            case 3 -> {
                System.out.print("Введіть кількість абітурієнтів:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Топ " + quantity + " абітурієнтів із найвищим балом:");
                printTopNStudentsByMark(quantity, abiturients);
            }
            default -> System.out.println("Такого пункту немає");
        }
    }
    public static ArrayList<Abiturient> createAbiturients() {

        ArrayList<Abiturient> abiturients = new ArrayList<>();

        Abiturient abiturient1 = new Abiturient(123, "Jack", "Willson", "Daniels", "Midter str. 122", "235435", 45.6);
        Abiturient abiturient2= new Abiturient(654, "Alice", "Johnson", "Smith", "Sunset Ave. 45", "123456", 89.3);
        Abiturient abiturient3 = new Abiturient(675, "Robert", "Taylor", "Brown", "Maple Lane 67", "987654", 76.8);
        Abiturient abiturient4 = new Abiturient(134, "Jennifer", "Clark", "Davis", "River Road 32", "567890", 92.5);
        Abiturient abiturient5 = new Abiturient(763, "Matthew", "Harris", "Jones", "Forest Hill 11", "234567", 81.7);
        Abiturient abiturient6 = new Abiturient(274, "Laura", "Anderson", "Wilson", "Green Street 78", "876543", 70.2);
        Abiturient abiturient7 = new Abiturient(852, "Jack", "Lee", "Martinez", "Highland Dr. 3", "345678", 88.9);
        Abiturient abiturient8 = new Abiturient(111, "Sarah", "Miller", "Johnson", "Lakeview Rd. 21", "765432", 93.4);
        Abiturient abiturient9 = new Abiturient(161, "John", "White", "Thompson", "Meadow Lane 9", "456789", 77.1);
        Abiturient abiturient10 = new Abiturient(232, "Emily", "Thomas", "Moore", "Valley Blvd. 55", "654321", 85.0);

        abiturients.add(abiturient1);
        abiturients.add(abiturient2);
        abiturients.add(abiturient3);
        abiturients.add(abiturient4);
        abiturients.add(abiturient5);
        abiturients.add(abiturient6);
        abiturients.add(abiturient7);
        abiturients.add(abiturient8);
        abiturients.add(abiturient9);
        abiturients.add(abiturient10);

        return abiturients;
    }
    public static void printStudentsByName(String inputName, ArrayList<Abiturient> abiturients) {
       boolean isFound = false;
        for (Abiturient abiturient : abiturients) {
            if(abiturient.getName().equals(inputName)){
                isFound = true;
                System.out.println(abiturient.toString());
            }
        }
        if(!isFound){
            System.out.println("Абітурієнтів з іменем " + inputName + " немає");
        }
    }
    public static void printStudentsByMark(double inputMark, ArrayList<Abiturient> abiturients) {
        boolean isFound = false;
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getAverageMark() > inputMark) {
                isFound = true;
                System.out.println(abiturient.toString());
            }
        }
        if (!isFound) {
            System.out.println("Абітурієнтів із балом вище " + inputMark + " немає");
        }
    }
    public static void printTopNStudentsByMark(int n, ArrayList<Abiturient> abiturients){
        // Спочатку сортую абітурієнтів за спаданням балу а потім обираю n перших
        abiturients.sort(new Comparator<Abiturient>() {
            @Override
            public int compare(Abiturient ab1, Abiturient ab2) {
                return Double.compare(ab2.getAverageMark(), ab1.getAverageMark());
            }
        });
        // Вибір перших n абітурієнтів (з найвищими оцінками)
        List<Abiturient> topNStudents = abiturients.subList(0, n);
        for (Abiturient abiturient : topNStudents) {
            System.out.println(abiturient);
        }
    }
}
