package Lesson1;

public class Test {
    public static void main(String[] args) {
        System.out.println(printTextPerRole(new String[]{"Городничий", "Артемий Филиппович"},
                new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Артемий Филиппович: Как ревизор?"}));
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder result = new StringBuilder();

        for (String role : roles) {
            result.append(role).append(":").append("\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")){
                    result.append(i + 1).append(")").append(textLines[i].substring((role + ":").length())).append("\n");
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
}
