import java.util.regex.Pattern;

public class CNPJValidator {

    // Regular expressions to match CNPJ formats
    private static final String FORMATTED_CNPJ_REGEX = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}";
    private static final String UNFORMATTED_CNPJ_REGEX = "\\d{14}";

    public static boolean isValidCNPJ(String cnpj) {
        if (cnpj == null) {
            return false;
        }

        // Check if the CNPJ matches either formatted or unformatted pattern
        if (!Pattern.matches(FORMATTED_CNPJ_REGEX, cnpj) && !Pattern.matches(UNFORMATTED_CNPJ_REGEX, cnpj)) {
            return false;
        }

        // Remove any formatting characters (if any) to get the plain number string
        cnpj = cnpj.replaceAll("\\D", "");

        // Validate check digits
        return isValidCheckDigits(cnpj);
    }

    private static boolean isValidCheckDigits(String cnpj) {
        if (cnpj.length() != 14) {
            return false;
        }

        // Calculate first check digit
        int firstCheckDigit = calculateCheckDigit(cnpj, 12);
        // Calculate second check digit
        int secondCheckDigit = calculateCheckDigit(cnpj, 13);

        // Check if the check digits match the provided CNPJ
        return cnpj.charAt(12) - '0' == firstCheckDigit && cnpj.charAt(13) - '0' == secondCheckDigit;
    }

    private static int calculateCheckDigit(String cnpj, int position) {
        int[] weights = (position == 12) ? new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2} :
                new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        for (int i = 0; i < position; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }

        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }

    public static void main(String[] args) {
        String[] testCNPJs = {
                "11.222.333/0001-81", // valid
                "11.222.333/0001-80", // invalid check digits
                "11222333000181",     // valid
                "11222333000180"      // invalid check digits
        };

        for (String cnpj : testCNPJs) {
            System.out.printf("CNPJ %s is valid? %b%n", cnpj, isValidCNPJ(cnpj));
        }
    }
}
