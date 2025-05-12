package persistence.repository;

import model.Contributor;
import model.statement.IncomeStatement;
import persistence.input.InputFactory;
import persistence.input.InputIncomeStatement;

import java.util.*;

public class IncomeStatementRepository {
    private static final Map<String, IncomeStatement> db = new HashMap<>();

    public static void save(String CPF, IncomeStatement incomeStatement) {
        Objects.requireNonNull(incomeStatement, "A declaração não pode ter valor nulo");
        db.putIfAbsent(CPF, incomeStatement);
    }

    public static void update(String CPF) {
        if (!db.containsKey(CPF)) throw new NoSuchElementException("O contribuidor não existe");
        db.replace(CPF, InputFactory.create(new InputIncomeStatement()));
    }

    public static void remove(String CPF) {
        if (!db.containsKey(CPF)) throw new NoSuchElementException("O contribuidor não existe");
        db.remove(CPF);
    }

    public static void listAll() {
        db.values().forEach(System.out::println);
    }

    public static Optional<IncomeStatement> findByID(String CPF) {
        if (!db.containsKey(CPF)) throw new NoSuchElementException("O contribuidor não existe");
        return Optional.ofNullable(db.get(CPF));
    }
}
