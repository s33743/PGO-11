import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(
                "S001",
                "Anna Kowalska",
                "12C");

        Student s2 = new Student(
                "S002",
                "Marek Nowak",
                "4D");

        s2.addPoints(120);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        Equipment laptop1 =
                new Laptop(
                        "L001",
                        "Lenovo ThinkPad",
                        25,
                        16,
                        true);

        Equipment laptop2 =
                new Laptop(
                        "L002",
                        "Dell XPS",
                        30,
                        32,
                        false);

        Equipment camera1 =
                new CameraKit(
                        "C001",
                        "Sony Content Kit",
                        35,
                        2,
                        true);

        List<Equipment> equipments = new ArrayList<>();

        equipments.add(laptop1);
        equipments.add(laptop2);
        equipments.add(camera1);

        ReservationService service =
                new ReservationService(
                        new LoyaltyDiscountPolicy());

        System.out.println("\n=== STUDENCI ===");

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\n=== SPRZĘT ===");

        for (Equipment equipment : equipments) {
            System.out.println(
                    equipment.getDisplayText());
            System.out.println();
        }

        System.out.println("\n=== TWORZENIE REZERWACJI ===");

        service.createReservation(
                "R001",
                s1,
                laptop1,
                3);

        service.createReservation(
                "R002",
                s2,
                camera1,
                5);


        System.out.println("\n=== AKTYWNE REZERWACJE ===");

        service.showActiveReservations();

        System.out.println("\n=== ZWROT SPRZĘTU ===");

        service.returnEquipment("R001");

        System.out.println("\n=== AKTYWNE REZERWACJE PO ZWROCIE ===");

        service.showActiveReservations();

        System.out.println("\n=== PUNKTY LOJALNOŚCIOWE ===");

        for (Student student : students) {
            System.out.println(student);
        }
    }
}