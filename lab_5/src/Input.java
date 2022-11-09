import java.util.Scanner;

/**
 * Class input system
 */
public class Input {
  /**
   * Method for check and input integer
   *
   * @return int
   */
  public static int intInput() {
    Scanner scan = new Scanner(System.in);
    while (!scan.hasNextInt()) {
      System.err.println("Incorrect value!");
      scan.next();
    }
    return scan.nextInt();
  }

  /**
   * Method for check and input positive integer
   *
   * @return int
   */
  public static int positiveIntInput() {
    int number;
    do {
      number = intInput();
      if (number <= 0) {
        System.out.println("Number must be positive!");
      }
    } while (number <= 0);
    return number;
  }

  /**
   * Method for check and input Double
   *
   * @return double
   */
  public static double doubleInput() {
    Scanner scan = new Scanner(System.in);
    while (!scan.hasNextDouble()) {
      System.err.println("Incorrect value!");
      scan.next();
    }
    return scan.nextDouble();
  }

  /**
   * Method for string input
   *
   * @return string
   */
  public static String stringInput() {
    Scanner scan = new Scanner(System.in);
    return scan.nextLine();
  }
}
