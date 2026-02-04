
class Transaction {
    private final String transactionId;
    private PaymentMethod paymentMethod;
    private double amount;
    private String description;
    private static int totalTransactions = 1;
    public Transaction( PaymentMethod paymentMethod, double amount, String description) {
        this.transactionId = "TXN"+ String.format("%03d",totalTransactions);
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.description = description;
        totalTransactions++;
    }

    
    public final String getTransactionId() {
        return transactionId;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public static int getTotalTransactions(){
        return totalTransactions - 1;
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }

    if (obj == null) {
        return false;
    }

    if (!(obj instanceof Transaction)) {
        return false;
    }

    Transaction other = (Transaction) obj;
    return this.transactionId.equals(other.transactionId);
}

    @Override
    public int hashCode(){
        return getTransactionId().hashCode();
    }
    @Override
    public String toString(){
        return "Transaction ID: "+getTransactionId()+", Payment Method: "+getPaymentMethod()+", Amount: "+getAmount()+", Description: "+getDescription();
}}