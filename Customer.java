import java.util.*;

class Customer {
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
        for(PaymentMethod pm : paymentMethods){
            if(pm.getPaymentId().equals(paymentId)){
                paymentMethods.remove(pm);
                return true;
            }
        }
        return false;
    }
    public PaymentMethod getPreferredPaymentMethod(){
        if (paymentMethods.isEmpty()){
            return null;
        }else{return paymentMethods.get(0);}
    
    }
    public void displayAllPaymentMethods(){
        if(paymentMethods == null ){
          System.out.println("Rỗng");
        }else{
        for (PaymentMethod pm : paymentMethods){
            System.out.println(pm);
        }}
    }
    
    public String toString(){
        return "ID "+ getPaymentId()+"- OwnerName: "+getOwnerName()+ "Type"+getPaymentType()+ "Card"+ getCardNumber() +"expiryDate"+ getExpiryDate()+ "Balance" + getBalance();
    }
}