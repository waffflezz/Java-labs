import java.util.Calendar;

/**
 * Class for city
 */
public class City {

  /**
   * Current year
   */
  private final int currentYear = Calendar.getInstance().get(Calendar.YEAR);

  /**
   * Count of people in city
   */
  private int peopleCount;
  /**
   * Square of city in km^2
   */
  private double square;
  /**
   * Year of city foundation
   */
  private int yearOfFoundation;
  /**
   * Name of city
   */
  private String name;
  /**
   * Country name
   */
  private String countryName;
  /**
   * Density of people on city. Immutable and dynamic
   */
  private double densityOfPeople;

  /**
   * Constructor without params, by default
   */
  public City()
      throws NaturalIntException, NaturalDoubleException, WrongYearException, BlankStringException {
    this(0, 0.0, 0, "none", "none");
    this.densityOfPeople = 0;
  }

  /**
   * Constructor with params
   *
   * @param peopleCount      count of people in city
   * @param square           area in square kilometers
   * @param yearOfFoundation year of city foundation
   * @param name             city name
   * @param countryName      name of the country in which the city is located
   */
  public City(int peopleCount, double square, int yearOfFoundation, String name,
      String countryName)
      throws NaturalIntException, NaturalDoubleException, WrongYearException, BlankStringException {

    if (peopleCount < 0) {
      throw new NaturalIntException("People count must be > 0", peopleCount);
    }

    if (square < 0) {
      throw new NaturalDoubleException("square must be > 0", square);
    }

    if (yearOfFoundation < 0) {
      throw new NaturalIntException("Year of foundation must be positive", yearOfFoundation);
    }

    if (yearOfFoundation > currentYear) {
      throw new WrongYearException(
          "Year must be < then current year: %d".formatted(yearOfFoundation), yearOfFoundation);
    }

    if (name.isBlank()) {
      throw new BlankStringException("String is blank");
    }

    if (countryName.isBlank()) {
      throw new BlankStringException("String is blank");
    }

    this.peopleCount = peopleCount;
    this.square = square;
    this.yearOfFoundation = yearOfFoundation;
    this.name = name;
    this.countryName = countryName;
    this.densityOfPeople = density();
  }

  /**
   * Method for string representation
   *
   * @return string with all params
   */
  @Override
  public String toString() {
    return String.format(
        "People count: %s\nSquare: %s\nYear of foundation: %s\nName: %s\nCountry name: %s\nDensity of people: %s",
        peopleCount, square, yearOfFoundation, name, countryName, densityOfPeople);
  }

  /**
   * Method for calculate  immutable value density
   *
   * @return density of people
   */
  private double density() {
    return peopleCount / square;
  }

  /**
   * Getter for people count
   *
   * @return people count
   */
  public long getPeopleCount() {
    return peopleCount;
  }

  /**
   * Setter for people count
   *
   * @param peopleCount count of people
   */
  public void setPeopleCount(int peopleCount) throws NaturalIntException {
    if (peopleCount <= 0) {
      throw new NaturalIntException("People count must be > 0", peopleCount);
    }
    this.peopleCount = peopleCount;
  }

  /**
   * Getter for square
   *
   * @return square
   */
  public double getSquare() {
    return square;
  }

  /**
   * Setter for square
   *
   * @param square square of city in km^2
   */
  public void setSquare(double square) throws NaturalDoubleException {
    if (square <= 0) {
      throw new NaturalDoubleException("square must be > 0", square);
    }
    this.square = square;
  }

  /**
   * Getter for year of foundation
   *
   * @return year of foundation
   */
  public int getYearOfFoundation() {
    return yearOfFoundation;
  }

  /**
   * Setter for year of foundation
   *
   * @param yearOfFoundation year of foundation city
   */
  public void setYearOfFoundation(int yearOfFoundation)
      throws NaturalIntException, WrongYearException {
    if (yearOfFoundation < 0) {
      throw new NaturalIntException("Year of foundation must be positive", yearOfFoundation);
    }

    if (yearOfFoundation > currentYear) {
      throw new WrongYearException(
          "Year must be < then current year: %d".formatted(yearOfFoundation), yearOfFoundation);
    }
    this.yearOfFoundation = yearOfFoundation;
  }

  /**
   * Getter for name of city
   *
   * @return name of city
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for name of city
   *
   * @param name name of city
   */
  public void setName(String name) throws BlankStringException {
    if (name.isBlank()) {
      throw new BlankStringException("String is blank");
    }
    this.name = name;
  }

  /**
   * Getter for country name
   *
   * @return country name were located city
   */
  public String getCountryName() {
    return countryName;
  }

  /**
   * Setter for country name
   *
   * @param countryName country name were located city
   */
  public void setCountryName(String countryName) throws BlankStringException {
    if (countryName.isBlank()) {
      throw new BlankStringException("String is blank");
    }
    this.countryName = countryName;
  }

  /**
   * Getter for density of people
   *
   * @return density of people
   */
  public double getDensityOfPeople() {
    return densityOfPeople;
  }
}
