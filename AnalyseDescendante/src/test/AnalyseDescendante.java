package test;

public class AnalyseDescendante {
    
    private String input;
    private int pos;

    public RecursiveDescendantParser(String input) {
        this.input = input;
        this.pos = 0;
    }

    public boolean parseS() {
        if (pos >= input.length()) {
            return false;
        }

        // S → Sb
        if (input.charAt(pos) == 'S' && pos + 1 < input.length() && input.charAt(pos + 1) == 'b') {
            pos++;  // Consommer 'S'
            return parseS() && input.charAt(pos++) == 'b';
        }

        // S → c
        if (input.charAt(pos) == 'c') {
            pos++;
            return true;
        }

        // S → bcSbSS
        if (input.charAt(pos) == 'b') {
            pos++;
            if (parseS()) {
                if (pos < input.length() && input.charAt(pos) == 'b') {
                    pos++;
                    if (parseS() && parseS()) {
                        return true;
                    }
                }
            }
        }

        // S → bSb
        if (input.charAt(pos) == 'b') {
            pos++;
            if (parseS()) {
                if (pos < input.length() && input.charAt(pos) == 'b') {
                    pos++;
                    return true;
                }
            }
        }

        // S → cAc
        if (input.charAt(pos) == 'c') {
            pos++;
            if (parseA()) {
                if (pos < input.length() && input.charAt(pos) == 'c') {
                    pos++;
                    return true;
                }
            }
        }

        return false; 
    }

    public boolean parseA() {
        if (pos >= input.length()) {
            return false;
        }

        // A → bAA
        if (input.charAt(pos) == 'b') {
            pos++;
            if (parseA()) {
                if (parseA()) {
                    return true;
                }
            }
        }

        // A → cASAb
        if (input.charAt(pos) == 'c') {
            pos++;
            if (parseA()) {
                if (pos < input.length() && input.charAt(pos) == 'S') {
                    pos++;
                    if (input.charAt(pos) == 'b') {
                        pos++;
                        return true;
                    }
                }
            }
        }

        // A → dcb
        if (input.charAt(pos) == 'd') {
            pos++;
            if (input.charAt(pos) == 'c') {
                pos++;
                if (input.charAt(pos) == 'b') {
                    pos++;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean parse() {
        return parseS() && pos == input.length();
    }

    public static void main(String[] args) {
        String[] testStrings = {"cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbdcbc", "cdcbbb", "cdcb", ""};

        for (String testString : testStrings) {
            RecursiveDescendantParser parser = new RecursiveDescendantParser(testString);
            System.out.println("Test avec la chaîne \"" + testString + "\": " + (parser.parse() ? "Validée" : "Non validée"));
        }
    }


public class SimpleParser {

    private String input;
    private int pos;

    public SimpleParser(String input) {
        this.input = input;
        this.pos = 0;
    }

    public boolean parseS() {
        if (pos >= input.length()) {
            return false;
        }

        // S → bSc
        if (input.charAt(pos) == 'b') {
            pos++;
            if (parseS()) {
                if (pos < input.length() && input.charAt(pos) == 'c') {
                    pos++;
                    return true;
                }
            }
        }

        // S → d
        if (input.charAt(pos) == 'd') {
            pos++;
            return true;
        }

        return false;
    }

    public boolean parse() {
        return parseS() && pos == input.length();
    }

    public static void main(String[] args) {
        String[] testStrings = {"d", "bdc", "bbdcc", "b", "c", "bbcd", "bcdd"};

        for (String testString : testStrings) {
            SimpleParser parser = new SimpleParser(testString);
            System.out.println("Test avec la chaîne \"" + testString + "\": " + (parser.parse() ? "Validée" : "Non validée"));
        }
    }
}
	}

