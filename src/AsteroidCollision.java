import java.util.Stack;

// Leetcode 735. Asteroid Collision problem
public class AsteroidCollision {
    public boolean samesign(int x, int y){
        if(x < 0 && y < 0)
            return true;
        else if(x > 0 && y > 0)
            return true;

        return false;
    }
    public int[] asteroidCollision(int[] asteroids){
        int n = asteroids.length;
        Stack<Integer> s = new Stack<Integer>();
        for (int asteroid : asteroids) {
            if (s.isEmpty() || (s.peek() < 0 && asteroid > 0) || samesign(s.peek(), asteroid)) {
                s.push(asteroid);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroid))
                    s.pop();
                if (s.isEmpty() || s.peek() < 0) {
                    s.push(asteroid);
                } else if (s.peek() == Math.abs(asteroid)) {
                    s.pop();
                }
            }
        }

        int[] ans = new int[s.size()];
        int i = s.size() - 1;
        while(!s.isEmpty()){
            ans[i] = s.peek();
            i--;
            s.pop();
        }

        return ans;

    }
}
