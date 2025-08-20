package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class GenericDAO<T> extends GenericDao<<ID> { //N É DOMAIIN?

    private final List<T> db = new ArrayList<>(); //oq é o t? é o tipo ou argumento

    public T save(T domain){
        db.add(domain);
        return domain;
    }

    public T update(T domain){
        var stored = db.stream().filter(d -> d.equals(domain))
            .findFirst().orElseThrow();
        db.remove(stored);
        return save(domain);
    }

    public boolean delete(T domain){
        return db.remove(domain);
    }

    public Optional<T> find(Predicate<T> filterCallback){
        return db.stream().filter(filterCallback).findFirst(); //se não encontrar um Optional vazio
    }

    public List<T> findAll(){
        return db;
    }

    public int count(){
        return db.size();
    }
}
