package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CinemaService {

    // initialize
    public CinemaModel initializeSeats(){
        CinemaModel cinemaModel = new CinemaModel();

        cinemaModel.setTotalRows(9);
        cinemaModel.setTotalColumns(9);

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                cinemaModel.setAvailableSeats(new AvailableModel(i,j));
            }
        }
        return  cinemaModel;
    }

    public CinemaModel getSeats(CinemaModel cinemaModel){

        List<AvailableModel> newAvailableModel = new ArrayList<>();

        for (AvailableModel availableModel : cinemaModel.getAvailableSeats()){
            if (!availableModel.getReserved()){
                newAvailableModel.add(new AvailableModel(availableModel.getRow(), availableModel.getColumn()));
            }
        }
        cinemaModel.setAvailableSeats(newAvailableModel);
        return  cinemaModel;
    }

    // Out Of Bound Control
    public boolean isOutOfBounds(AvailableDto availableDto){
        return availableDto.getRow() > 9 || availableDto.getColumn() > 9 || availableDto.getRow() < 1 || availableDto.getColumn() < 1;
    }

    public ResponseEntity<Response> purchase(AvailableDto availableDto, CinemaModel cinemaModel){

        if(this.isOutOfBounds(availableDto)){
            return ResponseEntity.badRequest().body(new ResponseError("The number of a row or a column is out of bounds!"));
        }

        for (AvailableModel availableModel : cinemaModel.getAvailableSeats()){
            if(availableModel.getColumn() == availableDto.getColumn() && availableModel.getRow() == availableDto.getRow() && !availableModel.getReserved()){
                availableModel.setReserved(true);
                return ResponseEntity.ok(new ResponsePurchase(availableDto.getRow(),availableDto.getColumn(),availableModel.getPrice()));
            }
        }
        return ResponseEntity.badRequest().body(new ResponseError("The ticket has been already purchased!"));
    }
}
