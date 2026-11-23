import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      Service s = new Service();
      boolean running = true;

      while (running) {
        System.out.println("\nWybierz opcje:");
        System.out.println("1 - Dodaj studenta");
        System.out.println("2 - Wypisz wszystkich studentow");
        System.out.println("0 - Wyjscie");
        System.out.print("Twoj wybor: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
          case "1":
            System.out.print("Podaj imie studenta: ");
            String name = scanner.nextLine().trim();

            System.out.print("Podaj nazwisko studenta: ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Podaj wiek studenta: ");
            String ageInput = scanner.nextLine().trim();

            try {
              int age = Integer.parseInt(ageInput);
              s.addStudent(new Student(name, lastName, age));
              System.out.println("Dodano studenta.");
            } catch (NumberFormatException e) {
              System.out.println("Niepoprawny wiek. Podaj liczbe calkowita.");
            }
            break;

          case "2":
            System.out.println("\nLista studentow w bazie:");
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("Brak studentow w bazie.");
            } else {
              for (Student current : students) {
                System.out.println(current.ToString());
              }
            }
            break;

          case "0":
            running = false;
            System.out.println("Koniec programu.");
            break;

          default:
            System.out.println("Nieznana opcja. Wybierz 1, 2 lub 0.");
            break;
        }
      }
    } catch (IOException e) {
      System.out.println("Blad wejscia/wyjscia: " + e.getMessage());
    }
  }
}