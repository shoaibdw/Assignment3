/*Q1.Write a generic method to count the number of elements
in a collection that have a specific property.
 (for example, odd integers, even numbers, prime numbers, palindromes.)*/
package assignment3;
import java.util.List;
import java.util.ArrayList;

interface myinterface1<T> {
    public boolean match(T t);
}
//Check prime by passing t type as a object from main thread
 class PrimeNumber implements myinterface1<Integer> {

    @Override
    public boolean match(Integer t) {

        for (int i = 2; i < t; ++i) {
            if (t % i == 0) {
                return false;
            }
        }
        return true;
    }
}
class OddNumber implements myinterface1<Integer> {

    @Override
    public boolean match(Integer t) {
        return (t % 2 != 0);
    }
}
class EvenNumber implements myinterface1<Integer> {

    @Override
    public boolean match(Integer t) {
        return (t % 2 == 0);
    }
}
class Palindromes implements myinterface1<Integer>{

    @Override
    public boolean match(Integer t) {
        int temp=t;
        int r;
        int sum=0;

        while(t>0){
            r=t%10;  //getting remainder
            sum=(sum*10)+r;
            t=t/10;
        }
        if(temp==sum)
        {
            return true;
        }
        else
            return false;



    }

}

//Lets count the element by passing elements from list to primeNumber,oddNumber, evenNumber, palindromes....

 class Counter {

    public <T> int count    (List<T> list, myinterface1<T> s)
    {
        int count = 0;
        for (T type : list) {
            if (s.match(type))  //
            {
                ++count;
            }
        }
        return count;
    }
}

//Main() Driver
public class  CountElements_1 {

    public static void main(String[] args) {
        CountElements_1 ce = new CountElements_1();
        ce.testSpecificElement();
    }

    public void testSpecificElement() {

        List<Integer> lst1=new ArrayList<>();

        lst1.add(212);                  //even + palindrome
        lst1.add(535535);               //palindrome+odd
        lst1.add(97);                   //prime


        PrimeNumber pn = new PrimeNumber();
        EvenNumber en = new EvenNumber();
        OddNumber on =new OddNumber();
        Palindromes pl = new Palindromes();
        Counter a = new Counter();

        System.out.println( "\n Count of Prime Numbers=\t"+a.count(lst1, pn));
        System.out.println("\n Count of Even Numbers=\t"+ a.count(lst1, en));
        System.out.println("\n Count of Odd Numbers=\t"+a.count(lst1,on));
        System.out.println("\n Count of Palindromes=\t"+a.count(lst1,pl));
    }

}

