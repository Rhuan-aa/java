import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Bom dia! Para iniciar programa insira seus dados \n");
        System.out.println("Digite seu nome:");
        Scanner scanName = new Scanner(System.in);
        String name = scanName.nextLine();
        System.out.println("Tipo de Conta: ");
        Scanner scanType = new Scanner(System.in);
        String accountType = scanType.nextLine();
        System.out.println("Saldo: ");
        Scanner scanCurrent = new Scanner(System.in);
        double current = scanCurrent.nextDouble();

        System.out.println("*****************************************");
        System.out.printf("NOME DO USUARIO: %s", name);
        System.out.printf("TIPO DE  CONTA: %s", accountType);
        System.out.printf("SALDO: %.2f", current);
        System.out.println("*****************************************");

        int opt = -1;
        while(opt != 4){
            String menu;
            menu = """
                    1 - Consultar Saldo
                    2 - Receber Valor
                    3 - Transferir Valor 
                    4 - Sair\n
                    """;
            System.out.println(menu);
            System.out.println("Qual opção deseja: ");
            Scanner scanOpt = new Scanner(System.in);
            opt = scanOpt.nextInt();
            if (opt == 1){
                System.out.printf("Saldo: %.2f\n", current);
            } else if (opt == 2){
                System.out.println("Digite o valor que vai receber: ");
                Scanner scanValue = new Scanner(System.in);
                double value = scanValue.nextDouble();
                if (value >= 0){
                    System.out.println("Transação concluida com sucesso! \n");
                    current += value;
                } else {
                    System.out.println("Valor inválido para transação");
                }
            } else if (opt == 3){
                System.out.println("Digite o valor que vai transferir: ");
                Scanner scanValue = new Scanner(System.in);
                double value = scanValue.nextDouble();
                if (value >= 0 && value <= current) {
                    System.out.println("Transação concluida com sucesso! \n");
                    current -= value;
                } else {
                    System.out.println("Valor inválido para transação");
                }
            } else if (opt == 4) {
                System.out.println("Encerrando Programa");
            } else {
                System.out.println("Opção Inválida!");
            }
        }
    }
}