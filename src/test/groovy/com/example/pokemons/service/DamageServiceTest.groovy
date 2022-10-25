package com.example.pokemons.service

import spock.lang.Specification

class DamageServiceTest extends Specification {

    def damageService = Mock(DamageService)

    def "getDamageRatio method should return damage ratio = 0"() {
        given: "basic damage and types"
        def damage = 1
        def attackingType = "fire"
        def attackedType = "water"

        and: "expected result"
        def expectedResult = damage*0;

        and: "mocking other methods"
        damageService.getNoDamageToTypes(attackingType) >> ArrayList.of(attackedType)

        when: "getDamageRatio is called"
        def result = damageService.getDamageRatio(attackingType, attackedType)

        then:
        expectedResult == result
    }
}
