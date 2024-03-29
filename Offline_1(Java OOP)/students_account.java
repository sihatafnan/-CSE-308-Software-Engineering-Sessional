

public class students_account extends account {

    private int loan;    ///holds approved loan
    public int year;
    public double interest_rate;
    final private int loan_upper_bound = 1000;
    final private double loan_interest_rate = 0.1;
    private boolean took_loan;
    private int requested_loan;  ///holds the total valid loan amount asked for
    private boolean withdrawal_status;

    @Override
    public String create_account(String nm , int initial_dep){
        name = nm;                      ///if same name exists,show error msg from main.java
        balance = initial_dep;
        loan = 0;
        requested_loan = 0;
        year=0;
        interest_rate = 0.05;
        took_loan = false;
        withdrawal_status = false;

        return "student account for " + nm + " created.Initial balance is " + String.valueOf(initial_dep);
    } 

    public void change_interest_rate(double rate){
        interest_rate = rate;
    }

    public int get_year(){
        return year;
    }

    @Override
    public void deposit(int amount){
        balance += amount;
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
            requested_loan += amount;
        }else took_loan = false;
        
    }

    public String loan_approved(){ ///returns name if loan was pending
        
        loan += requested_loan;
        balance +=requested_loan;
        String msg="";
        if(loan_pending()){
            msg = name+" ";
        } else {
            msg = "";
        }
        requested_loan = 0;
        return msg;
    }

    public boolean loan_pending(){
        return requested_loan>0;
    }

    public void year_inc(){
        year++;
        balance += (balance*interest_rate);
        balance -= (loan*loan_interest_rate);
    }
    

}
