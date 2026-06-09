import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private List<Reservation> reservations = new ArrayList<>();
    private DiscountPolicy discountPolicy;

    public ReservationService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Reservation createReservation(
            String reservationId,
            Student student,
            Equipment equipment,
            int days) {

        double price =
                equipment.calculateDailyPrice() * days;

        price = discountPolicy.applyDiscount(student, price);

        Reservation reservation =
                new Reservation(
                        reservationId,
                        student,
                        equipment,
                        days);

        reservations.add(reservation);

        System.out.println("Koszt: " + price + " PLN");

        return reservation;
    }

    public void returnEquipment(String reservationId) {

        for (Reservation r : reservations) {

            if (r.getId().equals(reservationId)
                    && r.getStatus() == ReservationStatus.ACTIVE) {

                r.setStatus(ReservationStatus.RETURNED);

                int points = r.getDays() * 2;

                r.getStudent().addPoints(points);

                System.out.println(
                        "Zwrócono sprzęt. Dodano "
                                + points
                                + " pkt.");
            }
        }
    }

    public void showActiveReservations() {

        for (Reservation r : reservations) {

            if (r.getStatus() == ReservationStatus.ACTIVE) {
                System.out.println(r.getDisplayText());
            }
        }
    }
}