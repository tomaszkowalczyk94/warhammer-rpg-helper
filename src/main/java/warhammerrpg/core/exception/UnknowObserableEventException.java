package warhammerrpg.core.exception;

public class UnknowObserableEventException extends WarhammerRpgException {
  public UnknowObserableEventException(Exception originalExceptionObject){
    super(originalExceptionObject);
  }
  
  public String toString(){
    return "Unknown observable event";
  }
  
}
