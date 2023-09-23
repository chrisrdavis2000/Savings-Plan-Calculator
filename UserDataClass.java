package UserData;

public class UserDataClass {
    private double income;
   private double expenses;
   private double goal;
   private int time;
   
 
   public UserDataClass(){
       
   }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getIncome() {
        return income;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getGoal() {
        return goal;
    }

    public int getTime() {
        return time;
    }
    
    public double getTotal() {
        double total = (income - expenses) * time;
        
        return total;
    }
    
    public double getDiff() {
        double diff = getTotal() - goal;
        
        return diff;
    }
    
    public double getPlan() {
        if(getTotal() == getGoal())
            return 0;
        
        if(getTotal() < getGoal())
            return -1;
        else
            return 1;
    }
    
    /*public double getThreeMonths(){
       double total = (income - expenses) * time;
       if(total == goal){
           return 0;
       }
       else if(total < goal){
           return -1;
       }
       else
           return 1;
   }
   
    public double getSixMonths(){
       double total = (income - expenses) * time;
       if(total == goal){
           return 0;
       }
       else if(total < goal){
           return -1;
       }
       else
           return 1;
   }
   
     public double getTwelveMonths(){
       double total = (income - expenses) * time;
       if(total == goal){
           return 0;
       }
       else if(total < goal){
           return -1;
       }
       else
           return 1;
   }*/
}