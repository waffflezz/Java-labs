/**
 * Class for year (int) which is less than the current year
 */
public class WrongYearException extends Exception{

  /**
   * int number due to which the exception occurred
   */
  private final int year;

  /**
   * Getter method for exception int number
   *
   * @return exception year (int)
   */
  public int getYear() {return year;}

  /**
   * Constructor of year exception
   *
   * @param message error message
   * @param year year (int) due to which the exception occurred
   */
  public WrongYearException(String message, int year) {
    super(message);
    this.year = year;
  }
}
