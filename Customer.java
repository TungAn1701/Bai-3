class Customer{ 
    private String customerId;
    private String name;
    private String email;
    private List<PaymentMethod> paymentMethods;
    public Customer(String customerId, String name, String email){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.paymentMethods = new ArrayList<>();
    }
    public String getCustomerId(){
        return customerId;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }  
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }
    
    public void addPaymentMethod(PaymentMethod pm){
        paymentMethods.add(pm);
    }
    public boolean removePaymentMethod(String paymentId){
        if (paymentMethods.getElementById(paymentId)!= null){
            return paymentMethods.remove(paymentMethods.getElementById(paymentId));
        }
        return false;
    }
    public PaymentMethod getPreferredPaymentMethod(){
        if (paymentMethods.isEmpty()){
            return null;
        }else{return paymentMethods.get(0);}
    
    }
    public void displayAllPaymentMethods(){
        for (PaymentMethod pm : paymentMethods){
            System.out.println(pm.getPaymentDetails());
        }
    }
}