import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class for terminal UI
 */
class Menu {

  /**
   * List of cities
   */
  private final ArrayList<City> citiesList = new ArrayList<>();

  /**
   * Start UI
   */
  public void start() {
    int choice;

    do {
      printMenu();
      choice = Input.intInput();

      switch (choice) {
        case 1:
          try {
            citiesList.add(new City());
          } catch (NaturalIntException | NaturalDoubleException | WrongYearException |
                   BlankStringException ignored) {}
          System.out.println("Add empty city!");
          break;
        case 2:
          try {
            addParamsCity();
          } catch (NaturalIntException | NaturalDoubleException | WrongYearException | BlankStringException e) {
            try {
              throw new ConstructorException("Incorrect parameters in constructor " + e.getMessage());
            } catch (ConstructorException ex) {
              System.out.println(ex.getMessage());
            }
          }
          break;
        case 3:
          if (citiesList.isEmpty()) {
            System.out.println("Array is empty!");
            break;
          }
          System.out.println("Choose index of element:");
          printArray();
          int index = Input.intInput();
          if (index < 0 || index > citiesList.size() - 1) {
            System.out.println("Index out of bounds!");
          }
          editCities(index);
          break;
        case 4:
//          if (citiesList.isEmpty()) {
//            System.out.println("Array is empty!");
//            break;
//          }
          assert !citiesList.isEmpty(): "Array is empty!";
          printArray();
          break;
        case 5:
//          if (citiesList.isEmpty()) {
//            System.out.println("Array is empty");
//            break;
//          }
          assert !citiesList.isEmpty(): "Array is empty!";
          sortCities();
          break;
        default:
          if (choice != 6) {
            System.err.println("Incorrect value!");
          }
      }
    } while (choice != 6);
  }

  /**
   * Method for print menu
   */
  private void printMenu() {
    System.out.println("""
        -----MENU-----
        1. Add empty city to array
        2. Add city to array with params
        3. Edit city
        4. Print all cities
        5. Sort cities
        6. Exit
        --------------
        """);
  }

  /**
   * Method for print fields of city
   */
  private void printFields() {
    System.out.println("""
        1. People count
        2. Square
        3. Year of foundation
        4. Name
        5. Country name
        6. Density of people
        """);
  }

  /**
   * Method for print citiesArray
   */
  private void printArray() {
    for (int i = 0; i < citiesList.size(); i++) {
      System.out.println("Index: " + i);
      System.out.println("----");
      System.out.println(citiesList.get(i));
      System.out.println("----\n");
    }
  }

  /**
   * Method for sorting by selected field
   */
  private void sortCities() {
    printFields();

    int choice = Input.intInput();
    switch (choice) {
      case 1 -> citiesList.sort(Comparator.comparing(City::getPeopleCount));
      case 2 -> citiesList.sort(Comparator.comparing(City::getSquare));
      case 3 -> citiesList.sort(Comparator.comparing(City::getYearOfFoundation));
      case 4 -> citiesList.sort(Comparator.comparing(City::getName));
      case 5 -> citiesList.sort(Comparator.comparing(City::getCountryName));
      case 6 -> citiesList.sort(Comparator.comparing(City::getDensityOfPeople));
      default -> System.out.println("Incorrect input!");
    }
  }

  /**
   * Method for editing field by selected city
   *
   * @param index index of city in array
   */
  private void editCities(int index) {
    City city = citiesList.get(index);

    printFields();

    int field;
    field = Input.intInput();

    switch (field) {
      case 1 -> {
        System.out.println("Value: " + city.getPeopleCount());
        printEnter("people count");
        try {
          city.setPeopleCount(Input.intInput());
        } catch (NaturalIntException e) {
          System.out.println(e.getMessage());
        }
      }
      case 2 -> {
        System.out.println("Value: " + city.getSquare());
        printEnter("square");
        try {
          city.setSquare(Input.doubleInput());
        } catch (NaturalDoubleException e) {
          System.out.println(e.getMessage());
        }
      }
      case 3 -> {
        System.out.println("Value: " + city.getYearOfFoundation());
        printEnter("year of foundation");
        try {
          city.setYearOfFoundation(Input.intInput());
        } catch (NaturalIntException | WrongYearException e) {
          System.out.println(e.getMessage());
        }
      }
      case 4 -> {
        System.out.println("Value: " + city.getName());
        printEnter("city name");
        try {
          city.setName(Input.stringInput());
        } catch (BlankStringException e) {
          System.out.println(e.getMessage());
        }
      }
      case 5 -> {
        System.out.println("Value: " + city.getCountryName());
        printEnter("country name");
        try {
          city.setCountryName(Input.stringInput());
        } catch (BlankStringException e) {
          System.out.println(e.getMessage());
        }
      }
      case 6 -> {
        System.out.println("Value: " + city.getDensityOfPeople());
        System.out.println("This value immutable");
      }
      default -> System.out.println("Incorrect input!");
    }
  }

  /**
   * Method for add city in array with params
   */
  private void addParamsCity()
      throws NaturalIntException, NaturalDoubleException, WrongYearException, BlankStringException {
    printEnter("people count");
    int peopleCount = Input.intInput();
    printEnter("square in km^2");
    double square = Input.doubleInput();
    printEnter("year of foundation");
    int yearOfFoundation = Input.intInput();
    printEnter("city name");
    String name = Input.stringInput();
    printEnter("country name");
    String countryName = Input.stringInput();
    citiesList.add(new City(peopleCount, square, yearOfFoundation,
        name, countryName));
  }

  /**
   * Method for print enter message
   *
   * @param value value that you want to enter
   */
  private void printEnter(String value) {
    System.out.println("Enter " + value + ":");
  }
}
