class MyClass implements Runnable{
	private String name;
	private MyObject myObj;
	
	public MyClass(String name, MyObject myObj){
		this.name = name;
		this.myObj = myObj;
	}
	
	public void run() {
		if(this.name.equals("1"))
			myObj.foo(name);
		else
			myObj.bar(name);
	}
}

class MyObject{
	public static synchronized void foo(String name){
		try{
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo(): ending");
		}
		catch(InterruptedException ex){	
		}
	}
	public static synchronized void bar(String name){
		try{
			System.out.println("Thread " + name + ".bar(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".bar(): ending");
		}
		catch(InterruptedException ex){	
		}
	}
}

public class Test {
	public static void main(String[] args){

		MyObject obj1 = new MyObject();
		MyObject obj2 = new MyObject();
		Thread t1 = new Thread(new MyClass("1", obj1));
		Thread t2 = new Thread(new MyClass("2", obj2));
		
		t1.start();
		t2.start();
	}
}
