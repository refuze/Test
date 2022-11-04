package Lesson4;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Task437 {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";


    public static void main(String[] args) {
        Thief thief = new Thief(60);
        thief.processMail(new MailPackage("from", "to", new Package("content", 100)));
        thief.processMail(new MailPackage("from", "to", new Package("content", 50)));
        thief.processMail(new MailPackage("from", "to", new Package("content", 90)));
        System.out.println(thief.getStolenValue());
    }

    public static class IllegalPackageException extends Error {

    }

    public static class StolenPackageException extends Error {

    }

    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) throws IllegalPackageException, StolenPackageException {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getContent().contains(WEAPONS) ||
                        ((MailPackage) mail).getContent().getContent().contains(BANNED_SUBSTANCE)){
                    throw new IllegalPackageException();
                } else if (((MailPackage) mail).getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
            }
            return null;
        }
    }

    public static class Thief implements MailService {
        private final int price;
        private int stolenValue = 0;

        public Thief(int price) {
            this.price = price;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                if (((MailPackage) mail).getContent().getPrice() >= price) {
                    stolenValue += ((MailPackage) mail).getContent().getPrice();
                    mail = new MailPackage(mail.getFrom(), mail.getTo(),
                            new Package(String.format("stones instead of %s", ((MailPackage) mail).getContent().getContent()), 0));
                }
            }
            return mail;
        }

        public int getStolenValue(){
            return stolenValue;
        }
    }

    public static class Spy implements MailService {
        private final Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage){
                if (mail.getFrom().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {from} to {to} \"{message}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {from} to {to}",
                            new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] thirdParties;
        private final RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] thirdParties) {
            this.thirdParties = thirdParties;
        }

        public RealMailService getRealMailService(){
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService service : thirdParties) {
                mail = service.processMail(mail);
            }
            return realMailService.processMail(mail);
        }
    }

    public static class RealMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            return mail;
        }
    }

    public static interface MailService {
        Sendable processMail(Sendable mail);
    }


    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailPackage that = (MailPackage) o;

            if (!content.equals(that.content)) return false;

            return true;
        }

    }

    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            MailMessage that = (MailMessage) o;

            if (message != null ? !message.equals(that.message) : that.message != null) return false;

            return true;
        }

    }

    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            AbstractSendable that = (AbstractSendable) o;

            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;

            return true;
        }

    }

    public static interface Sendable {
        String getFrom();
        String getTo();
    }
}
