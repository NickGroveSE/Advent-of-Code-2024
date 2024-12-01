import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Day1Part2
{
   public static String[][] getData(String filePath) throws Exception {

        // File path is passed as parameter
        File file = new File(filePath);

        // Creating an object of BufferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Declaring a variables for building the lists
        String st;
        int count = 0;
        String[] tempPair = new String[2];
        String[][] lists = new String[2][1000];


        // Condition holds true till
        // there is no character in a string
        while ((st = br.readLine()) != null) {
            
            // Split the line into two numbers
            tempPair = st.split("   ");

            // Assign each number to the left and right lists
            lists[0][count] = tempPair[0];
            lists[1][count] = tempPair[1];

            count++;

        }

        return lists;

   }

   public static void main(String[] args) throws Exception
   {

        // Get our two lists from the file
        String[][] lists = getData("C:\\Users\\Nick\\Desktop\\AoC24\\data\\inputd1p2.txt");

        // Set used to avoid duplicates from left list
        Set<String> keys = new HashSet<String>();

        // Variables for occurrences of left list number and a rolling similarity score
        int keyOccurs;
        int similarityScore = 0;
        for(String key : lists[0]) {

            // Reset occurrences
            keyOccurs = 0;

            // Duplicate check
            if(keys.contains(key)) {
                continue;
            } else {
                keys.add(key);
            }
            

            for(String num : lists[1]) {

                // Add to occurrences if check is passed
                if(num.equals(key)) {
                    keyOccurs++;
                }

            }

            // Calculate individual similarity score and add onto total similarity score
            similarityScore += keyOccurs * Integer.parseInt(key);
            
        }
        System.out.println("\n");
        System.out.println(similarityScore);
        
   }

};
