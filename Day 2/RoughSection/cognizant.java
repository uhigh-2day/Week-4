import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class cognizant {
    public static void check(String string) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] str = string.split(" ");
        for(String word : str) 
        {
            int sum = 0;
            for(int i = 0; i<word.length();i++)
            {
                sum += (int) word.charAt(i);
            }
            map.put(word,sum);
        }
        int maxSum = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue()>maxSum)
            {
                maxSum = entry.getValue();
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(entry.getValue()==maxSum)
            {
                System.out.println(entry.getKey());
            }
        }
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        check(string);

        scanner.close();
    }
}