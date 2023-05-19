package strategies;

import models.SpotAssignmentStrategyType;

public class SpotAssignmentStrategyFactory {

    public static SpotAssignmentStrategy getSpotForType(
            SpotAssignmentStrategyType type) {
        return new RandomSpotAssignmentStrategy();
    }
}
