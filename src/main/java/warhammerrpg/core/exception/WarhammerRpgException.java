package warhammerrpg.core.exception;

public class WarhammerRpgException extends Exception {

    public WarhammerRpgException(Exception originalExceptionObject) {
        super();
        this.originalExceptionObject = originalExceptionObject;
    }

    public WarhammerRpgException() {
        super();
    }

    protected Exception originalExceptionObject;

    public Exception getOriginalExceptionObject() {
        return originalExceptionObject;
    }

    public void setOriginalExceptionObject(Exception originalExceptionObject) {
        this.originalExceptionObject = originalExceptionObject;
    }

}
