

public class Generator {

		public void generateCars(Traffic traffic)	{
			for (int i = 0; i < 6; i++) {
				try {
					Thread.sleep(1000);
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
		}
	}


