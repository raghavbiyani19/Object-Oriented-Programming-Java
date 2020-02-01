package queue;


public class GenSum <T>
{
    T[] t;

    GenSum(T[] t)
    {
        this.t=t;
    }
    double s;
    public <T> void sum(T[] t)
    {
        for (T t1 : t) {
            s += ((Number) t1).doubleValue();
        }
        System.out.println("The Sum is = "+s);
    }
}