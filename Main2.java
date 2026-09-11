import food.OrderFood;

class FoodOrder implements OrderFood {
    int itemcount;
    double foodAmount;

    FoodOrder(int itemcount, double foodAmount) {
        this.itemcount = itemcount;
        this.foodAmount = foodAmount;
    }

    public double calculateBill(){
        return foodAmount * itemcount;
    }

    public double calculateBill(double discount) {
    return calculateBill() - discount;
}

public double calculateBill(double discount, double deliveryCharge) {
    return calculateBill(discount) + deliveryCharge;
}

public double calculateDeliveryCharge() {
    return 0; 
}

    @Override 
    public void display() {
        System.out.println("Ordering food...");
        System.out.println("Enter the number of items: "+itemcount);
        System.out.println("Enter the amount of food: "+foodAmount);
        System.out.println("Total bill: " + calculateBill());
    }
}

public class Main2{
    public static void main(String[] args){
        int itemcount1 = 3;
        double foodAmount1 = 10.5;
        int itemcount2 = 2;
        double foodAmount2 = 15.0;
        int itemcount3 = 1;
        double foodAmount3 = 20.0;
        FoodOrder order[] = new FoodOrder[3];
        order[0] = new FoodOrder(itemcount1, foodAmount1);
        order[1] = new FoodOrder(itemcount2, foodAmount2);
        order[2] = new FoodOrder(itemcount3, foodAmount3);
        for(int i=0; i<order.length; i++){
            order[i].display();
        }
    }
}