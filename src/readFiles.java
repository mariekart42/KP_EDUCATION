import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner; // Import the Scanner class to read text files

enum UserInput
{
    INPUT_FILE_PATH,
    OUTPUT_FILE_NAME,
    SORT
}

enum Task
{
    SORTED_REGIONS,
}


public class readFiles
{
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
                if (sortedBy.equals("R") || sortedBy.equals("E") || sortedBy.equals("L"))
                    SaveDataSortedByInCsv(table, sortedBy);

            } while (!sortedBy.equals("R") && !sortedBy.equals("E") && !sortedBy.equals("L") && !sortedBy.isEmpty());

            SaveRegionDataInCsv(table);
            //PrintTable(table);


            // Additionale Tasks:
            // 10. Es sollen die Regionen mit Anzahl der Länder in einer sortierten Reihenfolge ausgegeben werden.
            //PrintSortedRegionsWithCountryCount(table);
            AdditionaleTasks(table);




        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void AdditionaleTasks(String[][] table)
    {
        Object[] regionData = getDataByRegion(table);
        String[][] countCountries = (String[][]) regionData[0];
        String[][][] tableSortedByRegion = (String[][][]) regionData[1];

        // 10. Es sollen die Regionen mit Anzahl der Länder in einer sortierten Reihenfolge ausgegeben werden.
        PrintSortedRegionsWithCountryCount(countCountries);

        // 11. Es soll das Land mit der größten Bevölkerungszzahl ausgegeben werden
        PrintCountryWithLargestPopulation(table);


        PrintCountryWithLargestName(table);
    }


    /* 10. Es sollen die Regionen mit Anzahl der Länder in einer sortierten Reihenfolge ausgegeben werden. */
    private static void PrintSortedRegionsWithCountryCount(String[][] countCountries)
    {
        String[][] sortRegions = new String[countCountries.length-1][countCountries[0].length];
        for (int i = 1; i < countCountries.length; i++) {
            sortRegions[i-1] = countCountries[i].clone();
        }

        for (int i = 0; i < sortRegions.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < sortRegions.length; j++)
            {
                if (sortRegions[j][0].compareTo(sortRegions[minIndex][0]) < 0)
                    minIndex = j;
            }

            String[] temp = sortRegions[i];
            sortRegions[i] = sortRegions[minIndex];
            sortRegions[minIndex] = temp;
        }

        System.out.println("\nSORTED REGIONS WITH AMOUNT OF COUNTRIES:");
        for (String[] countCountry : sortRegions)
        {
            System.out.printf("Region: %-25s%s%s\n", countCountry[0], "Amount of countries: ", countCountry[1]);
        }

    }


    /* 11. Es soll das Land mit der größten Bevölkerungszzahl ausgegeben werden */
    private static void PrintCountryWithLargestPopulation(String[][] table)
    {
        int[] population = new int[2];
        for (int i = 1; i < table.length; i++)
        {
            if (Integer.parseInt(table[i][2]) > population[0])
            {
                population[0] = i;
                population[1] = Integer.parseInt(table[i][2]);
            }
        }
        System.out.println("\nCOUNTRY WITH LARGEST POPULATION:");
        System.out.println("--> " + table[Integer.parseInt(String.valueOf(population[0]))][0] + " - with a population of: " + population[1]);
    }



    /* 12. Es soll das Land mit dem längsten Namen ausgegeben werden */
    private static void PrintCountryWithLargestName(String[][] table)
    {
        if (table == null || table.length == 0)
        {
            System.out.println("Table is empty.");
            return;
        }

        int longestIndex = 1;
        for (int i = 1; i < table.length; i++)
        {
            if (table[i][0].length() > table[longestIndex][0].length())
                longestIndex = i;
        }
        System.out.println("\nCOUNTRY WITH LONGEST NAME:\n--> " + table[longestIndex][0] + " - with " + table[longestIndex][0].length() + " letters.");
    }


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
                if (sortedTable[k][sortIndex].compareTo(sortedTable[minIndex][sortIndex]) < 0)
                    minIndex = k;
            }
            String[] temp = sortedTable[i];
            sortedTable[i] = sortedTable[minIndex];
            sortedTable[minIndex] = temp;
        }
        saveTableInCsv(sortedTable, filePath);
        System.out.println("Saved sorted Table here: " + filePath);
    }



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



    private static boolean isValidFile(String filePath, UserInput fileType)
    {
        File file = new File(filePath);
        if (fileType == UserInput.INPUT_FILE_PATH && (!file.canRead() || !file.exists()))
            return false;
        file = new File("data\\"+filePath);
        if (fileType == UserInput.OUTPUT_FILE_NAME && file.exists())
            System.out.print("File '" + filePath + "' already exists in data. Gets overridden.");
        return true;
    }



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
                    columns = countOccurrences(data, "#");
                rows++;
            }

            return initTable(data, rows, columns);
        }
        catch (Exception ex)
        {
            throw new Exception("Unexpected Error: " + ex);
        }
    }



    private static String[][] initTable(String data, int rows, int columns)
    {
        String[][] table = new String[rows][columns];

        int startPos = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int k = 0; k < columns; k++)
            {
                int nextColumnSeparator = data.indexOf('#', startPos+1);
                int nextRowSeparator = data.indexOf('\n', startPos+1);
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



    private static void saveTableInCsv(String[][] table, String filePath) throws Exception
    {
        saveTableInCsv(table, filePath, false, 0, false);
    }

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



    private static Object[] getDataByRegion(String[][] table)
    {
        int amount_regions = getAmountOfRegions(table);
        String[] regions = getRegions(table, amount_regions);
        String[][][] lol = new String[amount_regions][table.length][table[0].length];
        String[][] countCountries = new String[amount_regions][2];

        int y, c = 0;
        for (int i = 0; i < regions.length; i++)
        {
            y = 0;
            for (int k = 1; k < table.length; k++)
            {
                if (table[k][1].equals(regions[i]))
                {
                    lol[i][y][0] = table[k][0];
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


    private static int getAmountOfRegions(String[][] table)
    {
        // TODO
        return 11;
    }


    private static int countOccurrences(String data, String c)
    {
        return (data.length() - data.replace(c, "").length()) + 1;
    }

    private static void PrintTable(String[][] table)
    {
        for (int i = 0; i < table.length; i++)
        {
            for (int k = 0; k < table[0].length; k++)
            {
                System.out.printf("%-20s\t", table[i][k]);
            }
            System.out.println();
        }
    }
}
