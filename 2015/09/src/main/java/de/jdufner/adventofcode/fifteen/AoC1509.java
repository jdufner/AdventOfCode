package de.jdufner.adventofcode.fifteen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class AoC1509 {

    void differencesOfStringsPart1(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(this::parseFile);
        }
    }

    private void parseFile(String s) {

    }

}
