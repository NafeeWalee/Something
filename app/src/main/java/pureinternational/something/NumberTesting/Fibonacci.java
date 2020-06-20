package pureinternational.something.NumberTesting;

import android.widget.Toast;

public class Fibonacci {
    int num1;
    int flag;
    public void isFibo(){
        int sum,first=0,second=1;

        for(int i=0;i<num1+1;i++){
            sum=first+second;
            first=second;
            second=sum;
            if(sum==num1)
            {
                flag=1;
                break;
            }
        }

    }
}
