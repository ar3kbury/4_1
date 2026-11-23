import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      Service s = new Service();

      System.out.print("Podaj imie studenta: ");
      String name = scanner.nextLine().trim();

      System.out.print("Podaj wiek studenta: ");
      String ageInput = scanner.nextLine().trim();

      int age;
      try {
        age = Integer.parseInt(ageInput);
      } catch (NumberFormatException e) {
        System.out.println("Niepoprawny wiek. Podaj liczbe calkowita.");
        return;
      }

      s.addStudent(new Student(name, age));

      System.out.println("\nLista studentow w bazie:");
      var students = s.getStudents();
      for (Student current : students) {
        System.out.println(current.ToString());
      }
    } catch (IOException e) {
      System.out.println("Blad wejscia/wyjscia: " + e.getMessage());
    }
  }
}