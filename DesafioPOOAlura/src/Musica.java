public class Musica {
    String titulo;
    String artista;
    int anoDeLancamento;
    double avaliacoes;
    int numDeAvaliacoes;

    void exibirFichaTecnica(){
        System.out.println("Titulo: " + titulo);
        System.out.println("Artista: " + artista);
        System.out.println("Ano de Lançamento: " + anoDeLancamento);
    }

    void  avaliarMusica(double num){
        avaliacoes+= num;
        numDeAvaliacoes++;
    }

    double avaliacaoGeral(){
        return avaliacoes/numDeAvaliacoes;
    }
}
