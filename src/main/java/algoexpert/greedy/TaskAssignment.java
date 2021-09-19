package algoexpert.greedy;

import java.util.*;

public class TaskAssignment {
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<tasks.size();i++){
            int num = tasks.get(i);
            if(map.containsKey(num)){
                List<Integer> list = map.get(num);
                list.add(i);
                map.put(num,list);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num,list);
            }
        }
        Collections.sort(tasks);
        for(int i=0,j=tasks.size()-1;i<tasks.size()/2;i++,j--){
            ArrayList<Integer> onePair = new ArrayList<>();
            int num1 = tasks.get(i);
            int num2 = tasks.get(j);
            onePair.add(updateMap(map, num1));
            onePair.add(updateMap(map,num2));
            result.add(onePair);
        }
        return result;
    }

    private int updateMap(Map<Integer, List<Integer>> map, int num) {
        int result;
        List<Integer> list = map.get(num);
        result= list.get(0);
        list.remove(0);
        if(list.size() == 0){
            map.remove(num);
        }else{
            map.put(num,list);
        }
        return result;
    }

    public static void main(String[] args) {
        int k =3;
        ArrayList<Integer> tasks = new ArrayList<>();
        tasks.add(1);tasks.add(3);tasks.add(5);tasks.add(3);tasks.add(1);tasks.add(4);
        TaskAssignment obj = new TaskAssignment();
        obj.taskAssignment(k,tasks);
    }
}
