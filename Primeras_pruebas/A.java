public class A extends Thread {
    
    static long n;
    static Object obj = new Object();

    public void run() {
        
        synchronized(obj){
            for (int i = 0; i < 100000; i++) { 
                n ++;
            }   
        }
    }   

    public static void main(String[] args) throws Exception{
        try {
            A t1 = new A();
            A t2 = new A();

            t1.start();
            t2.start();
            
            t1.join();
            t2.join();

            System.out.println(n);
            
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}
