import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import Regex;
class CreditCard extends PaymentMethod implements Payable,Refundable{
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCard(String ownerName, String cardNumber, String cvv, String expiryDate){
        super(ownerName);
        this.cardNumber= cardNumber;
        this.cvv= cvv;
        this.expiryDate= expiryDate;
        System.out.println("Credit Card created for " + ownerName);
    }
        public CreditCard(){
        super();
        this.cardNumber="0000-0000-0000-0000";
        this.cvv="000";
        this.expiryDate="00/00";
        System.out.println("Default Credit Card created");

    }
    public CreditCard(String ownerName, double balance, String cardNumber, String cvv, String expiryDate){
        super(ownerName, balance);
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiryDate=expiryDate;
        System.out.println("Credit Card created for " + ownerName + " with balance " + balance);
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public void setCardNumber(String cardNumber){
        this.cardNumber=cardNumber;
    }
    public String getCvv(){
        return cvv;
    }
    public void setCvv(String cvv){
        this.cvv=cvv;
    }
    public String getExpiryDate(){
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate){
        this.expiryDate=expiryDate;
    }

    public boolean validate(){
        LocalDate now = LocalDate.now();
        String[] parts = expiryDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);
        int nowMonth = now.getMonthValue();
        int nowYear = now.getYear();
        
        if(cvv.length()!=3 && (year < nowYear || (year == nowYear && month < nowMonth))){
            System.out.println("Invalid Credit Card");
            return false;
        } else {
            System.out.println("Valid Credit Card");
            return true;
        }
    }
    public String getPaymentType(){
        return "Credit Card";
    }

    public boolean processPayment(double amount){
        if(validate()&& hasSufficientFunds(amount) ){
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
    public String getPaymentDetails(){
        return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
    }
    public boolean processRefund(double amount){
        setBalance(getBalance() + amount);
        return true;
    }
    public String getRefundPolicy(){
        return "Refunds processed within 5-7 business days.";
    }
    public String toString(){
        return "Credit Card [Owner: " + getOwnerName() + ", Balance: " + getBalance() + ", Card Number: " + getPaymentDetails() + ", Expiry Date: " + expiryDate + "]";
    }
}
