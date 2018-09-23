import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DecentNumbers {

    // Complete the decentNumber function below.
    static void decentNumber(int n) {
    	
    	if (n % 8 % 3 != 0 && n % 8 % 5 != 0)
    		System.out.println(-1);
    	else
    	{
    		if (n % 5 == 0)
    		{
    			for (int i = n; i > 0; i-=5)
    				System.out.print(33333);
    			System.out.println();
    		}
    		else if (n % 3 == 0)
    		{
    			for (int i = n; i > 0; i-=3)
    				System.out.print(555);
    			System.out.println();
    		}
    		else
    		{
    			int i;
    			for (i = n; i % 5 != 0; i-=3)
    				System.out.print(555);
    			for (; i > 0; i-=5)
    				System.out.print(33333);
    		}
    	}

    }

    public static void main(String[] args) throws IOException {

    	decentNumber(1);
    	decentNumber(3);
    	decentNumber(5);
    	decentNumber(11);
    	
    }
}
