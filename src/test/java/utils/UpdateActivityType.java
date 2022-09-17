package utils;

import java.util.ArrayList;
import java.util.List;

public class UpdateActivityType {
    public static List<String> update(String type, int numbers) {
        if (type.contains("-")) {
            type = type.replace("    -", "");
            type = type.replace(": ", " - ");
        }
        List<String> expectedTypes = new ArrayList<String>();
        for (int i = 0; i < numbers; i++) {
            expectedTypes.add(type);
        }
        return expectedTypes;
    }
}
