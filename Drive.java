

public class Drive extends Cars {
	

	public Drive (char direction, Traffic traffic) {
		super(direction, traffic);
	}

	
	protected char getModel() {
		return model;
	}

	
	protected int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}


	protected int getStaticLane() {
		return staticLane;
	}


	protected int getMovingLane() {
		return movingLane;
	}


	public void run() {
		spaceManager();
	}
	
	
	public void spaceManager(){
	
		occupied=traffic.nextIsOccupied(this);
		lock.lock();
		try {
			while(occupied)	{
			cond.await();
		}
			move();
			occupied = true;	
			cond.signalAll();
		
        }
        catch(InterruptedException e){
			e.printStackTrace();
        }
        finally {
        		occupied = false;
        		lock.unlock();
        	} 
	}	
	
	public void move ()	{
		
		if (direction== 'n')	{
			for(int i= movingLane; i<traffic.getRows(); i++)	{
				traffic.setPosition(movingLane, staticLane, model);
				movingLane++;
				if (movingLane== traffic.getRows()){
					traffic.resetCar(movingLane-1, staticLane);
				}
					try {
						Thread.sleep(speed);
					}	catch (InterruptedException e)	{
						e.printStackTrace();
					}
			}
		}
		
		else if (direction=='m')	{
			for(int i= movingLane; i<traffic.getColumns(); i++)	{
				traffic.setPosition(staticLane, movingLane, model);
				movingLane++;
				if (movingLane== traffic.getColumns()){
					traffic.resetCar(staticLane, movingLane-1);
				}
					try {
						Thread.sleep(speed);
					}	catch (InterruptedException e)	{
						e.printStackTrace();
					}
			}
		}
	}
	
//		
//		
//	}
//	
//	public void move2() throws InterruptedException{
//	
//		lock.lock();
//		try {
//			while (row<inter.getColumns()) {
//			inter.setPosition(row, column, model);
//			column++;
//			try {
//				Thread.sleep(speed);
//			}	catch (InterruptedException e)	{
//				e.printStackTrace();
//			}
//			}
//			cond.signalAll();
//		}
//		finally {
//			lock.unlock();
//		}	
//		}
//		finally {
//		lock.unlock();
//		}
		
		
//	}

	protected void moveTest() {
		
		lock.lock();
		
        try {
        		while(occupied) { 
        			cond.await();
        }
        	
        	occupied = true;	
        	cond.signalAll();
		if (direction== 'n')	{
			for(int i= movingLane; i<traffic.getRows(); i++)	{
				traffic.setPosition(movingLane, staticLane, model);
				movingLane++;
				if (movingLane== traffic.getRows()){
					traffic.resetCar(movingLane-1, staticLane);
				}
					try {
						Thread.sleep(speed);
					}	catch (InterruptedException e)	{
						e.printStackTrace();
					}
			}
		}
		
		else if (direction=='m')	{
			for(int i= movingLane; i<traffic.getColumns(); i++)	{
				traffic.setPosition(staticLane, movingLane, model);
				movingLane++;
				if (movingLane== traffic.getColumns()){
					traffic.resetCar(staticLane, movingLane-1);
				}
					try {
						Thread.sleep(speed);
					}	catch (InterruptedException e)	{
						e.printStackTrace();
					}
			}
		}
        }
        catch(InterruptedException e){
			e.printStackTrace();
        }
        finally {
        		occupied = false;
        		lock.unlock();
        	} 
	
		
	}

	
	protected char getDirection() {
		return direction;
	}


}
