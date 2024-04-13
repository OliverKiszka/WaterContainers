package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

public class WaterContainerService {

    public WaterContainer getTheMostFilledContainerWithLitres(WaterContainer[] array) {
       WaterContainer theBiggestWaterLevelContainer = getFirstNotNullContainerFromArray(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getWaterLevel() > theBiggestWaterLevelContainer.getWaterLevel()) {
                theBiggestWaterLevelContainer = array[i];
            }
        }
        return theBiggestWaterLevelContainer;
    }





    private WaterContainer getFirstNotNullContainerFromArray(WaterContainer[] array) {
        WaterContainer firstNotNullContainer = null;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                firstNotNullContainer = array[i];
                break;
            }
        }

        return firstNotNullContainer;
    }
}
