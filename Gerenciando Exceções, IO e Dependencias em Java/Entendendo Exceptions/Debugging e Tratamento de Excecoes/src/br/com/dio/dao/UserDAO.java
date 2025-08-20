package br.com.dio.dao;

import br.com.dio.exception.EmptyStorageException;
import java.util.ArrayList;
import java.util.List;
import br.com.dio.model.UserModel;

public class UserDAO {
    private long nextId = 1L;

    public final List<UserModel> models = new ArrayList<>();
    
    public UserModel save(final UserModel model){
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete (final long id){
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final long id){
        verifyStorage();
        var message = String.format("Não existe usuário com o id %s cadastrado", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(message)); // Use RuntimeException if UserNotFoundException is not defined
    }

    public List<UserModel> findAll(){
        List<UserModel> result = null;
        try {
            verifyStorage();
            result = models;
        } catch (EmptyStorageException ex) {
            ex.printStackTrace(); //*oq isso faz
            result = new ArrayList<>();
        }
        return result;
    }

    private void verifyStorage(){
        if (models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }
}
