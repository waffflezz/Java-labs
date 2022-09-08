import java.util.Random;
import java.util.Scanner;

/**
 * Class for terminal UI
 */
class Menu {

  /**
   * Start UI
   */
  public static void start() {
    int choice;
    boolean flag = false;
    String text = "";
    Dict frequencySymbols = null;

    do {
      System.out.println("""
          -----MENU-----
          1. Enter text
          2. Randomize text
          3. Frequency analysis algorithm
          4. Print the result
          5. Exit
          --------------
          """);

      choice = intInput();

      switch (choice) {
        case 1:
          System.out.println("Enter your text:");
          text = Text.stringInput();
          flag = false;
          break;
        case 2:
          System.out.println("Enter text length");
          int length = intInput();
          if (length < 0) {
            System.err.println("Length < 0!");
            break;
          }
          text = Text.randomText(new Random(), length);
          System.out.println("Your text: " + text);
          flag = false;
          break;
        case 3:
          if (!flag && !text.equals("")) {
            frequencySymbols = Text.countOfSymbols(text);
            flag = true;
            System.out.println("Algorithm is done!");
          } else if (flag) {
            System.err.println("Algorithm already is done!");
          } else {
            System.err.println("Text is empty!");
          }
          break;
        case 4:
          if (flag) {
            frequencySymbols.print();
          } else {
            System.err.println("Nothing to print!");
          }
          break;
        default:
          if (choice != 5) {
            System.err.println("Incorrect value!");
          }
      }
    } while (choice != 5);
  }

  /**
   * Method for check and input integers
   *
   * @return int
   */
  private static int intInput() {
    Scanner scan = new Scanner(System.in);
    while (!scan.hasNextInt()) {
      System.err.println("Incorrect value!");
      scan.next();
    }
    return scan.nextInt();
  }
}
