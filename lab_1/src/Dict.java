/**
 * Class that implements int hash-table
 */
class Dict {

  public int[][] dict;

  /**
   * Constructor initialize two-dimensional array for pairs
   */
  public Dict() {
    dict = new int[0][2];
  }

  /**
   * Method add ascii code and his frequency
   *
   * @param symbol char symbol
   */
  public void addSymbol(char symbol) {
    for (int[] ints : dict) {
      if (ints[0] == symbol) {
        ints[1] += 1;
        return;
      }
    }

    int[][] temp = dict.clone();
    dict = new int[length() + 1][2];
    System.arraycopy(temp, 0, dict, 0, temp.length);
    dict[length() - 1][0] = symbol;
    dict[length() - 1][1] = 1;
  }

  /**
   * Print dict
   */
  public void print() {
    for (int[] ints : dict) {
      System.out.printf("Symbol: %-6s| count: %d\n",
          Character.isWhitespace(ints[0]) ? "space" : Character.toString(ints[0]), ints[1]);
    }
  }

  /**
   * @return length of dict
   */
  public int length() {
    return dict.length;
  }
}
