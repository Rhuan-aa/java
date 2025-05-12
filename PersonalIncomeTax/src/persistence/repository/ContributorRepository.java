package persistence.repository;

import model.Contributor;
import persistence.input.InputContributor;
import persistence.input.InputFactory;

import java.util.*;

public class ContributorRepository{
    private static final Map<String, Contributor> db = new HashMap<>();

    public static void save(String CPF, Contributor contributor) {
        Objects.requireNonNull(contributor, "O contribuidor não pode ter valor nulo");
        db.putIfAbsent(CPF, contributor);
    }

    public static void update(String CPF) {
        if (!db.containsKey(CPF)) throw new NoSuchElementException("O contribuidor não existe");
        db.replace(CPF, InputFactory.create(new InputContributor()));
    }

    public static void remove(String CPF) {
        if (!db.containsKey(CPF)) throw new NoSuchElementException("O contribuidor não existe");
        db.remove(CPF);
    }

    public static void listAll() {
        db.values().forEach(System.out::println);
    }

    public static Optional<Contributor> findByID(String CPF) {
        if (!db.containsKey(CPF)) throw new NoSuchElementException("O contribuidor não existe");
        return Optional.ofNullable(db.get(CPF));
    }
}
