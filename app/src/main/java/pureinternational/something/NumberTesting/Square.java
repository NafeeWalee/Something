package pureinternational.something.NumberTesting;

import android.widget.Toast;

public class Square {
    int num1;
    int flag;
    public void isSquare(){

        for(int i=2;i<num1+1;i++)
        {
            double a= num1/i;
            if(a==i) {
                flag=1;
                break;
            }
        }

    }
}
