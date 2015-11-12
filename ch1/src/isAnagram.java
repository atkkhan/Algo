import java.util.HashMap;
import java.util.Map;


public class isAnagram {

	public static void main(String[] args ){
		System.out.println(isAnagram("maxx","maax"));
		System.out.println(isAnagram("maxx","mxax"));
		System.out.println(isAnagram("maxx1","maax"));
		System.out.println(isAnagram("god","dog"));
	}
	

 public static boolean isAnagram(String s1, String s2){

    if(s1.length() != s2.length())
        return false;

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    
    int i = 0;
    while(i < s1.length()){
        char c = s1.charAt(i);
        if(!map.containsKey(c)){
            map.put(c, 1);
        }
        else{
            map.put(c, map.get(c) + 1);
        }
        i++;
    }
    i = 0;
    while (i < s2.length()){
        char c = s2.charAt(i);
        if(map.containsKey(c)){
            Integer value = map.get(c);
            if(value == 0)
                return false;
            else {
                map.put(c, value - 1);
            }
        }
        else{
            return false;
        }
        ++i;
    }
    return true;
}
 
}