class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid: asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                if (stack.peek() < 0) {
                    // if the top element is -ve always push to the stack
                   stack.push(asteroid); 
                } else if (asteroid > 0 && stack.peek() > 0) {
                    // if both +ve push to the stack
                    stack.push(asteroid); 
                } else {
                    boolean pushToStack = false;
                    while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                        pushToStack = false;
                        if (Math.abs(asteroid) > stack.peek()) {
                            stack.pop();
                            pushToStack = true;
                        } else if (Math.abs(asteroid) == stack.peek()) {
                            stack.pop();
                            // don't loop as the asteroid is destroyed.
                            break;
                        } else {
                            // don't loop as the asteroid is smaller than the stack top
                            break;
                        } 
                    }
                    if (pushToStack) {
                        // push to stack only when after the loop the -ve value is greater
                        stack.push(asteroid);
                    }
                }
            }
        }
        
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }
        
        return res;
        
    }
}
