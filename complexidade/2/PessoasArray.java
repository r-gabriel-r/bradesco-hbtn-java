public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

/** 
 *  
 * 0,1,2,3,4,5,6,7,8,9,10
 * I                    S     
 *           M        
 *             I        S
 *                  M          
 *             I  S  
 *                    
 *                   
 *  */ 



    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        System.out.printf("Procurando o nome: \"%s\"\n", nome);
        //começar a busca pela posição do meio do array
        int inferior = 0;
        int superior = this.nomes.length - 1;
        int meio = 0;
        while(inferior <= superior) {
            meio = (inferior + superior) / 2;
            System.out.printf("Passando pelo indice: %s\n", meio);
            if(this.nomes[meio].equals(nome)) {
                encontrado = true;
                break;
            }

            // verificar se nome que estou procurando esta à direita ou à esquerda 
            if(nome.charAt(0) > this.nomes[meio].charAt(0)) {
                inferior = meio + 1;
            } else {
                superior = meio - 1;
            }
        }
        if(encontrado) {
            System.out.printf("Nome %s encontrado na posição %d\n", nome, meio);
        } else 
            throw new IllegalArgumentException("O nome " + nome +" não se encontra no array de nomes");
    }

}
