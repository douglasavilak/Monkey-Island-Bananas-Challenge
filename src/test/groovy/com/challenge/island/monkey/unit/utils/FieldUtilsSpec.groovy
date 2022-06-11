package com.challenge.island.monkey.unit.utils

import br.com.six2six.fixturefactory.Fixture
import com.challenge.island.monkey.domain.Field
import com.challenge.island.monkey.domain.FieldsMap
import com.challenge.island.monkey.fixtures.FieldTemplate
import com.challenge.island.monkey.fixtures.FieldsMapTemplate
import com.challenge.island.monkey.utils.FieldUtils

class FieldUtilsSpec extends BaseUnitTest {

    Field firstFieldOnColumn0, mediumFieldOnColumn0, bestFieldOnColumn0, mediumFieldOnColumn1
    FieldsMap fieldsMapIsland1

    def setup() {

        fieldsMapIsland1 = Fixture.from(FieldsMap).gimme(FieldsMapTemplate.ISLAND_MAP_1)

        firstFieldOnColumn0 = Fixture.from(Field).gimme(FieldTemplate.FIRST_FIELD_ON_MAP)
        mediumFieldOnColumn0 = Fixture.from(Field).gimme(FieldTemplate.MEDIUM_FIELD_ON_COLUMN_0)
        bestFieldOnColumn0 = Fixture.from(Field).gimme(FieldTemplate.BEST_FIELD_ON_COLUMN_0)

        mediumFieldOnColumn1 = Fixture.from(Field).gimme(FieldTemplate.MEDIUM_FIELD_ON_COLUMN_1)
    }

    /**
     * Tests for class constructor
     */
    def "It should throws a IllegalStateException"() {
        when:
        new FieldUtils()

        then:
        thrown(IllegalStateException)
    }

    /**
     * Tests for getReachableBestFieldOnColumn()
     */
    def "Given ISLAND_MAP_1, a previousField(col 0, row 0, bananas 0) and a column 0 it should return fieldToGo(col 0, row 1, bananas 2)"() {
        given:
        fieldsMapIsland1
        Field previousField = new Field()
        Field fieldToGo = new Field().builder().col(0).row(1).bananas(2).build()
        int col = 0

        when:
        Field resultField = FieldUtils.getNextBestPlace(fieldsMapIsland1, previousField, col)

        then:
        resultField == fieldToGo
    }

    def "Given ISLAND_MAP_2, a previousField(col 1, row 3, bananas 6) and a column 2 it should return fieldToGo(col 2, row 2, bananas 2)"() {
        given:
        FieldsMap fieldsMap = Fixture.from(FieldsMap).gimme(FieldsMapTemplate.ISLAND_MAP_2)
        Field previousField = new Field().builder().col(1).row(3).bananas(6).build()
        Field fieldToGo = new Field().builder().col(2).row(2).bananas(2).build()
        int col = 2

        when:
        Field resultField = FieldUtils.getNextBestPlace(fieldsMap, previousField, col)

        then:
        resultField == fieldToGo
    }

    /**
     * Tests for getPossibleNextFields()
     */
    def "Given iteratingCol = 0 then should return 0, 1, 2"() {
        given:
        fieldsMapIsland1
        firstFieldOnColumn0
        int iteratingCol = 0

        when:
        int[] resultField = FieldUtils.getPossibleNextFields(
                fieldsMapIsland1.getFields().length,
                firstFieldOnColumn0,
                iteratingCol
        )

        then:
        resultField == new int[]{0, 1, 2}
    }

    def "Given a previousField on the first row of the island then should return 0, 1"() {
        given:
        fieldsMapIsland1
        firstFieldOnColumn0
        int iteratingCol = 1

        when:
        int[] resultField = FieldUtils.getPossibleNextFields(
                fieldsMapIsland1.getFields().length,
                firstFieldOnColumn0,
                iteratingCol
        )

        then:
        resultField == new int[]{0, 1}
    }

    def"Given a previousField on the last row of the island(row 2) then should return row -1, row"() {
        given:
        fieldsMapIsland1
        Field lastFieldOnColumn = new Field().builder().col(0).row(2).bananas(0).build()
        int iteratingCol = 1

        when:
        int[] resultField = FieldUtils.getPossibleNextFields(
                fieldsMapIsland1.getFields().length,
                lastFieldOnColumn,
                iteratingCol
        )

        then:
        resultField == new int[]{1, 2}
    }

    def"Given a previousField NOT on the first or last rows then should return row -1, row, row +1"() {
        given:
        fieldsMapIsland1
        mediumFieldOnColumn0
        int iteratingCol = 1

        when:
        int[] resultField = FieldUtils.getPossibleNextFields(
                fieldsMapIsland1.getFields().length,
                mediumFieldOnColumn0,
                iteratingCol
        )

        then:
        resultField == new int[]{0, 1, 2}
    }

    def "Given different scenarios it should return the biggest banana count between two values"() {
        when:
        boolean isFieldBananaCountBetter = FieldUtils.isFieldBananaCountBetter(fieldBananaCount, bestBananaCount)

        then:
        isFieldBananaCountBetter == expectedResult

        where:
        fieldBananaCount | bestBananaCount | expectedResult
         1               | 0               | true
         4               | 1               | true
         0               | 1               | false
        -1               | 0               | false
         3               | 3               | false
    }

    def "Given different scenarios it should get the last place visited by the monkey"() {
        given:
        def placesVisited = []
        def placesVisited2 = [bestFieldOnColumn0]
        def placesVisited3 = [firstFieldOnColumn0, mediumFieldOnColumn0]
        def placesVisited4 = [firstFieldOnColumn0, mediumFieldOnColumn0, bestFieldOnColumn0]
        def placesVisited5 = [firstFieldOnColumn0, mediumFieldOnColumn0, bestFieldOnColumn0, mediumFieldOnColumn1]

        when:
        def lastPlaceVisited = FieldUtils.getLastPlaceVisited(placesVisited)
        def lastPlaceVisited2 = FieldUtils.getLastPlaceVisited(placesVisited2)
        def lastPlaceVisited3 = FieldUtils.getLastPlaceVisited(placesVisited3)
        def lastPlaceVisited4 = FieldUtils.getLastPlaceVisited(placesVisited4)
        def lastPlaceVisited5 = FieldUtils.getLastPlaceVisited(placesVisited5)

        then:
        lastPlaceVisited == new Field()
        lastPlaceVisited2 == bestFieldOnColumn0
        lastPlaceVisited3 == mediumFieldOnColumn0
        lastPlaceVisited4 == bestFieldOnColumn0
        lastPlaceVisited5 == mediumFieldOnColumn1
    }
}