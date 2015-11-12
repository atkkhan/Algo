import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class swap {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         
        int num = 0;
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextInt()){
            num = scan.nextInt();
            scan.nextLine();
        }
        String[] strs = new String[num];
        int i = 0;
        ///if(scan.hasNextLine()){}
        while(i < num ){
        	if(scan.hasNextLine())
            strs[i] = scan.nextLine();
            ++i;
        }
        System.out.println(gemElements(strs));
    }
    
    public static int gemElements(String[] strs){
        if(strs.length == 0)
            return 0;
        int i = 0;
        String track = strs[i];
        Set<Character> set = new HashSet<Character>();
        for(int j = 0; j < track.length(); ++j){
            set.add(track.charAt(j));
        }
        Set<Character> nextSet = new HashSet<Character>();
        ++i;
        while(i < strs.length){
            
            track = "";
            for(int j = 0; j < strs[i].length(); ++j){     
                if(set.contains(strs[i].charAt(j)) ){
                    nextSet.add(strs[i].charAt(j));
                }
            }
            set = nextSet;
            ++i;
        }
        return nextSet.size();
    }
}