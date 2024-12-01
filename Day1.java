import java.io.*;
import java.util.Arrays;

class Day1
{
   public static int[][] getData(String filePath) throws Exception {

        // File path is passed as parameter
        File file = new File(filePath);

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        int count = 0;
        String[] tempPair = new String[2];
        int[][] lists = new int[2][1000];
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            
            tempPair = st.split("   ");

            lists[0][count] = Integer.parseInt(tempPair[0]);
            lists[1][count] = Integer.parseInt(tempPair[1]);

            count++;

        }

        return lists;

   }

   public static int distance(int[][] lists) {

        int rollingDistanceSum = 0;

        for (int i = 0; i < lists[0].length; i++) {
            System.out.println(lists[1][i] - lists[0][i]);
            System.out.println(rollingDistanceSum);
            rollingDistanceSum = Math.abs(lists[1][i] - lists[0][i]) + rollingDistanceSum;
            System.out.println(rollingDistanceSum);
        }

        return rollingDistanceSum;

   }

   public static void main(String[] args) throws Exception
   {
        int[][] lists = getData("C:\\Users\\Nick\\Desktop\\AoC24\\data\\input.txt");

        Arrays.sort(lists[0]);
        Arrays.sort(lists[1]);


        System.out.println("\n\n");
        System.out.println(distance(lists));
   }

};