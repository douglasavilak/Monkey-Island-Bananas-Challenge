package com.challenge.island.monkey.usecase.impl;

import com.challenge.island.monkey.domain.Field;
import com.challenge.island.monkey.domain.FieldsMap;
import com.challenge.island.monkey.usecase.GetBananasUseCase;
import com.challenge.island.monkey.utils.FieldUtils;

import java.util.ArrayList;
import java.util.List;

public class GetBananasUseCaseImpl implements GetBananasUseCase {

    @Override
    public int execute(FieldsMap fieldsMap) {
        int numberOfBananas = 0;
        List<Field> visitedPlaces = new ArrayList<>();

        // iterate over columns
        for (int col = 0; col < fieldsMap.getFields()[0].length; col++) {
            Field lastVisitedPlace = FieldUtils.getLastPlaceVisited(visitedPlaces);

            Field nextBestPlace = FieldUtils.getNextBestPlace(fieldsMap, lastVisitedPlace, col);
            visitedPlaces.add(nextBestPlace);

            numberOfBananas += nextBestPlace.getBananas();
        }

        return numberOfBananas;
    }
}
