package de.jdufner.adventofcode.fifteen;

class Happiness {

    private String from;
    private String to;
    private int factor;

    Happiness(String from, String to, String loseOrGain, String factor) {
        this.from = from;
        this.to = to;
        this.factor = (loseOrGain.equals("gain") ? Integer.parseInt(factor) : -1 * Integer.parseInt(factor));
    }

    String getFrom() {
        return from;
    }

    String getTo() {
        return to;
    }

    int getFactor() {
        return factor;
    }

}
