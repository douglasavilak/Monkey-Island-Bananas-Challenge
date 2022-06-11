package com.challenge.island.monkey.utils;

import com.challenge.island.monkey.domain.Field;
import com.challenge.island.monkey.domain.FieldsMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FieldUtils {

    public FieldUtils() {throw new IllegalStateException("Utils Class, should not be instantiated!");}

    /**
     * Return the next best field for monkey to move
     */
    public static Field getNextBestPlace(FieldsMap fieldsMap, Field lastVisitedPlace, int currentColumn) {

        Field bestFieldOnColumn = new Field(0, 0, 0);

        List<Integer> possibleNextFields = getPossibleNextFields(fieldsMap.getFields().length, lastVisitedPlace, currentColumn);

        for (int possibleRow : possibleNextFields) {
            int fieldBananaCount = fieldsMap.getFields()[possibleRow][currentColumn];

            if (!isFieldBananaCountBetter(fieldBananaCount, bestFieldOnColumn.getBananas())) continue;

            bestFieldOnColumn = Field.builder()
                    .row(possibleRow)
                    .col(currentColumn)
                    .bananas(fieldBananaCount)
                    .build();
        }

        return bestFieldOnColumn;
    }

    /**
     * Get possible next fields for monkey to move
     */
    public static List<Integer> getPossibleNextFields(int mapRows, Field previousField, int currentColumn) {

        if (currentColumn == 0) {
            return getAllAvailableRows(mapRows);
        }

        List<Integer> possibleFields = new ArrayList<>();

        if (previousField.getRow() > 0) possibleFields.add(previousField.getRow() -1);

        possibleFields.add(previousField.getRow());

        if (previousField.getRow() < mapRows -1) possibleFields.add(previousField.getRow() +1);

        return possibleFields;
    }

    /**
     * Get all available rows on the map
     */
    private static List<Integer> getAllAvailableRows(int mapRows) {
        return IntStream.rangeClosed(0, mapRows - 1).boxed().toList();
    }

    /**
     * Check if the fieldBananaCount has more bananas than the bestBananaCount
     */
    public static boolean isFieldBananaCountBetter(int fieldBananaCount, int bestBananaCount) {

        return fieldBananaCount > bestBananaCount;
    }

    /**
     * Get the monkey's previous visited position field if it exists. Returns the map first position if not
     */
    public static Field getLastPlaceVisited(List<Field> visitedPlaces) {
        if (visitedPlaces.isEmpty())
            return new Field();

        return visitedPlaces.get(visitedPlaces.size() -1);
    }
}
