package Lesson7;

import java.util.*;
import java.util.function.Consumer;

public class Task7213 {
    public static void main(String[] args) {

        String randomFrom = "randomFrom";
        String randomTo = "randomTo";
        int randomSalary = 100;

        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard"): "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft"): "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!"): "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        MailService<String> mailService = new MailService<>();

        messages.stream().forEachOrdered(mailService);

        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(
                List.of(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ): "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ): "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()): "wrong mailService mailbox content (3)";

        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        MailService<Integer> salaryService = new MailService<>();

        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(List.of(1)): "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(List.of(Integer.MAX_VALUE)): "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(List.of(randomSalary)): "wrong salaries mailbox content (3)";
    }

    public static class MailService<T> implements Consumer<AnyMessage<T>> {
        private Map<String, List<T>> mailBox = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                return getOrDefault(key, Collections.emptyList());
            }
        };

        @Override
        public void accept(AnyMessage<T> o) {
            mailBox.merge(o.getTo(), List.of(o.getContent()), (v1, v2) -> {
                List<T> merged = new ArrayList<>(v1);
                merged.addAll(v2);
                return merged;
            });
        }

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }
    }

    public static class MailMessage extends AnyMessage<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }

    public static class Salary extends AnyMessage<Integer> {
        public Salary(String from, String to, Integer content) {
            super(from, to, content);
        }
    }

    public static class AnyMessage<T> {
        private String from;
        private String to;
        private T content;

        public AnyMessage(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public T getContent() {
            return content;
        }
    }
}
