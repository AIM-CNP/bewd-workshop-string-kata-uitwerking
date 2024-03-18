package nl.han.aim.bewd.wsstringkata;

public class StringKata {


    /**
     * In deze main worden alle "tests" uitgevoerd die aantonen dat de string calculator naar behoren werkt.
     * @param args standaard-args voor uitvoeren vanaf de commandline.
     */
    public static void main(String[] args) {

        StringCalculator calc = new StringCalculator();
        if(calc.add("") != 0) {
            System.out.println("FOUT: lege string levert geen nul op.");
        }
        if(calc.add("129") != 129) {
            System.out.println("FOUT: string met één getal levert geen getal op.");
        }

        if(calc.add("12, 91") != 103) {
            System.out.println("FOUT: string met komma levert niet het juiste resultaat op.");
        }

        if(calc.add("\n12, 91") != 103) {
            System.out.println("FOUT: string met komma en extra witruimte levert niet het juiste resultaat op.");
        }

        if(calc.add("1, 2, 3, 4, 25") != 35) {
            System.out.println("FOUT: string met meerdere getallen levert niet het juiste resultaat op.");
        }

        if(calc.add("1, 2, 3, 4\n 25") != 35) {
            System.out.println("FOUT: string met meerdere getallen en delimiters levert niet het juiste resultaat op.");
        }
        if(calc.add("//%!%\n12 %!% 91") != 103) {
            System.out.println("FOUT: string met custom delimiter (1) levert niet het juiste resultaat op.");
        }
        if(calc.add("2, 1001") != 2 && calc.add("1001") != 0) {
            System.out.println("FOUT: getallen groter dan 1000 worden niet genegeerd.");
        }
        if(calc.add("//[abc][def][ghijk]\n1abc 2 ghijk 3 def 4") != 10) {
            System.out.println("FOUT: string met meerdere custom delimiters levert niet het juiste resultaat op.");
        }
        if(calc.add("//[*][%]\n1*2%3") != 6) {
            System.out.println("FOUT: string met meerdere custom delimiters met daarin speciale tekens levert niet het juiste resultaat op.");
        }


        System.out.println("Klaar met testen.");

    }
}
