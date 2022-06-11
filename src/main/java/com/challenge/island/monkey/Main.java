package com.challenge.island.monkey;

import com.challenge.island.monkey.domain.FieldsMap;
import com.challenge.island.monkey.usecase.GetBananasUseCase;
import com.challenge.island.monkey.usecase.impl.GetBananasUseCaseImpl;

public class Main {
    public static void main(String[] args) {

        GetBananasUseCase fieldUseCase = new GetBananasUseCaseImpl();

        FieldsMap fieldsMap = FieldsMap.builder()
                .fields(
                    new int[][] {
                                {1, 3, 3},
                                {2, 1, 4},
                                {0, 6, 4}
                    })
                .build();

        FieldsMap fieldsMap2 = FieldsMap.builder()
                .fields(
                        new int[][] {
                                {1, 3, 1, 5},
                                {2, 2, 4, 1},
                                {5, 0, 2, 3},
                                {0, 6, 1, 2}
                        })
                .build();


        FieldsMap fieldsMap3 = FieldsMap.builder()
                .fields(
                        new int[][] {
                                {10, 33, 13, 15},
                                {22, 21, 04, 1},
                                {5, 0, 2, 3},
                                {0, 6, 14, 2}
                        })
                .build();


        System.out.println("On island Map 1 Monkey got: " + fieldUseCase.execute(fieldsMap) + " Bananas");
        System.out.println("On island Map 2 Monkey got: " + fieldUseCase.execute(fieldsMap2) + " Bananas");
        System.out.println("On island Map 3 Monkey got: " + fieldUseCase.execute(fieldsMap3) + " Bananas");
    }
}