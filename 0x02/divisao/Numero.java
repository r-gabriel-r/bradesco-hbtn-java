public class Numero {
    
    public static void dividir(int a, int b) {
        int resultado = 0;
        try {
            resultado = a/b;
        } catch(Exception e) {
            System.out.println("Nao eh possivel dividor por zero");
        } finally {
            System.out.printf("%d / %d = %d", a, b, resultado);
        }
    }
}
