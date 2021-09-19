package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

class Entry{
    int key;
    int val;
    Entry pre;
    Entry post;
}
public class LRUCache {
    Map<Integer,Entry> map ;
    int LRU_SIZE;
    Entry start,end;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        LRU_SIZE = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            removeNode(entry);
            addNode(entry);
            return entry.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.val=value;
            removeNode(entry);
            addNode(entry);
        }else{
            Entry newNode = new Entry();
            newNode.pre = null;
            newNode.post = null;
            newNode.key = key;
            newNode.val = value;

            if(map.size() >=LRU_SIZE){
                map.remove(end.key);
                removeNode(end);
                addNode(newNode);
            }else {
                addNode(newNode);
            }
            map.put(key,newNode );
        }

    }
    private void removeNode(Entry entry){
        if(entry.pre !=null){
            entry.pre.post = entry.post;
        }else{
            start = entry.post;
        }

        if(entry.post !=null){
            entry.post.pre= entry.pre;
        }else{
            end = entry.pre;
        }
    }
    private void addNode(Entry entry){
        entry.pre = null;
        entry.post = start;
        if(start !=null){
            start.pre = entry;
        }
        start = entry;
        if(end == null){
            end = entry;
        }
    }
}
