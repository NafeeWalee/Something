package pureinternational.something.NumberTesting;

import android.widget.Toast;

public class Triangle {
    int num1;
    int flag;

    public void isTriangle(){

        for (int i = 1; i <= num1+1; i++) {
            for ( int j = 2; j <= num1+1; j++) {

                if(i==num1 )
                {
                    flag=1;
                    break;
                }
                i = i + j;
            }

        }

    }
}
