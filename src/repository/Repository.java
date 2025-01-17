package repository;

import model.Entity;

import repository.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository<T extends Entity> implements IRepository<T> {

    private List<T> data;

    /**
     * Represents a Map that stores the class and then an instance of InMemoryRepo.
     * Used to keep the same instance over all Services and Controllers throughout the App
     */
    private static final Map<Class<?>, Repository<?>> instances = new HashMap<>();

    private Repository() {
        data = new ArrayList<T>();
    }

    /**
     * Adds an object to the repository
     * @param obj to be added
     */
    @Override
    public void create(T obj) {
        data.add(obj);
    }


    /**
     * Searches for an object in the repository
     * @param id of the searched object
     * @return the found object, or null if there is no object found
     */
    @Override
    public T read(int id) {
        for (T obj : data) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    /**
     * Updates the data of an object
     * @param obj the new obj that will be saved
     */
    @Override
    public void update(T obj) {
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getId() == obj.getId()){
                data.set(i,obj);
            }
        }
    }

    /**
     * Removes data from the repository
     * @param id of the object to be removed
     */
    @Override
    public void delete(int id) {
        data.removeIf(obj -> obj.getId() == id);
        //data.removeIf(obj -> obj.getId() == id);
        //Might be able to do the same thing using remove and the equals operator inside the class.
    }

    /**
     * @return All the data found in the repository
     */
    @Override
    public List<T> getAll() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * Used for keeping the same instance of InMemoryRepo
     * @param type data type of the Repo
     * @return instance of InMemoryRepo that uses type parameter
     * @param <T> class that inherits Entity
     * @see Entity
     */
    @SuppressWarnings("unchecked")
    public static synchronized <T extends Entity> Repository<T> getInstance(Class<T> type) {

        //Checks if an instance of this type of Class exists
        if (!instances.containsKey(type)) {
            instances.put(type, new Repository<>());
        }

        return (Repository<T>) instances.get(type);
    }

    /**
     * NOT IN USE YET
     * @return the first available id in the current repository
     */
    private int getFirstAvailableId() {
        return 1;
    }

    @Override
    public int getNextId(){
        int id = 0;
        for( Entity entity : getAll()){
            if(entity.getId() > id){
                id = entity.getId();
            }
        }
        return id + 1;

    }
}
