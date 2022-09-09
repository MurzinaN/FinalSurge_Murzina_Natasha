package utils;

import enums.Brand;
import enums.DistanceTypePaceCalculator;
import enums.DistanceTypeShoes;
import enums.ShoeSize;
import models.NewShoe;
import models.PaceCalculator;

public class NewShoeFactory {
    public static NewShoe getNewShoe() {
        return NewShoe.builder()
                .shoeName("MySneakers")
                .brand(Brand.NIKE)
                .model("Air max")
                .cost("200.00")
                .datePurchased("9/6/2022")
                .shoeSize(ShoeSize.SIZE_6_5)
                .startingDistance("0.0")
                .distanceAlert("1,000")
                .distanceAlertType(DistanceTypeShoes.KM)
                .notes("good")
                .build();
    }
}
