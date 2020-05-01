
public class InterruptThread implements Runnable
{
	int j = 0;
	public void run()
	{
		int i = 0;
	/*	while(!Thread.currentThread().isInterrupted())
		{
			try
			{
				System.out.println(" loop : " + i++);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.getStackTrace();
			}
		}*/
		
		while(!Thread.currentThread().isInterrupted())
		{
			
			System.out.println(" Running...");

			try 
			{
				Thread.sleep(5000);
				System.out.println(" loop : " + i++);
			}
			catch (InterruptedException e) 
			{
				System.out.println(e.getMessage());
				System.out.println(e.getStackTrace());
			}
			reload();
			
		}
	}

	private void reload() 
	{
		//if(j != 2)
			
		
	}
}
