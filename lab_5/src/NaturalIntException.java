/**
 * Class for negative integer exception
 */
public class NaturalIntException extends Exception {

  /**
   * int number due to which the exception occurred
   */
  private final int number;

  /**
   * Getter method for exception int number
   *
   * @return exception int number
   */
  public int getNumber() {return number;}

  /**
   * Constructor of negative int exception
   *
   * @param message error message
   * @param number exception int exception
   */
  public NaturalIntException(String message, int number) {
    super(message);
    this.number = number;
  }
}
