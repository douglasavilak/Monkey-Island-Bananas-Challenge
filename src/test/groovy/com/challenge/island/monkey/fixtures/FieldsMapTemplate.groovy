package com.challenge.island.monkey.fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.challenge.island.monkey.domain.FieldsMap

import static com.challenge.island.monkey.domain.FieldsMap.Fields.*

class FieldsMapTemplate implements TemplateLoader {

    public static final String ISLAND_MAP_1 = "ISLAND_MAP_1"
    public static final String ISLAND_MAP_2 = "ISLAND_MAP_2"
    public static final String ISLAND_MAP_3 = "ISLAND_MAP_3"

    @Override
    void load() {
        Fixture.of(FieldsMap).addTemplate(ISLAND_MAP_1, new Rule() {
            {
                add(fields, [[1, 3, 3],
                             [2, 1, 4],
                             [0, 6, 4]] as int[][])
            }
        })
        Fixture.of(FieldsMap).addTemplate(ISLAND_MAP_2, new Rule() {
            {
                add(fields, [ [1, 3, 1, 5],
                              [2, 2, 4, 1],
                              [5, 0, 2, 3],
                              [0, 6, 1, 2]] as int[][])
            }
        })
        Fixture.of(FieldsMap).addTemplate(ISLAND_MAP_3, new Rule() {
            {
                add(fields, [ [10, 33, 13, 15],
                              [22, 21, 04, 1],
                              [5, 0, 2, 3],
                              [0, 6, 14, 2]] as int[][])
            }
        })
    }
}
