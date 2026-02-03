class DigitalWallet extends PaymentMethod implements Payable{
    private String email;
    private String phoneNumber;
    private final String WALLET_PROVIDER = "Paynow";
    public DigitalWallet(String ownerName, String email){
        super(ownerName, 0.0);
        this.email = email;
        this.phoneNumber = "N/A";
    }
    public DigitalWallet(String ownerName, String email, String phoneNumber){
        super(ownerName, 0.0);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public DigitalWallet(String ownerName, double balance, String email, String phoneNumber){
        super(ownerName, balance);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public boolean validate(){
        if(email.contains("@") && phoneNumber.length()>0){
            return true;
        }
        return false;}
        public String getPaymentType(){
            return "Digital Wallet" ;
        }
        
        public boolean processPayment(double amount){
        if(validate()==true && hasSufficientFunds(amount) ){
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
        }
        public final String getWalletProvider(){
            return WALLET_PROVIDER;
        }
        public String getPaymentDetails(){
            return "Email:" + email + ", Phone Number: " + phoneNumber ;
        }
        @Override
        public double applyServiceFee(double amount){
            return amount * 1.015;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(String email){
            this.email = email; 
        }
        public String getPhoneNumber(){
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber; 
        }
        public String toString(){
            return "DigitalWallet[Owner: " + getOwnerName() + ", Balance: " + getBalance() + ", Email: " + email + ", Phone: " + phoneNumber + "]";
        }
        

}