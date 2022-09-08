import java.util.Random;
import java.util.Scanner;

/**
 * Class for manipulation and entering text
 */
class Text {

  /**
   * Method count frequency of symbols
   *
   * @param text source text
   * @return Dict with symbol and his frequency
   */
  public static Dict countOfSymbols(String text) {
    Dict countSymbols = new Dict();
    for (int i = 0; i < text.length(); ++i) {
      countSymbols.addSymbol(text.charAt(i));
    }

    return countSymbols;
  }

  /**
   * Method return random string
   *
   * @param rnd    Random class instance
   * @param length string length
   * @return random string with given length
   */
  public static String randomText(Random rnd, int length) {
    char[] text = new char[length];
    for (int i = 0; i < length; ++i) {
      int rn = rnd.nextInt(0, 16564);
      text[i] = (char) (rn % 25 + 65);
    }

    return new String(text);
  }

  /**
   * String input
   *
   * @return input string
   */
  public static String stringInput() {
    Scanner scan = new Scanner(System.in);
    return scan.nextLine();
  }
}
