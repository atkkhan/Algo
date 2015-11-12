
public class TwoThreads extends Thread{

	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println("New Thread");
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwoThreads tt = new TwoThreads();
		tt.start();
		for ( int i = 0; i < 10; i++ ) {
			System.out.println("Main thread");
		}
	}
}

//
//1: public class TwoThread extends Thread {
//2:     public void run() {
//3:         for ( int i = 0; i < 10; i++ ) {
//4:             System.out.println("New thread");
//5:         }
//6:     }
//7:
//8:     public static void main(String[] args) {
//9:         TwoThread tt = new TwoThread();
//10:         tt.start();
//11:
//12:         for ( int i = 0; i < 10; i++ ) {
//13:             System.out.println("Main thread");
//14:         }
//15:     }
//16: }