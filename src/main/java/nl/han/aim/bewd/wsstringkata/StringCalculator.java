package nl.han.aim.bewd.wsstringkata;


import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {

        var trimmed = numbers.trim();

        if(trimmed.isEmpty()) {
            return 0;
        }

        if(trimmed.matches("^\\d+$")) {
            var result = Integer.parseInt(numbers);
            if (result > 1000) {
                return 0;
            }
            return result;
        }

        // De (?s) aan het begin zorgt ervoor dat . matcht op newlines.
        if(trimmed.matches("^(?s)\\d.*[\\d\\s\\n,]+$")) {
            String[] inputValues = trimmed.split("\\s*[,\\n]+\\s*");
            int result = 0;
            for(var inputValue : inputValues) {
                var inputValueInt = Integer.parseInt(inputValue);
                if(inputValueInt <= 1000) {
                    result += inputValueInt;
                }
            }
            return result;
        }

        // Meerdere custom delimiters.
        if(trimmed.startsWith("//[")) {
            var trimmedContent = trimmed.split("\\n");
            var delimiters = trimmedContent[0]
                    .replaceAll("^//\\[", "")
                    .replaceAll("\\]$", "")
                    .split("\\]\\[");
            for(int i = 0; i < delimiters.length; i++) {
                delimiters[i] = Pattern.quote(delimiters[i]);
            }
            var reString = "\s*(" + String.join("|", delimiters) + ")\s*";
            int result = 0;
            for(var inputValue : trimmedContent[1].split(reString)) {
                var inputValueInt = Integer.parseInt(inputValue.trim());
                if(inputValueInt <= 1000) {
                    result += inputValueInt;
                }
            }
            return result;

        }
        // Enkele custom delimiter.
        if(trimmed.startsWith("//")) {
            String[] trimmedContent = trimmed.split("\\n");
            var delimiter = trimmedContent[0].replaceAll("^//", "");

            int result = 0;
            for(var inputValue : trimmedContent[1].split(delimiter)) {
                var inputValueInt = Integer.parseInt(inputValue.trim());
                if(inputValueInt <= 1000) {
                    result += inputValueInt;
                }
            }
            return result;
        }



        return -1;

    }
}
