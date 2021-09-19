package interviewBit.graphs;

import java.util.ArrayList;

public class DetectCycle {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        int[] p=new int[A+1];
        for(int i=1;i<=A;i++)
        {
            p[i]=i;
        }
        for(int i=0;i<B.size();i++)
        {
            int sp=find(B.get(i).get(0),p);
            int dp=find(B.get(i).get(1),p);
            if(sp==dp)
            {
                return 1;
            }
            else
            {
                p[B.get(i).get(1)]=B.get(i).get(0);
            }
        }
        return 0;
    }
    public int find(int a,int[] p)
    {
        if(p[a]==a)
        {
            return a;
        }
        return p[a]=find(p[a],p);

    }

}
