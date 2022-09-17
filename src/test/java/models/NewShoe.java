package models;

import enums.Brand;
import enums.DistanceTypeShoes;
import enums.ShoeSize;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

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
    private String brandAndModel;

    public String getBrandAndModel() {
        if (brandAndModel !=null){return brandAndModel;}
        else {
           return brand.getName()+" "+model;
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewShoe newShoe = (NewShoe) o;
        return Objects.equals(shoeName, newShoe.shoeName) && Objects.equals(cost, newShoe.cost) && Objects.equals(datePurchased, newShoe.datePurchased) && shoeSize == newShoe.shoeSize && Objects.equals(startingDistance, newShoe.startingDistance) && startingDistanceType == newShoe.startingDistanceType && Objects.equals(distanceAlert, newShoe.distanceAlert) && distanceAlertType == newShoe.distanceAlertType && Objects.equals(notes, newShoe.notes) && Objects.equals(getBrandAndModel(), newShoe.getBrandAndModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoeName, cost, datePurchased, shoeSize, startingDistance, startingDistanceType, distanceAlert, distanceAlertType, notes, brandAndModel);
    }
}
