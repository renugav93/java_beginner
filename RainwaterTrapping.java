import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidHeightException extends Exception {
    public InvalidHeightException(String message) {
        super(message);
    }
}

public class RainwaterTrapping {

    static long calculateWater(int[] height) {
        long totalWater = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = 0; j <= i; j++) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }

            for (int j = i; j < height.length; j++) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }
            
            int waterLevel;

            if (leftMax < rightMax) {
                waterLevel = leftMax;
            } else {
                waterLevel = rightMax;
            }

            totalWater += waterLevel - height[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of buildings: ");
            int n = sc.nextInt();

            int[] height = new int[n];

            System.out.println("Enter the building heights:");

            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();

                if (height[i] < 0) {
                    throw new InvalidHeightException(
                        "Height cannot be negative at building " + (i + 1)
                    );
                }
            }

            System.out.println(
                "Total rainwater trapped: " + calculateWater(height)
                + " cubic units"
            );

        } catch (NegativeArraySizeException e) {
            System.out.println("Number of buildings cannot be negative.");

        } catch (InputMismatchException e) {
            System.out.println("Enter valid integers within the int range.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index.");

        } catch (InvalidHeightException e) {
            System.out.println(e.getMessage());
        }
    }
}
