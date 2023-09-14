// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//       RemoveStars obj = new RemoveStars();
//       String newStr = obj.removeStars("leet**cod*e");
//       System.out.println(newStr);

        AsteroidCollision collection = new AsteroidCollision();

        int[] asteroids = {10, 2, -5};
        int[] output = collection.asteroidCollision(asteroids);

        for (int j : output) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}