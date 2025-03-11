public class NamingConventions {

    private NamingConventions() {}

    private static boolean isSpecialChar(char character){
        return !Character.isLetterOrDigit(character) && character != '$' && character != '_';
    }

    private static boolean isCamelCase(String word) {
        if (Character.isUpperCase(word.charAt(0))) return false;
        return !word.contains("_");
    }

    private static boolean isPascalCase(String word) {
        if (Character.isLowerCase(word.charAt(0))) return false;
        return !word.contains("_");
    }

    private static boolean isUpperSnakeCase(String word) {
        if (Character.isLowerCase(word.charAt(0))) return false;

        for (char carat : word.toCharArray()){
            if (Character.isLowerCase(carat)) return false;
        }

        return true;
    }

    public static boolean isFollowingConvention(String word, Convention convention) {

        if (!isValidJavaIdentifier(word)) return false;

        return switch (convention) {
            case VARIABLE, METHOD -> isCamelCase(word);
            case CLASS -> isPascalCase(word);
            case CONSTANT -> isUpperSnakeCase(word);
            default -> false;
        };
    }

    public static String fromConstToVariable(String constant) {
        if (!isFollowingConvention(constant, Convention.CONSTANT)) return null;
        StringBuilder variable = new StringBuilder();

        if (constant.contains("_")) {
            int index = 0;
            final String[] splitConst = constant.split("_");
            for (String part : splitConst) {
                part = part.toLowerCase();
                if (index != 0) part = Character.toUpperCase(part.charAt(0)) + part.substring(1);
                variable.append(part);
                index++;
            }
        } else {
            variable.append(constant.toLowerCase());
        }

        return variable.toString();
    }

    public static String fromVariableToConst(String variable) {
        if (!isFollowingConvention(variable, Convention.VARIABLE)) return null;
        StringBuilder constant = new StringBuilder();

        for (char carac : variable.toCharArray()){
            if (Character.isUpperCase(carac)) constant.append('_').append(carac);
            else constant.append(Character.toUpperCase(carac));
        }

        return constant.toString();
    }

    private static boolean isValidJavaIdentifier(String identifier) {

        if (identifier == null || identifier.isEmpty()) return false;
        if (Character.isDigit(identifier.charAt(0)) || isSpecialChar(identifier.charAt(0))) return false;

        for (char carat : identifier.toCharArray()){
            if (isSpecialChar(carat)) return false;
        }

        return !isPrimitive(identifier);
    }

    private static boolean isPrimitive(String word) {
        String[] primitives = {"int", "short", "long", "float", "double", "char", "byte", "boolean"};

        for (String primitive : primitives) if (primitive.equals(word)) return true;

        return false;

    }
}
