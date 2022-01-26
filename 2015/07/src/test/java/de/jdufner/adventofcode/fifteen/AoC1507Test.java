package de.jdufner.adventofcode.fifteen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AoC1507Test {

    @Test
    void whenEvaluateAndExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("123 AND 456 -> d" );

        // assert
        assertEquals(72, aoC1507.getEvaluated("d"));
    }

    @Test
    void whenEvaluateOrExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("123 OR 456 -> e" );

        // assert
        assertEquals(507, aoC1507.getEvaluated("e"));
    }

    @Test
    void whenEvaluateLshiftExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("123 LSHIFT 2 -> f" );

        // assert
        assertEquals(492, aoC1507.getEvaluated("f"));
    }

    @Test
    void whenEvaluateRshiftExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("456 RSHIFT 2 -> g" );

        // assert
        assertEquals(114, aoC1507.getEvaluated("g"));
    }

    @Test
    void whenEvaluateNot1ExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("NOT 123 -> h" );

        // assert
        assertEquals(65412, aoC1507.getEvaluated("h"));
    }

    @Test
    void testNot() {
        int s1 = 123;
        //short s2 = (short) ~s1;
        int s2 = 65535 - s1;
        assertEquals(65412, s2);
    }

    @Test
    void whenEvaluateNot2ExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("NOT 456 -> i" );

        // assert
        assertEquals(65079, aoC1507.getEvaluated("i"));
    }

    @Test
    void whenEvaluateAssignment1ExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("123 -> x" );

        // assert
        assertEquals(123, aoC1507.getEvaluated("x"));
    }

    @Test
    void whenEvaluateAssignment2ExpectResult() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("456 -> y" );

        // assert
        assertEquals(456, aoC1507.getEvaluated("y"));
    }

    @Test
    void testExamplePart1() {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.evaluateInstruction("123 -> x" );
        aoC1507.evaluateInstruction("456 -> y" );
        aoC1507.evaluateInstruction("x AND y -> d" );
        aoC1507.evaluateInstruction("x OR y -> e" );
        aoC1507.evaluateInstruction("x LSHIFT 2 -> f" );
        aoC1507.evaluateInstruction("y RSHIFT 2 -> g" );
        aoC1507.evaluateInstruction("NOT x -> h" );
        aoC1507.evaluateInstruction("NOT y -> i" );

        // assert
        assertEquals(72, aoC1507.getEvaluated("d"));
        assertEquals(507, aoC1507.getEvaluated("e"));
        assertEquals(492, aoC1507.getEvaluated("f"));
        assertEquals(114, aoC1507.getEvaluated("g"));
        assertEquals(65412, aoC1507.getEvaluated("h"));
        assertEquals(65079, aoC1507.getEvaluated("i"));
        assertEquals(123, aoC1507.getEvaluated("x"));
        assertEquals(456, aoC1507.getEvaluated("y"));
    }

    @Test
    void part1() throws Exception {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.loadFile("./src/test/resources/input");
        aoC1507.evaluate();

        // assert
        assertEquals(956, aoC1507.getEvaluated("a"));
    }

    @Test
    void part2() throws Exception {
        // arrange
        AoC1507 aoC1507 = new AoC1507();

        // act
        aoC1507.loadFile("./src/test/resources/input2");
        aoC1507.evaluate();

        // assert
        assertEquals(40149, aoC1507.getEvaluated("a"));
    }

}
