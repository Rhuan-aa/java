public class Carro {
    String modelo;
    int ano;
    String cor;

    void exibirFichaTecnica(){
        System.out.println(modelo);
        System.out.println(cor);
        System.out.println(ano);
    }

    int calcularIdade(int anoAtual){
        return anoAtual - ano;
    }
}
