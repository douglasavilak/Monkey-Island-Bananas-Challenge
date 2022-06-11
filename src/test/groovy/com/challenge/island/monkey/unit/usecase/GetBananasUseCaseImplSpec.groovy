package com.challenge.island.monkey.unit.usecase

import br.com.six2six.fixturefactory.Fixture
import com.challenge.island.monkey.domain.FieldsMap
import com.challenge.island.monkey.fixtures.FieldsMapTemplate
import com.challenge.island.monkey.unit.utils.BaseUnitTest
import com.challenge.island.monkey.usecase.GetBananasUseCase
import com.challenge.island.monkey.usecase.impl.GetBananasUseCaseImpl

class GetBananasUseCaseImplSpec extends BaseUnitTest {

    GetBananasUseCase getBananasUseCase

    def setup() {
        getBananasUseCase = new GetBananasUseCaseImpl()
    }

    def "Given a 3x3 fieldsMap(ISLAND_MAP_1) then should return 12"() {
        given:
        FieldsMap fieldsMap = Fixture.from(FieldsMap).gimme(FieldsMapTemplate.ISLAND_MAP_1)

        when:
        int numberOfBananas = getBananasUseCase.execute(fieldsMap)

        then:
        numberOfBananas == 12
    }

    def "Given 4x4 fieldsMap(ISLAND_MAP_2) then should return 16"() {
        given:
        FieldsMap fieldsMap = Fixture.from(FieldsMap).gimme(FieldsMapTemplate.ISLAND_MAP_2)

        when:
        int numberOfBananas = getBananasUseCase.execute(fieldsMap)

        then:
        numberOfBananas == 16
    }

    def "Given 4x4 fieldsMap(ISLAND_MAP_3) then should return 83"() {
        given:
        FieldsMap fieldsMap = Fixture.from(FieldsMap).gimme(FieldsMapTemplate.ISLAND_MAP_3)

        when:
        int numberOfBananas = getBananasUseCase.execute(fieldsMap)

        then:
        numberOfBananas == 83
    }
}
