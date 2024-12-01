import java.io.*;
import java.util.Arrays;

class Day1
{
   public static int[][] getData(String filePath) throws Exception {

        // File path is passed as parameter
        File file = new File(filePath);

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a variables for building the lists
        String st;
        int count = 0;
        String[] tempPair = new String[2];
        int[][] lists = new int[2][1000];


        // Condition holds true till
        // there is no character in a string
        while ((st = br.readLine()) != null) {
            
            // Split the line into two numbers
            tempPair = st.split("   ");

            // Assign each number to the left and right lists
            lists[0][count] = Integer.parseInt(tempPair[0]);
            lists[1][count] = Integer.parseInt(tempPair[1]);

            count++;

        }

        return lists;

   }

   public static int distance(int[][] lists) {

        int rollingDistanceSum = 0;

        // Continually add up the distance between the lists
        for (int i = 0; i < lists[0].length; i++) {
            rollingDistanceSum = Math.abs(lists[1][i] - lists[0][i]) + rollingDistanceSum;
        }

        return rollingDistanceSum;

   }

   public static void main(String[] args) throws Exception
   {

        // Get our two lists from the file
        int[][] lists = getData("C:\\Users\\Nick\\Desktop\\AoC24\\data\\input.txt");

        // Sort lists
        Arrays.sort(lists[0]);
        Arrays.sort(lists[1]);

        // Get total distance and print it
        System.out.println("\n");
        System.out.println(distance(lists));
   }

};