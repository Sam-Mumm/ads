public class Binary_Exponentiation
{
    public long  exponentiation(long x, long n)
    {
        long result=1;
        
        while(n!=0)
        {
            if(n%2==0)
            {
                n=n/2;
                x=x*x;
            }
            else
            {
                n--;
                result=result*x;
            }
        }
        
        return result;
    }
}
