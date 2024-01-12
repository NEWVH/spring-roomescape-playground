package roomescape.Time;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }
    @GetMapping
    public ResponseEntity<List<Time>> select(){
        return ResponseEntity.ok().body(timeService.getTimes());
    }

    @PostMapping
    public ResponseEntity<Time> create(@RequestBody Time time){
        Time newTime = timeService.postTimes(time);
        int id = (int) newTime.getId();
        return ResponseEntity.created(URI.create("/times/" + id)).body(newTime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Time> delete(@PathVariable Long id) {
        timeService.deleteTimes(id);
        return  ResponseEntity.noContent().build();
    }


}