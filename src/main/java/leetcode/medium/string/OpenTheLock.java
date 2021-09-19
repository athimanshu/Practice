package leetcode.medium.string;

import java.util.*;

public class OpenTheLock {
    private static final String START = "0000";
    public int openLock(String[] deadends, String target) {
        if(target == null || target.length() == 0) return -1;
        Set<String> visitedLocks = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer(START);
        int level =0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String currentLock = queue.poll();

                if(!visitedLocks.contains(currentLock)) continue;
                if(currentLock.equals(target)) return level;

                for(String lock: getNextStates(currentLock)){
                    if(!visitedLocks.contains(lock))
                        queue.offer(lock);
                }
            }
            level++;
        }
        return -1;
    }
    private List<String> getNextStates(String lock) {
        List<String> locks = new LinkedList<>();
        char[] arr = lock.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            arr[i] = c == '9'?'0': (char) (c + ((char)1));
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        return locks;
    }
}
