package roomescape.reservation;


public class ReservationRequest {
    private String name;
    private String date;
    private Long time_id;

    public ReservationRequest(String name, String date, Long time) {
        this.name = name;
        this.date =  date;
        this.time_id = time;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public Long getTime_id() {
        return time_id;
    }

}