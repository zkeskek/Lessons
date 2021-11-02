package cinema;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CinemaController {

    CinemaService cinemaService = new CinemaService();
    CinemaModel cinemaModel = cinemaService.initializeSeats();

    @GetMapping
    public ResponseEntity<String> index(){
        return  ResponseEntity.ok("Hello Cinema Task.");
    }

    @GetMapping("/seats")
    public ResponseEntity<CinemaModel> seats(){
        return ResponseEntity.ok(cinemaService.getSeats(cinemaModel));
    }

    @PostMapping("/purchase")
    public ResponseEntity<Response> purchase(@RequestBody AvailableDto availableDto){
        return cinemaService.purchase(availableDto, cinemaModel);
    }

}
