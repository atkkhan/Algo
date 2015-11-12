
public class KMP {

	private String pattern;
    private int[] next;

    // create Knuth-Morris-Pratt NFA from pattern
    public void KMPplus(String pattern) {
        this.pattern = pattern;
        next = new int[pattern.length()];
        int j = 0, i = 1;
        next[0] = 0;
        while (i < pattern.length()) {
        	if (pattern.charAt(i) == pattern.charAt(j)) {
            	next[i] = j + 1;
            	++i;
            	++j;
        	}
            else if (j > 0) {                                           
            	j = next[j - 1];
            	next[i] = 0;
            }
            else{
            	next[i] = 0;
            	++i;
            }
        }
       
        i = 0;
        while(i < next.length){
        	System.out.print(next[i] + ", ");
        	++i;
        }
    }
    
    
    //abababa
    //  ababaca
    // return offset of first occurrence of text in pattern (or N if no match)
//    // simulate the NFA to find match
    public int search(String text) {
        int M = pattern.length();
        int N = text.length();
        int i = 0, j = 0;
        
        while(i < N){
        	if(text.charAt(i) == pattern.charAt(j)){
        		if (j == M - 1)
        			return i - (M - 1);
        		else{
            		++i;
            		++j;
        		}
        	}
        	else if (j > 0){
        		j = next[j - 1];
        	}
        	else{
        		i++;
        	}
        	
        }    
        return -1;
    }


    // test client
    public static void main(String[] args) {
        KMP kmp = new KMP();
        kmp.KMPplus("ababaca");
        System.out.println(kmp.search(""));
        System.out.println(kmp.search("abababaxa"));
        System.out.println(kmp.search(  "ababaca"));
        System.out.println(kmp.search("abababaca"));
    }
}
