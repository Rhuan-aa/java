package singleton;

public class Main {
    public static void main(String[] args) {
        MyLog.log("Iniciando o Sistema", PriorityLevel.INFORMATION);
        MyLog.log("Mensagem Informativa", PriorityLevel.INFORMATION);
        MyLog.log("Mensagem de Aviso", PriorityLevel.WARNING);
        MyLog.log("Mensagem Informativa", PriorityLevel.INFORMATION);
        MyLog.log("Mensagem de Erro", PriorityLevel.ERROR);
        MyLog.log("Mensagem de Aviso", PriorityLevel.WARNING);
    }
}
