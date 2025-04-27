import java.util.ArrayList;
import java.util.HashMap;

public class Cognizant {
    public static ArrayList<Integer> combination(String str)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<str.length();i++)
        {
            result.add(Character.getNumericValue(str.charAt(i)));
        }

        for(int i=0;i<str.length()-1;i++)
        {
            result.add(Integer.parseInt(str.substring(i,i+2)));
        }
        return result;
    }

    public static void check(String str)
    {
        HashMap<Integer,Character> map = new HashMap<>();
        int count =0;
        ArrayList<Integer> arr = combination(str);
        for (int element: arr) {
            if (element <= 26) {
                if (map.containsKey(element)) {
                    count++;
                } else {
                    int ascii = 96  + element;
                    map.put(element, (char) ascii);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(map);
    }

    public static void main(String[] args)
    {
        String str = "226";
        check(str);
    }
}
