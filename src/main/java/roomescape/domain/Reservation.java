package roomescape.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;
import roomescape.DTO.ReservationDTO;
import roomescape.domain.value.Date;
import roomescape.domain.value.ID;
import roomescape.domain.value.Name;
import roomescape.domain.value.Time;

import javax.naming.Name;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    private ID id;
    private Name name;
    private Date date;
    private Time time;

    public Reservation(Long id, String name, String date, String time) {
        this.id = new ID(id);
        this.name = new Name(name);
        this.date = new Date(date);
        this.time = new Time(time);
    }

    public ReservationDTO toDTO() {
        return new ReservationDTO(this.id.getId(), this.name.getName(), this.date.getDate(), this.time.getTime());
    }

    public Long getID() {
        return id.getId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



}
