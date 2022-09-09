package models;

import enums.Brand;
import enums.DistanceTypeShoes;
import enums.ShoeSize;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewShoe {
    private String shoeName;
    private Brand brand;
    private String model;
    private String cost;
    private String datePurchased;
    private ShoeSize shoeSize;
    private String startingDistance;
    private DistanceTypeShoes startingDistanceType;
    private String distanceAlert;
    private DistanceTypeShoes distanceAlertType;
    private String notes;
}
