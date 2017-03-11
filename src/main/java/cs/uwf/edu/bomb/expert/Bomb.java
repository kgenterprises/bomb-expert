package cs.uwf.edu.bomb.expert;

import java.util.Scanner;

public class Bomb {
    private Boolean isSolved;
    private String currentModuleName; //instance variable might not be required here
    private Module theModule;
    private int batteryNo;
    private Boolean hasParallelPort;
    private Boolean hasVowel;
    private Boolean endsWithOdd;

    //might not need to be static
    public static Scanner consoleInput;

    public Bomb() {
        setIsSolved(false);
        setCurrentModuleName("none");
        setTheModule(null);
        setBatteryNo(0);
        setHasParallelPort(false);
        setHasVowel(false);
        setEndsWithOdd(false);
        consoleInput = new Scanner(System.in);

    }

    //working
    public void getBombInfo() {

        //get the batteries
        System.out.println("How many batteries?");
        setBatteryNo(Integer.parseInt(consoleInput.nextLine()));

        //get pp status.
        System.out.println("Parallel Port?");
        if (consoleInput.nextLine().equalsIgnoreCase("yes")) {
            setHasParallelPort(true);
        }

        //find out if serial number contains a vowel
        System.out.println("Has vowel?");
        if (consoleInput.nextLine().equalsIgnoreCase("yes")) {
            setHasVowel(true);
        }

        //Find out if the serial number ends in an odd number
        System.out.println("Serial number ends in an odd number?");
        if (consoleInput.nextLine().equalsIgnoreCase("yes")) {
            setEndsWithOdd(true);
        }

    }

    //working
    public void getModNameFromUser() {
        Boolean goodName = false;
        System.out.println("Please enter the name of the module.");
        String possibleName = consoleInput.nextLine();


        while (!goodName) {
            //If the name provided by the user is one of the module names
            if (possibleName.equalsIgnoreCase("wires") || possibleName.equalsIgnoreCase("button") || possibleName.equalsIgnoreCase("key") || possibleName
                .equalsIgnoreCase("simon") || possibleName.equalsIgnoreCase("first") || possibleName.equalsIgnoreCase("memory") || possibleName
                .equalsIgnoreCase("done")) {

                //a good module name was received
                goodName = true;

                //Set the name of the current module being solved. this instance variable might be removed later
                setCurrentModuleName(possibleName);
            } else {
                System.out.println("Invalid module name, try again.");

                //get the module name from console again
                possibleName = consoleInput.nextLine();
            }
        }


    }

    //testing
    public Module getModInfo() {

        //if the wires module needs to be solved...
        if (getCurrentModuleName().equalsIgnoreCase("wires")) {
            //create wire object
            Wires theWires = new Wires();

            //set the flag if the last digit of the serial number is odd
            theWires.setEndsOdd(getEndsWithOdd());

            //get the valid number of wires to be user
            System.out.println("input number of wires\n");
            int wireNo = Integer.parseInt(consoleInput.nextLine());
            while (wireNo < 3 || wireNo > 6) {
                System.out.println("Wires must be 3, 4, 5, or 6. please try again");
                wireNo = Integer.parseInt(consoleInput.nextLine());
            }
            theWires.setWireCount(wireNo);


            //get the colors until the arraylist size matches total wires
            System.out.println("provide colors for each wire from top to bottom");
            String colorToTest = "no color selected";
            while (theWires.getWireColors().size() < theWires.getWireCount()) {
                System.out.print("input color: ");
                colorToTest = consoleInput.next();
                if (theWires.goodColorToAdd(colorToTest)) {
                    theWires.getWireColors().add(colorToTest);
                    consoleInput.nextLine();
                } else {
                    consoleInput.nextLine();
                    System.out.println("Bad Color, try again");
                }
            }

            //set wires as the module to be solved
            return theWires;

        } else if (getCurrentModuleName().equalsIgnoreCase("button")) {
            //get info about button

            //create and return button object

            //***HERE TO KEEP COPILER HAPPY WHILE TESTING***
            Wires notAWire = new Wires();
            return notAWire;
        } else if (getCurrentModuleName().equalsIgnoreCase("key")) {
            //get info about keypad module

            //create and return keypad object

            //***HERE TO KEEP COPILER HAPPY WHILE TESTING***
            Wires notAWire = new Wires();
            return notAWire;
        } else if (getCurrentModuleName().equalsIgnoreCase("simon")) {
            //get info about simon module

            //create and return simon object

            //***HERE TO KEEP COPILER HAPPY WHILE TESTING***
            Wires notAWire = new Wires();
            return notAWire;
        } else if (getCurrentModuleName().equalsIgnoreCase("first")) {
            //get info about first module

            //create and return first object

            //***HERE TO KEEP COPILER HAPPY WHILE TESTING***
            Wires notAWire = new Wires();
            return notAWire;
        } else if (getCurrentModuleName().equalsIgnoreCase("memory")) {
            //get info about memory module

            //create and return memory object

            //***HERE TO KEEP COPILER HAPPY WHILE TESTING***
            Wires notAWire = new Wires();
            return notAWire;
        }
        //bomb has been solved or has exploded
        else if (getCurrentModuleName().equalsIgnoreCase("done")) {
            //set flag to stop solving modules

            //***HERE TO KEEP COPILER HAPPY WHILE TESTING***
            Wires notAWire = new Wires();
            return notAWire;
        } else {
            //incorrect,


            //***HERE TO KEEP COPILER HAPPY WHILE TESTING***
            Wires notAWire = new Wires();
            return notAWire;
        }

    }


    //********************************Access Methods*****************
    public Boolean getIsSolved() {
        return isSolved;
    }


    public Module getTheModule() {
        return theModule;
    }

    public int getBatteryNo() {
        return batteryNo;
    }

    public String getCurrentModuleName() {
        return currentModuleName;
    }

    public Boolean getHasParallelPort() {
        return hasParallelPort;
    }

    public Boolean getHasVowel() {
        return hasVowel;
    }

    public Boolean getEndsWithOdd() {
        return endsWithOdd;
    }

    //******************************Mutator Methods********************
    public void setIsSolved(Boolean status) {
        isSolved = status;
    }

    public void setCurrentModuleName(String modName) {
        currentModuleName = modName;
    }

    public void setTheModule(Module subModClassName) {
        theModule = subModClassName;
    }

    public void setBatteryNo(int newBatNo) {
        batteryNo = newBatNo;
    }

    public void setHasParallelPort(Boolean status) {
        hasParallelPort = status;
    }

    public void setHasVowel(Boolean status) {
        hasVowel = status;
    }

    public void setEndsWithOdd(Boolean status) {
        endsWithOdd = status;
    }

}
