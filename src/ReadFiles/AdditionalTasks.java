package ReadFiles;

public class AdditionalTasks
{

    /* 10. Es sollen die Regionen mit Anzahl der Länder in einer sortierten Reihenfolge ausgegeben werden. */
    public static void PrintSortedRegionsWithCountryCount(String[][] countCountries)
    {
        String[][] sortRegions = new String[countCountries.length-1][countCountries[0].length];
        for (int i = 1; i < countCountries.length; i++) {
            sortRegions[i-1] = countCountries[i].clone();
        }
        String lol;

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
    public static void PrintCountryWithLargestPopulation(String[][] table)
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



    /* 12. & 13. Es soll das Land mit dem längsten/kürzesten Namen ausgegeben werden */
    public static void PrintCountryWithNameLengths(String[][] table)
    {
        if (table == null || table.length == 0)
        {
            System.out.println("Table is empty.");
            return;
        }

        int longestIndex = 0;
        int shortestIndex = 0;

        for (int i = 1; i < table.length; i++)
        {
            int nameLength = table[i][0].length();

            if (nameLength > table[longestIndex][0].length())
                longestIndex = i;
            if (nameLength < table[shortestIndex][0].length())
                shortestIndex = i;
        }

        System.out.println("\nCOUNTRY WITH LONGEST NAME:\n--> " + table[longestIndex][0] +
                " - with " + table[longestIndex][0].length() + " letters.");

        System.out.println("\nCOUNTRY WITH SHORTEST NAME:\n--> " + table[shortestIndex][0] +
                " - with " + table[shortestIndex][0].length() + " letters.");
    }
}
