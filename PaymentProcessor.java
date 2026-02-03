class PaymentProcessor{
    public static boolean process(PaymentMethod pm, double amount){
        return pm.validate() && pm.hasSufficientFunds(amount);
    }
    public static boolean process(PaymentMethod pm, double amount, String description){
        System.out.println("Processing payment for: " + description);
        return pm.validate() && pm.hasSufficientFunds(amount);
    }
    public static boolean process(Transaction transaction){
       return transaction.getPaymentMethod().validate() && transaction.getPaymentMethod().hasSufficientFunds(transaction.getAmount());
    }
    public static void executePayment( Payable payable, double amount){
        
        
    }
    public static void executeRefund(Refundable refundable, double amount){
        
    }
}