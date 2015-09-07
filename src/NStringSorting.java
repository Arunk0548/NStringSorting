import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Arun Kumar
 */
public class NStringSorting {

    public NStringSorting() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("StringItems.txt"));
            String itemCount = br.readLine();

            int N = 0;
            if (itemCount != null) {
                N = Integer.parseInt(itemCount);
            } else {
                System.out.println("Invalid number of items.");
                return;
            }

            if (!(N >= 1 && N <= 5000)) {
                System.out.println("Invalid number of items. Number of Items(N)should be 1 ≤ |N| ≤ 5000");
                return;
            }

            String itemName = br.readLine();
            int Count = 0;
            String[] unsortedArray = new String[N];
            while (itemName != null && Count < N) {
                if (!(itemName.length() >= 1 && itemName.length() <= 100)) {
                    System.out.println(itemName);
                    System.out.println("Invalid lenght of String, it should be 1 ≤ |Si| ≤ 100 ");
                    return;
                }
                unsortedArray[Count] = itemName;
                itemName = br.readLine();
                Count++;
            }

            if (!(Count == N)) {
                System.out.println("Input number of items are " + N + " and acutal given items are " + Count + ", Input items numbers and given items count should be same");
                return;
            }

            new SortStringsArray(unsortedArray);

        } catch (NumberFormatException ex) {
            System.out.println("Invalid number of items.It must be a number and number of Items(N)should be 1 ≤ |N| ≤ 5000");
        } catch (IOException ex) {
            System.out.println("Somthing went wrong, please check input file content.");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new NStringSorting();

    }

}
