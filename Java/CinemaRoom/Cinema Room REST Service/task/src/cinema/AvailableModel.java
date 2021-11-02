package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AvailableModel {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean reserved;

    public AvailableModel(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = 8;
        if (row <= 4){
            this.price = 10;
        }
        this.reserved = false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserve) {
        reserved = reserve;
    }
}
