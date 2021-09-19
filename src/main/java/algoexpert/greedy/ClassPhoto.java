package algoexpert.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassPhoto {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        boolean isRedTaller = false;
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        for(int i =0;i<blueShirtHeights.size();i++){
            if(redShirtHeights.get(i)>blueShirtHeights.get(i)){
                isRedTaller = true;
                break;
            }else if(blueShirtHeights.get(i)>redShirtHeights.get(i)){
                break;
            }else{
                return false;
            }
        }

        for(int i =1;i<blueShirtHeights.size();i++){
            if(isRedTaller && blueShirtHeights.get(i)>redShirtHeights.get(i)){
                return false;
            }
            if(!isRedTaller && blueShirtHeights.get(i)<redShirtHeights.get(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> red = new ArrayList<>();
        ArrayList<Integer> blue = new ArrayList<>();
        red.add(6);red.add(9);red.add(2);red.add(4);red.add(5);red.add(1);
        blue.add(5);blue.add(8);blue.add(1);blue.add(3);blue.add(4);blue.add(9);
        ClassPhoto obj = new ClassPhoto();
        System.out.println(obj.classPhotos(red,blue));
    }
}
