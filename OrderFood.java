package food;

public interface OrderFood{
    double calculateBill();
    double calculateBill(double discount);
    double calculateBill(double discount,double deliveryCharge);
    double calculateDeliveryCharge();
    default void display(){
        System.out.println("ORDER DETAILS: ");
    }
}
