package ReadFiles;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner; // Import the Scanner class to read text files

enum UserInput
{
    INPUT_FILE_PATH,
    OUTPUT_FILE_NAME,
    SORT
}


public class readFiles
{
    static final String dataDelimiter = "#";
    private static final String defaultInputFile = "\\\\transfer\\transfer\\ftr\\Aufgaben\\array2\\Aufgabe1.txt";

    public static void main(String[] args)
    {
        try
        {
            String inputFilePath;
            String outputFilePath;
            String sortedBy;


            // ask user for input file path
            do {
                 inputFilePath = GetUserInput(UserInput.INPUT_FILE_PATH);
            } while (!isValidFile(inputFilePath, UserInput.INPUT_FILE_PATH));

            String[][] table = getFileContent(inputFilePath);
            // ask user for output file name
            do {
                outputFilePath = GetUserInput(UserInput.OUTPUT_FILE_NAME);
            } while (!isValidFile(outputFilePath, UserInput.OUTPUT_FILE_NAME));

            saveTableInCsv(table, "data\\" + outputFilePath + ".csv");
            do {
                sortedBy = GetUserInput(UserInput.SORT);
                if (!sortedBy.isEmpty())
                    SaveDataSortedByInCsv(table, sortedBy);

            } while (!sortedBy.equals("R") && !sortedBy.equals("E") && !sortedBy.equals("L") && !sortedBy.isEmpty());

            SaveRegionDataInCsv(table);
            //PrintTable(table);


            // Additionale Tasks:
            AdditionaleTasks(table);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }



    /**
     * Saves the data sorted by the specified criteria (region, land, or population)
     *
     * @param table A 2D array ({@code String[][]}) containing the data to be sorted and saved
     * @param sortedBy A string representing the criteria by which to sort the data:
     *                 - "L" for sorting by Land (column 0),
     *                 - "R" for sorting by Region (column 1),
     *                 - "E" for sorting by Einwohnerzahl (column 2).
     * @throws Exception If an error occurs while saving the data or sorting
     */
    private static void SaveDataSortedByInCsv(String[][] table, String sortedBy) throws Exception {

        String filePath = "data\\sorted\\sorted_by_"+sortedBy+".csv";
        String[][] sortedTable = new String[table.length][table[0].length];

        int sortIndex;
        if (sortedBy.equals("L"))
            sortIndex = 0;
        else if (sortedBy.equals("R"))
            sortIndex = 1;
        else
            sortIndex = 2;

        for (int i = 0; i < table.length; i++) {
            sortedTable[i] = table[i].clone();
        }

        for (int i = 0; i < sortedTable.length - 1; i++)
        {
            int minIndex = i;
            for (int k = i + 1; k < sortedTable.length; k++)
            {
                if (sortedTable[k][sortIndex].compareTo(sortedTable[minIndex][sortIndex]) < 0)  // a < b
                    minIndex = k;
            }
            String[] temp = sortedTable[i];
            sortedTable[i] = sortedTable[minIndex];
            sortedTable[minIndex] = temp;
        }
        saveTableInCsv(sortedTable, filePath);
        System.out.println("Saved sorted Table here: " + filePath);
    }



    /**
     * Saves region-specific data into CSV files
     *
     * @param table A 2D array ({@code String[][]}) containing the data to be processed and saved
     * @throws Exception If an error occurs while processing or saving the CSV files
     */
    private static void SaveRegionDataInCsv(String[][] table) throws Exception {
        Object[] regionData = getDataByRegion(table);

        String[][] countCountries = (String[][]) regionData[0];
        String[][][] tableSortedByRegion = (String[][][]) regionData[1];

        for (int k = 0; k < tableSortedByRegion.length; k++)
        {
            String filePath = "data\\regions\\"+tableSortedByRegion[k][0][1];
            saveTableInCsv(tableSortedByRegion[k], filePath, true, Integer.parseInt(countCountries[k][1]), true);
            System.out.println("Saved sorted Table here: " + filePath);
        }
        System.out.println("d");
    }



    /**
     * Checks whether a given file path is valid based on the specified file type
     *
     * @param filePath The path of the file to validate
     * @param fileType The type of file being checked (either input or output)
     * @return {@code true} if the file is valid, otherwise {@code false}
     */
    private static boolean isValidFile(String filePath, UserInput fileType)
    {
        File file = new File(filePath);
        if (fileType == UserInput.INPUT_FILE_PATH && (!file.canRead() || !file.exists()))
        {
            System.out.println("\nCan't read file or doesn't exist: " + filePath);
            return false;
        }
        file = new File("data\\"+filePath);
        if (fileType == UserInput.OUTPUT_FILE_NAME && file.exists())
            System.out.print("File '" + filePath + "' already exists in data. Gets overridden.");
        return true;
    }



    /**
     * Retrieves user input based on the specified input type
     *
     * @param userInput The type of input to request from the user
     * @return The user-provided input as a {@code String}. If sorting is disabled, an empty string is returned
     */
    private static String GetUserInput(UserInput userInput)
    {
        Scanner sc = new Scanner(System.in);

        switch (userInput)
        {
            case INPUT_FILE_PATH:
                System.out.print("\nPlease provide the input file Path\n\t[press d for default] - default file: " + defaultInputFile + "\n: ");
                String input = sc.nextLine();
                return input.equals("d") ? defaultInputFile : input;
            case OUTPUT_FILE_NAME:
                System.out.print("\nPlease provide the output file Name: ");
                return sc.nextLine();
            case SORT:
                String answer;
                do {
                    System.out.print("\nDo you want to sort the Data? [y/n]: ");
                    answer = sc.nextLine();
                } while (!answer.equals("y") && !answer.equals("n"));
                if (answer.equals("n")) return "";
                do {
                    System.out.print("Sort by:\n\t[R] Region\n\t[E] Einwohnerzahl\n\t[L] Land\n\t: ");
                    answer = sc.nextLine();
                } while (!answer.equals("R") && !answer.equals("E") && !answer.equals("L"));
                return answer;
        }
        return "";
    }



    /**
     * Reads the content of a file and converts it into a 2D table.
     *
     * @param fileName The name of the file to be read
     * @return A 2D array ({@code String[][]}) containing the file content, structured as rows and columns
     * @throws Exception If the file cannot be read or an unexpected error occurs
     */
    private static String[][] getFileContent(String fileName) throws Exception
    {
        try
        {
            File file = new File(fileName);
            if (!file.canRead())
                throw new Exception("Missing reading permissions for file: '" + fileName + "'.");

            Scanner sc = new Scanner(file);

            int columns = 0, rows = 0;
            String data = "";
            while (sc.hasNextLine())
            {
                data += sc.nextLine() + '\n';
                if (rows == 0)
                {
                    columns = countOccurrences(data, dataDelimiter);
                    if (columns != 3)
                        throw new Exception("Invalid amount of columns. Counted: " + columns + " expected 3. Make sure to use a delimiter in the input file and to adjust the dataDelimiter in the program.");
                }
                rows++;
            }

            return initTable(data, rows, columns);
        }
        catch (Exception ex)
        {
            throw new Exception("Unexpected Error: " + ex);
        }
    }



    /**
     * Counts the occurrences of a specific substring in a given string
     *
     * @param data input string in which occurrences are counted
     * @param c substring to count occurrences of
     * @return number of times the substring appears in the input string
     */
    private static int countOccurrences(String data, String c)
    {
        return (data.length() - data.replace(c, "").length()) + 1;
    }



    /**
     * creates a 2D table from a given data string, splitting values by column and row separators
     *
     * @param data containing the table data, where columns are separated by {@code dataDelimiter} and rows by '\n'
     * @param rows amount of rows for the table
     * @param columns amount of columns for the table
     * @return A 2D array (table) containing the parsed data
     */
    private static String[][] initTable(String data, int rows, int columns)
    {
        String[][] table = new String[rows][columns];

        int startPos = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int k = 0; k < columns; k++)
            {
                int nextColumnSeparator = data.indexOf(dataDelimiter, startPos+1); //lol#lol2#hehe\n
                int nextRowSeparator = data.indexOf('\n', startPos+1);          //lol#lol2#hehe\n
                if (nextRowSeparator < nextColumnSeparator || nextColumnSeparator == -1)
                {
                    table[i][k] = data.substring(startPos, nextRowSeparator);
                    startPos = nextRowSeparator+1;
                }
                else
                {
                    table[i][k] = data.substring(startPos, nextColumnSeparator);
                    startPos = nextColumnSeparator+1;
                }
            }
        }
        return table;
    }



    /**
     * Saves a 2D array into a CSV file
     *
     * @param table data to be saved
     * @param filePath destination file path
     * @throws Exception If an error occurs while writing
     */
    private static void saveTableInCsv(String[][] table, String filePath) throws Exception
    {
        saveTableInCsv(table, filePath, false, 0, false);
    }

    /**
     * Saves a 2D array into a CSV file with additional options
     *
     * @param table data to be saved.
     * @param filePath destination file path
     * @param onlyShowCountries If true, only country names are saved
     * @param amountCountries Total countries count to be appended if {@code printCountCountry} is true
     * @param printCountCountry If true, appends the total number of countries
     * @throws Exception If an error occurs while writing
     */
    private static void saveTableInCsv(String[][] table, String filePath, boolean onlyShowCountries, int amountCountries, boolean printCountCountry) throws Exception
    {
        Files.createDirectories(Paths.get(filePath).getParent());

        try (FileWriter writer = new FileWriter(filePath))
        {
            for (String[] strings : table)
            {
                if (strings[0] == null || strings[0].isEmpty())
                    continue;
                if (onlyShowCountries)
                    writer.append(strings[0]);
                else
                {
                    writer.append(strings[0]).append(",");
                    writer.append(strings[1]).append(",");
                    writer.append(strings[2]);
                }
                writer.append("\n");
            }
            if (printCountCountry)
                writer.append("\nTotal Countries: ").append(String.valueOf(amountCountries));
            writer.flush();
        }
        catch (Exception e)
        {
            throw new Exception("Unable to Write to file: " + filePath);
        }
    }


    /**
     * Organizes data from a table into regions and counts the number of countries per region
     *
     * @param table 2D array containing country data
     * @return An array containing two elements:
     *         1. 2D array with the count of countries per region
     *         2. 3D array where each region's countries are stored
     */
    private static Object[] getDataByRegion(String[][] table)
    {
        int amountRegions = 11;
        String[] regions = getRegions(table, amountRegions);
        String[][][] lol = new String[amountRegions][table.length][table[0].length];
        String[][] countCountries = new String[amountRegions][2];

        int y, c = 0;
        for (int i = 0; i < regions.length; i++)
        {
            y = 0;
            for (int k = 1; k < table.length; k++)
            {
                if (table[k][1].equals(regions[i]))
                {
                    lol[i][y][0] = table[k][0];// y = y +1
                    lol[i][y][1] = table[k][1];
                    lol[i][y++][2] = table[k][2];
                    c = (countCountries[i][1] == null || countCountries[i][1].isEmpty()) ? 0 : Integer.parseInt(countCountries[i][1]);
                    countCountries[i][1] = String.valueOf(c+1);
                    countCountries[i][0] = table[k][1];
                }
            }
        }
        return new Object[] { countCountries, lol };
    }


    /** function extracts all different regions from data array provided
     *
     * @param table contains listed countries, region and population
     * @param amountRegions amount of different regions
     * @return Array of different regions
     */
    private static String[] getRegions(String[][] table, int amountRegions)
    {
        String[] regions = new String[amountRegions];
        boolean inserted;

        int x = 0;
        for (int i = 1; i < table.length; i++)
        {
            inserted = false;
            for (String region : regions)
            {
                if (Objects.equals(table[i][1], region) || table[i][1].equals("Region"))
                {
                    inserted = true;
                    break;
                }
            }
            if (!inserted)
                regions[x++] = table[i][1];
        }
        return regions;
    }



    private static void PrintTable(String[][] table)
    {
        for (String[] strings : table)
        {
            for (int k = 0; k < table[0].length; k++)
            {
                System.out.printf("%-20s\t", strings[k]);
            }
            System.out.println();
        }
    }



    private static void AdditionaleTasks(String[][] table)
    {
        Object[] regionData = getDataByRegion(table);
        String[][] countCountries = (String[][]) regionData[0];

        // 10. Es sollen die Regionen mit Anzahl der Länder in einer sortierten Reihenfolge ausgegeben werden.
        AdditionalTasks.PrintSortedRegionsWithCountryCount(countCountries);

        // 11. Es soll das Land mit der größten Bevölkerungszzahl ausgegeben werden
        AdditionalTasks.PrintCountryWithLargestPopulation(table);

        // 12. & 13. Es soll das Land mit dem längsten/kürzesten Namen ausgegeben werden
        AdditionalTasks.PrintCountryWithNameLengths(table);
    }
}
