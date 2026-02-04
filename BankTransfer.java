class BankTransfer extends PaymentMethod implements Payable,Refundable{
    private String accountNumber;
    private String bankName;
    private final String routingNumber;
    private static boolean isBankHoliday;
    public static void setBankHoliday(boolean isBankHoliday){
        BankTransfer.isBankHoliday = isBankHoliday;
        
    }
    public boolean getBankHoliday(){
        return isBankHoliday;
    }
    public BankTransfer(String ownerName, double balance, String accountNumber, String bankName, String routingNumber){
        super(ownerName, balance);
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.routingNumber = routingNumber;
    }
    public boolean validate(){
        if(accountNumber.length()>=8 && routingNumber.length()==9){
            return true;
        }else{
            return false;}
        }
    public String getPaymentType(){
            return "Bank Transfer";
    }
    public boolean processPayment(double amount){
        if(isBankHoliday){
            System.out.println("Hôm nay nghỉ");
            return false;
        }
        if (validate()&&hasSufficientFunds(amount)){
             setBalance(getBalance() - amount);
            System.out.println("Thanh cong");
            return true;

        }
        return false;
    }
        public String getPaymentDetails(){
            return "Bank:" + bankName + ", Account Number: "+ accountNumber.substring(accountNumber.length()-4);
        }
        public boolean processRefund(double amount){
            setBalance(getBalance()+amount);
            return true;
        }
        public String getRefundPolicy(){
            return "Refunds processed within 3-5 business days.";
        }
        public String getAccountNumber(){
            return accountNumber;
        }
        public void setAccountNumber(String accountNumber){
            this.accountNumber = accountNumber;
        }
        public String getBankName(){
            return bankName;
        }
        public void setBankName(String bankName){
            this.bankName = bankName;  
        }
        public String getRoutingNumber(){
            return routingNumber;
        }
        
        public String toString(){
            return "BankTransfer[Owner: " + getOwnerName() + ", Balance: " + getBalance() + ", Bank: " + bankName + ", Account Number: " + accountNumber + "]";
        }
        
}