package leetcode.medium;


import java.util.LinkedList;

class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s, int k) {
        int[] count = new int[s.length()];

        StringBuilder sb = new StringBuilder();
        for(Character c: s.toCharArray()){
            sb.append(c);
            int last = sb.length()-1;
            count[last] = 1 + (last>0 && sb.charAt(last-1)==sb.charAt(last)?count[last-1]:0);
            if(count[last]>=k){
                sb.delete(sb.length()-k,sb.length());
            }
        }
        return sb.toString();
     /*   // LinkedList will be more efficient than Stack because Stack has to reallocate when size over capacity
        LinkedList<Adjacent> st = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty() || st.peek().ch != c) {
                st.push(new Adjacent(c, 1));
            } else {
                st.peek().freq++;
            }
            if (st.peek().freq == k)
                st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            Adjacent peek = st.pop();
            sb.append(String.valueOf(peek.ch).repeat(peek.freq));// java 11 feature
        }
        return sb.reverse().toString();*/
    }

    class Adjacent {
        char ch;
        int freq;

        public Adjacent(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}