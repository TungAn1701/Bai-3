abstract class PaymentMethod {
    private final String paymentId;
    private String ownerName;
    private double balance;
    private static int paymentCount =1 ;
    public PaymentMethod(String ownerName, double balance){
        this.paymentId = "PAY" + String.format("%03d", paymentCount);
        this.ownerName = ownerName;
        this.balance = balance;
        paymentCount++;
    }
    public PaymentMethod(){
        this.paymentId = "Unknown";
        this.ownerName = "Unknown";
        this.balance = 0.0;
    }
    public PaymentMethod(String ownerName){
        this.paymentId = "Unknown";
        this.ownerName = ownerName;
        this.balance = 0.0;
    }
    
    public abstract boolean validate();
    public abstract String getPaymentType();
    public void displayBalance(){
        System.out.println("Current balance: " + balance);
    }
    protected boolean hasSufficientFunds(double amount){
        return balance >= amount;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public double getBalance(){
        return balance;
    }
    public static int getPaymentCount(){
        return paymentCount-2 ;
    }
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public String getPaymentId(){
        return paymentId;
    }

}