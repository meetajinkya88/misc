public class CandidateCode 
{ 

	public static void main(String [] args)
	{
		System.out.println("Total no of cadbury bars: " + distributeCadbury(7,1,1,2));
		System.out.println("Total no of cadbury bars: " + distributeCadburyWithoutRecursion(5,6,3,4));

	}
	private static int distributeCadburyWithoutRecursion(int i, int j,
			int k, int l)
	{
		int sum = 0;
		sum += getgetTotalNoOfCadburyBar2(i,k);
		sum += getgetTotalNoOfCadburyBar2(i,l);
		sum += getgetTotalNoOfCadburyBar2(j,k);
		sum += getgetTotalNoOfCadburyBar2(j,l);
	
		return sum;
	}
	private static int getgetTotalNoOfCadburyBar2(int i, int k) 
	{
		int sum = 0;
		while(true)
		{
			if(i == k)
			{
				sum++;
				break;
			}

			if(i > k)
			{
				sum ++;
				i = i -k;
			}
			if( i < k)
			{
				sum++;
				k = k -i;
			}


		}
		return sum;
	}
	public static int distributeCadbury(int input1,int input2,int input3,int input4)
	{
		//Write code here
		int totalNoOfCadburyBar = 0;

		totalNoOfCadburyBar += getTotalNoOfCadburyBar(input1,input3);
		totalNoOfCadburyBar += getTotalNoOfCadburyBar(input1,input4);
		totalNoOfCadburyBar += getTotalNoOfCadburyBar(input2,input3);
		totalNoOfCadburyBar += getTotalNoOfCadburyBar(input2,input4);


		return totalNoOfCadburyBar;

	}
	private static int getTotalNoOfCadburyBar(int i, int j)
	{
		if(i == j)
			return 1;
		if(i > j)
			return 1 + getTotalNoOfCadburyBar(i - j, j);
		if(i<j)
			return 1 + getTotalNoOfCadburyBar(i, j-i);
		return 0;
	}
}