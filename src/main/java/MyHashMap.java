import java.util.ArrayList;
import java.util.List;

/**
 * Insertion
 * Deletion
 * Accessing
 */
public class MyHashMap {
    private static int SIZE = 16;
    Object key;
    Object value;
    int[] hashTable = new int[SIZE];
    List<Object> data = new ArrayList<>();
    double loadFactor = 0.75;

    MyHashMap(double loadFactor,int size){
        this.SIZE = size;
        this.loadFactor = loadFactor;
    }
    MyHashMap(int size){
        this.SIZE = size;
    }

    public void put(Object key, Object value){
        int pos = getHash(key);
        data.add(pos,value);
        if(data.size() >= hashTable.length*loadFactor){
            createNewList(data,hashTable);
        }
    }



    public Object get(Object key){
        int pos = getHash(key);
        return data.get(pos);
    }

    public boolean remove(Object key){
        int pos = getHash(key);
        if(data.get(pos) == null)
            return false;
        else
            removeFromDataList(pos,data);
        return true;
    }



    private int getHash(Object key){

        int hashValue = calculateHash(key);
        return hashValue%SIZE;
    }

    /**
     * This function just calcualte the hash value of a key
     * @param key
     */
    private int calculateHash(Object key) {
        return 0;
    }

    private void createNewList(List<Object> data, int[] hashTable) {
    }

    private void removeFromDataList(int pos, List<Object> data) {

    }

}
