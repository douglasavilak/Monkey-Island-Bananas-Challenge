package com.challenge.island.monkey.fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.challenge.island.monkey.domain.Field

import static com.challenge.island.monkey.domain.Field.Fields.*

class FieldTemplate implements TemplateLoader {

    public static final String FIRST_FIELD_ON_MAP = "MAP_FIRST_FIELD"
    public static final String MEDIUM_FIELD_ON_COLUMN_0 = "MEDIUM_FIELD_ON_COLUMN_0"
    public static final String BEST_FIELD_ON_COLUMN_0 = "BEST_FIELD_ON_COLUMN_0"

    public static final String MEDIUM_FIELD_ON_COLUMN_1 = "MEDIUM_FIELD_ON_COLUMN_1"
    public static final String BEST_FIELD_ON_COLUMN_1 = "BEST_FIELD_ON_COLUMN_1"


    @Override
    void load() {
        Fixture.of(Field).addTemplate(FIRST_FIELD_ON_MAP, new Rule() {
            {
                add(col, 0)
                add(row, 0)
                add(bananas, 0)
            }
        })

        Fixture.of(Field).addTemplate(MEDIUM_FIELD_ON_COLUMN_0, new Rule() {
            {
                add(col, 0)
                add(row, 1)
                add(bananas, 5)
            }
        })

        Fixture.of(Field).addTemplate(BEST_FIELD_ON_COLUMN_0, new Rule() {
            {
                add(col, 0)
                add(row, 2)
                add(bananas, 7)
            }
        })

        Fixture.of(Field).addTemplate(MEDIUM_FIELD_ON_COLUMN_1, new Rule() {
            {
                add(col, 1)
                add(row, 1)
                add(bananas, 5)
            }
        })

        Fixture.of(Field).addTemplate(BEST_FIELD_ON_COLUMN_1, new Rule() {
            {
                add(col, 1)
                add(row, 2)
                add(bananas, 7)
            }
        })
    }
}
