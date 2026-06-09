public class Reservation implements Displayable {

    private String id;
    private Student student;
    private Equipment equipment;
    private int days;
    private ReservationStatus status;

    public Reservation(
            String id,
            Student student,
            Equipment equipment,
            int days) {

        this.id = id;
        this.student = student;
        this.equipment = equipment;
        this.days = days;
        this.status = ReservationStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getDays() {
        return days;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    @Override
    public String getDisplayText() {

        return String.format(
                """
                        Rezerwacja: %s
                        Student: %s
                        Sprzęt: %s
                        Dni: %d
                        Status: %s
                        """,
                id,
                student.getFullName(),
                equipment.getDisplayText(),
                days,
                status
        );
    }
}