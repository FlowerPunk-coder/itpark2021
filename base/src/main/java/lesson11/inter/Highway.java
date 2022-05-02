package lesson11.inter;

public interface Highway extends Road {

    int ALLOWED_SPEED = 80;
    int MAX_SPEED = 100;

    @Override
    default int getAllowedSpeed() {
        return ALLOWED_SPEED;
    }

    @Override
    default int getMaxSpeed() {
        return MAX_SPEED;
    }
}
