import java.util.concurrent.Semaphore;


public class SampleInterrupt 
{
	
    protected Semaphore isAvailable = new Semaphore(1,true);

	public static void main(String[] args) throws InterruptedException 
	{
		SampleInterrupt sample = new SampleInterrupt();
		sample.startThread();

	}

	private void startThread()
	{
		new Thread(new InterruptThread()).start();
	

	}

	public class InterruptThread implements Runnable
	{
		int count = 0;
		public void run()
		{
			
			while(!Thread.currentThread().isInterrupted())
			{

				System.out.println(Thread.currentThread().getName() + "- Running...");

				try 
				{
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName() + "-  loop : " + count++);
				}
				catch (InterruptedException e) 
				{
					System.out.println(Thread.currentThread().getName() + "- " +e.getMessage());
					System.out.println(Thread.currentThread().getName() + "- " +e.getStackTrace());
				}
				reload(count);

			}
			System.out.println(Thread.currentThread().getName() + "- Thread Interupted with value...." + Thread.currentThread().isInterrupted());

		}


	}
	private void reload(int count ) 
	{
		if(count == 2)
		{
			Thread.currentThread().interrupt();
			 new Thread(new InterruptThread()).start();;
			
			

		}
     /*   try 
        {
			isAvailable.acquire();
		} 
        catch (InterruptedException e)
        {
        	System.out.println("Reload Method : " + e.getMessage());
			System.out.println("Reload Method : " + e.getStackTrace());
			Thread.currentThread().interrupt();
		}*/
		System.out.println(Thread.currentThread().getName() + "- Reloading count.."  + count);
		  isAvailable.release();
	


	}

}
