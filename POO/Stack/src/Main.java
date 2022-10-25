public class Main {
    public static void main(String[] args) {
        Stack s = new Stack(50);

        s.top();
        s.push(34);
        System.out.println("Top esk: " + s.top());

        for(int i = 0; i < 10; i++) {
            s.push(i);
        }


        while(!s.isEmpty()) {
            System.out.print(s.top() + " ");
            s.pop();
        }
    }
}
