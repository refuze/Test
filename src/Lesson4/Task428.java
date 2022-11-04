package Lesson4;

public class Task428 {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection connection = null;

        for (int i = 1; i <= 3; i++) {
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
            } catch (RobotConnectionException e) {
                if (i == 3) {

                }
            } finally {
                if (connection != null)
                    connection.close();
            }
        }
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }

    public class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
