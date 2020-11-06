// Menu.java
// This class is working to requirement.
package util1228;

import java.util.Scanner;

/**
 *
 * @author Parth Patel.
 */
public class Menu {

    public final int MAX_NUM_OF_OPTIONS = 10;
    public final int WIDTH_OF_WINDOW;
    public final int HEIGHT_OF_WINDOW;
    private String title;
    private final String menuOptions[];

    private int menuOptionsCount;

    /**
     * Constructor.
     *
     * @param menuTitle Title of the menu.
     * @param height Height of the window.
     * @param width Width of the window.
     */
    public Menu(String menuTitle, int height, int width) {
        this.title = menuTitle;
        this.HEIGHT_OF_WINDOW = height;
        this.WIDTH_OF_WINDOW = width;
        menuOptions = new String[MAX_NUM_OF_OPTIONS];
        menuOptionsCount = 0;

    }

    /**
     *
     * @param menuTitle Can set the title as the String menuTitle.
     */
    public void setTitle(String menuTitle) {
        this.title = menuTitle;
    }

    /**
     *
     * @param s String passed by the user as arguments. Enables the user to add
     * options to the menuOptions Array.
     */
    public void addOption(String s) {
        if (menuOptions.length == menuOptionsCount) {
            System.out.println("");
            System.out.println("ERROR cannot add option: " + s);
            System.out.println("The menu is full.");
            System.out.println("");

        } else {
            menuOptions[menuOptionsCount] = s;
            menuOptionsCount++;

        }

    }

    /**
     * Displays the output to the user in the required format.
     */
    public void display() {
        int numberCount = 1;
        //length Of the Longest String
        int longestString = longestStringLength();
        //no of Vertial Spaces to Print
        int verticalSpace = (HEIGHT_OF_WINDOW - 2 - menuOptionsCount) / 2;
        //no of Horizontal spaces to print 
        int horizontalSpace = ((WIDTH_OF_WINDOW / 2) - (longestString / 2));
        //length of the title String & the no of spaces before the title. 
        int titleLength = title.length();
        int spaceBfrTitle = ((WIDTH_OF_WINDOW / 2) - (titleLength / 2));

        //prints vertical space.
        for (int i = 0; i < verticalSpace; i++) {
            System.out.println();

        }

        //prints the spaces before title and title itself.
        for (int i = 0; i < spaceBfrTitle; i++) {
            System.out.print(" ");
        }
        System.out.print(title);
        System.out.println();
        //prints the spaces before menu and the menu itself.
        for (String menuOption : menuOptions) {
            for (int j = 0; j < horizontalSpace; j++) {
                System.out.print(" ");

            }
            if (menuOption != null) {
                System.out.print(numberCount + ". " + menuOption);
                System.out.println();
                numberCount++;
            }
        }

        //prints vertical space after displaying menu.
        for (int i = 0; i < (HEIGHT_OF_WINDOW - verticalSpace); i++) {
            System.out.println();

        }

    }

    /**
     *
     * @return integer that is the number of the option selected
     */
    public int getChoice() {
        Scanner kbd = new Scanner(System.in);

        System.out.print("Enter your choice here: ");
        int choice = kbd.nextInt();
        if (choice <= menuOptionsCount) {
            return choice;

        } else {
            return -1;
        }

    }

    /**
     *
     * @return the length of the largest String in the array.
     */
    private int longestStringLength() {
        int maxLength = 0;
        String longestString = null;
        for (int i = 0; i < menuOptionsCount; i++) {
            if (menuOptions[i].length() > maxLength) {
                longestString = menuOptions[i];
                maxLength = longestString.length();

            }

        }

        return maxLength;
    }
}
