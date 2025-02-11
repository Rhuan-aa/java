public class Main {
    public static void main(String[] args) {

        //Ex 1:
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.olaMundo();

        //Ex 2:
        Calculadora novaCalculadora = new Calculadora();
        double numero = novaCalculadora.dobrar(35);
        System.out.println(numero);

        //EX 3:
        Musica novaMusica = new Musica();
        novaMusica.titulo = "Something in the Way";
        novaMusica.artista = "Batman";
        novaMusica.anoDeLancamento = 2022;
        novaMusica.avaliacoes = 31.10;
        novaMusica.numDeAvaliacoes = 7;
        novaMusica.avaliarMusica(3.60);
        novaMusica.exibirFichaTecnica();
        double nota = novaMusica.avaliacaoGeral();
        System.out.println(nota);

        //EX 4:
        Carro novoCarro = new Carro();
        novoCarro.modelo = "Civic 2014";
        novoCarro.ano = 2014;
        novoCarro.cor = "Preto";
        novoCarro.exibirFichaTecnica();
        int tempoDeUso = novoCarro.calcularIdade(2025);
        System.out.println(tempoDeUso);

        //EX 5:
        Aluno meuAluno = new Aluno();
        meuAluno.nome = "Akemi";
        meuAluno.idade = 18;
        meuAluno.exibeInformacoes();

        IdadePessoa idadePessoa = new IdadePessoa();
        idadePessoa.setName("Rhuan");
        idadePessoa.setAge(19);
        if(idadePessoa.verifyAge(idadePessoa.getAge())){
            System.out.println("É maior de idade");
        } else {
            System.out.println("É menor de idade");
        }

        Produto produto = new Produto();
        produto.setProductName("Camisa");
        produto.setProductValue(53.99F);
        produto.applyDiscount(25);
        System.out.println(produto.getProductValue());

        Student student = new Student();
        student.setName("Raulzitos");
        student.setGrades(35F);
        System.out.println(student.calculateAvarage(5));
    }
}