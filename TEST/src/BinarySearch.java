import java.util.ArrayList;


class T{
	public void p(){System.out.println("p");}
	public void finalize(){System.out.println("finalize...");}
}



public class BinarySearch{

	
	
	
     public static void main(String []args){
    	 
    	 T t = new T();
    	 t.p();
    	 t = null;
    	 System.out.println("nw");
    	// System.gc();
    	 ArrayList<T> list = new ArrayList();
    	 for(int i=0; i < 1000000; ++i)
    		 list.add(new T());
 
//    	 char num = 1;
//    	 switch(num){
// 	 	case 1: 
//	 		System.out.println("o");
//	 	case 2: 
//	 		System.out.println("T");
//	 	case 3: 
//	 		System.out.println("t");break;
//	 	default: 
//	 		System.out.println("f");break;
//    	 	
//    	 
//    	 }
    	 
//    	 
//        int[] a = {10,20,30,40,50,60,70};        
//        System.out.println(bSearch(a, 55, 0, a.length - 1));
//        System.out.println(bSearch(a, 15, 0, a.length - 1));
//        System.out.println(bSearch(a, 35, 0, a.length - 1));
//        System.out.println(bSearch(a, 45, 0, a.length - 1));
//        
    }

     public static int bSearch(int[] array, int data, int start, int end){
    	 if(end == start )
    		 return array[start];
    	 
    	 int mid = start + (end - start) / 2;
         if(array[mid] < data){
             return bSearch(array, data, mid + 1, end);
         }
         else if(array[mid] > data){
             return bSearch(array, data, start, mid);
         }
         else if(array[mid] == data){
             return array[mid];
         }
         return -1;
     }
}
