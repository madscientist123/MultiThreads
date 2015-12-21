public class DeadlockDemo{
public static void main(String [] args){
System.out.println("Creating two bank accounts...");
ThreadSafeBankAccount checking = new ThreadSafeBankAccount(101, 1000.00);
ThreadSafeBankAccount savings = new ThreadSafeBankAccount(102, 5000.00);
System.out.println("Creating two teller threads...");
Thread teller1 = new LazyTeller(checking, savings);
Thread teller2 = new LazyTeller(savings, checking);
System.out.println("Starting both threads...");
teller1.start();
teller2.start();
}
}