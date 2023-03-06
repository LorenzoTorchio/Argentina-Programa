public class EJ1C1 {
    public static void main(String[] args) {
        int a = 0;
        int b = 10;
        System.out.println("(a)");
        while(a<b+1) {
            System.out.println(a);
            a++;
        }

        System.out.println("(b)");
        a = 0;
        while(a<b+1) {
            if(a%2==0) {
                System.out.println(a);
            }
            a++;
        }

        System.out.println("(c)");
        a = 0;
        int c = 1;
        while(a<b) {
            if(a%2==c) {
                System.out.println(a);
            }
            a++;
        }

        System.out.println("(d)");
        a = 0;
        for(;a < b;) {
            if(b%2==0) {
                System.out.println(b);
            }
            b--;
        }
    }
}