package de.jdufner.adventofcode.fifteen;

class AoC1510 {

    static String lookAndSay(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 0;
        String previous = null;
        while (index < s.length()) {
            String c = s.substring(index, index + 1);
            if (previous == null || previous.equals(c)) {
                count += 1;
            } else {
                sb.append(count);
                sb.append(previous);
                count = 1;
            }
            previous = c;
            index++;
        }
        sb.append(count);
        sb.append(previous);
        return sb.toString();
    }

    static String lookAndSayIteratively(String s, int iterations) {
        String str = s;
        for (int i = 0; i < iterations; i++) {
            str = lookAndSay(str);
        }
        return str;
    }

    static int lookAndSayIterativelyLength(String s, int iterations) {
        return lookAndSayIteratively(s, iterations).length();
    }
}
