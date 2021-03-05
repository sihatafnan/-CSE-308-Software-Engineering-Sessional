

public class students_account extends account {

    private int loan;
    final private int loan_upper_bound = 1000;
    private double interest_rate = 0.05;
    final private double loan_interest_rate = 0.1;
    private boolean took_loan;
    private boolean withdrawal_status;
    private int year;

    @Override
    public String create_account(String nm , int initial_dep){
        name = nm;                      ///if same name exists,show error msg from main.java
        balance = initial_dep;
        year = 0;
        loan = 0;
        year=0;
        took_loan = false;
        withdrawal_status = false;

        return "student account for " + nm + " created.Initial balance is " + String.valueOf(initial_dep);
    }

    public void change_interest_rate(double rate){
        interest_rate = rate;
    }

    @Override
    public void deposit(int amount){
        balance += amount;
    }

    public int get_year(){
        return year;
    }

    @Override
    public void withdraw(int amount){
        if(amount > 10000 || amount>balance){
            withdrawal_status = false;
        }
        else{
            balance -= amount;    
            withdrawal_status = true;    
        }
    }

    public boolean get_withdraw_status(){
        return withdrawal_status;
    }

    @Override
    public int query(){
        return balance;
    }

    public int getloan_amount(){
        return loan;
    }

    public boolean getloan_status(){
        return took_loan;
    }

    @Override 
    public void request_loan(int amount){
        if(amount<=loan_upper_bound){                //need to check if bank has that much initial fund also
            took_loan = true;
        }else took_loan = false;
        
    }

    public void loan_approved(int amount){
        loan+=amount;
        balance += loan;
    }

    public void year_inc(){
        year++;
        balance += (balance*interest_rate);
        balance -= (loan*loan_interest_rate);
    }
    

}
