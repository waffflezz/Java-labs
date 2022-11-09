/**
 * Class for negative double exception
 */
public class NaturalDoubleException extends Exception {

  /**
   * double number due to which the exception occurred
   */
  private final double number;

  /**
   * Getter method for exception double number
   *
   * @return exception double number
   */
  public double getNumber() {return number;}

  /**
   * Constructor of negative double exception
   *
   * @param message error message
   * @param number number due to which the exception occurred
   */
  public NaturalDoubleException(String message, double number) {
    super(message);
    this.number = number;
  }
}
