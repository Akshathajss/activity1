package akshatha;
import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;
class Jobsequencing
{
int n,i,q;
int p[] = new int[10];
int cyp[] = new int[10];
int d[] = new int[10];
int J[] = new int[10];
int max;
int mindex;
int count=0;

void greedyJobsequencing() 
{
	int dl=maximum(d);
	System.out.println("dl="+dl);
	q=dl;
	for(i=1;i<dl;i++)
		J[i]=0;
	cyp=p;
	
	
	while(dl>0)
	{
		for(int u=0;u<2;u++)
			System.out.println("J="+J[0]+" "+J[1]);
		int pf=maximum(p);
		//int g=Arrays.asList(p).indexOf(pf);//to find the index of max profit
		System.out.println("g="+pf);
		//System.out.println("index of 1st max is:"+i);
			for(;;)
				{
					if(J[d[mindex]]==0)
					{
						System.out.println("Test");
						System.out.println("mindex"+d[mindex]);
						J[d[mindex]]=mindex;
						dl-=1;
						break;
					}
					if(d[mindex]>0)
						break;
					d[mindex]-=1;
				}
			System.out.println("dl="+dl);
			

			/*for(int w=1;w<q;w++)
			System.out.println(J[w]+" ");
			System.out.println();*/
			
		p = removeTheElement(p, mindex);//to remove the current max profit
		count++;
		if(count==5)
			System.exit(0);
		} // while loop

}
	private int[] removeTheElement(int[] p2, int g) {
		// TODO Auto-generated method stub
		if(g==n)
		{
			p[g]=0;d[g]=0;
		}
		for(int s=g;s<n;s++)
			p[s]=p[s+1];
		
		return p;
}
int maximum(int a[])
{
	max=a[1];
	mindex=1;
	for(i=2;i<=n;i++)
	{
		//System.out.println("a[i]="+a[i]);
		if(max<a[i]) {
		 max=a[i];
		 mindex=i;
		}
		
	}
return max;
}
}

public class code {

	public static void main(String[] args )  {
        int i;
Scanner in = new Scanner(System.in);
Jobsequencing p = new Jobsequencing();
System.out.println("***JOBSeQUENCING USING GREEDY TECHNIQUE***\n");//accepting input part
System.out.println("Enter the number job");
p.n = in.nextInt();
System.out.println("\nEnter the profits");
for(i=1;i<=p.n;i++)
p.p[i] = in.nextInt();
System.out.println("\nEnter the deadlines");
for(i=1;i<=p.n;i++)
p.d[i] = in.nextInt();
for(i=1;i<=p.n;i++)
System.out.println(p.p[i]);
//Arrays.sort(p.p);
for(i=1;i<=p.n;i++)
System.out.println(p.p[i]);
p.greedyJobsequencing();
for(i=1;i<=p.q;i++)
	System.out.println(p.J[i]);

//displaying part
System.out.println("Jobs\tslot assigned\tprofit\t");
for( int h=1;h<p.n;h++)
System.out.println("J"+p.J[h]+"\t"+(h-1)+"-"+h+"\t"+p.cyp[h]+"\t");
	}

}

