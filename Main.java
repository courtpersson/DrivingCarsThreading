
public class Main {
	
	
		public static void main(String[] args) {
			
		Traffic traffic= new Traffic (10,20);
		
		for (int i = 0; i <10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cars Car1=new Cars('m', traffic);
			Thread thread1= new Thread(Car1);
			thread1.start();
			
			Cars Car2=new Cars('n', traffic);
			Thread thread2= new Thread(Car2);
			thread2.start();
		
		}
		
		
		for (int j=0; j<100; j++)	{
			traffic.setGrid();
			try {
				Thread.sleep(200);
			}	catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		}
	}
