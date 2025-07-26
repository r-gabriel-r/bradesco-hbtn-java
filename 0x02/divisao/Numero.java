public class Numero {
    
    public static void dividir(int a, int b) {
        try {
            System.out.printf("%d / %d = %d", a, b, a/b);
        } catch(Exception e) {
            System.out.println("Nao eh possivel dividor por zero");
            System.out.printf("%d / %d = %d", a, b, 0);
        }
    }
}
