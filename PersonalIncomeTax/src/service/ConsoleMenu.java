package service;

import model.Contributor;
import persistence.input.Input;
import persistence.input.InputContributor;
import persistence.input.InputFactory;
import persistence.repository.ContributorRepository;

import java.util.Scanner;

public class ConsoleMenu {
    public static void bootMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                =================================================================
                MENU IPRF:
                1 - Cadastrar contribuinte
                2 - Adicionar renda tributável
                3 - Adicionar gasto com saúde
                4 - Adicionar gasto com educação
                5 - Simular imposto de renda
                6 - Sair
                =================================================================
                """);
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> {
                Contributor contributor = InputFactory.create(new InputContributor());
                ContributorRepository.save(contributor.getCPF(), contributor);
            }
            case 2 -> {

            }
        }

        scanner.close();
    }
}
