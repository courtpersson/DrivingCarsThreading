import java.util.* ;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


	public abstract class Cars implements Runnable {
		protected char direction;
		protected char model;
		protected int speed;
		protected int staticLane;
		protected int movingLane;
		protected Traffic traffic;
		protected Lock lock= new ReentrantLock();
		protected Condition cond= lock.newCondition();
		protected boolean occupied;
		
		public Cars (char direction, Traffic traffic) {
			Random rand = new Random(); 
			speed = rand.nextInt(1000);
			this.traffic=traffic;
			this.direction=direction;
			movingLane=0;
			// sets the initial position of the vehicles
			// when generated
			if (direction== 'n')	{
				model='o';
				staticLane=rand.nextInt(traffic.getColumns());
				traffic.setPosition(movingLane, staticLane, model);
			}
			else if (direction== 'm')	{
				model='-';
				staticLane=rand.nextInt(traffic.getRows());
				traffic.setPosition(staticLane, movingLane, model);
			}
		}
		protected abstract char getModel();
		protected abstract char getDirection();
		protected abstract int getSpeed();
		protected abstract int getStaticLane();
		protected abstract int getMovingLane();
		protected abstract void moveTest();
		protected abstract void move();
		protected abstract void spaceManager();
//		protected abstract void move2() throws InterruptedException;
	}
