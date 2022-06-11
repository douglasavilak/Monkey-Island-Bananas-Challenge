package com.challenge.island.monkey.unit.utils

import spock.lang.Specification

import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates

class BaseUnitTest extends Specification {

    def setupSpec() {
        loadTemplates("com.challenge.island.monkey.fixtures")
    }
}
