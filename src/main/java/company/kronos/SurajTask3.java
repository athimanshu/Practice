package company.kronos;


public class SurajTask3 {
    interface ListNode {
        int getItem();
        ListNode getNext();
        void setNext(ListNode next);
    }
    static class ListNodeClass implements ListNode{
        int item;
        ListNode next;
        ListNodeClass(){

        }
        ListNodeClass(int item){
            this.item = item;
        }
        @Override
        public int getItem() {
            return this.item;
        }

        @Override
        public ListNode getNext() {
            return this.next;
        }

        @Override
        public void setNext(ListNode next) {
            this.next = next;
        }
    }
    public static ListNode reverse(ListNode node) {

        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        ListNode list = new ListNodeClass(5);
        list.setNext(new ListNodeClass(8));
        list.getNext().setNext(new ListNodeClass(9));
        list.getNext().getNext().setNext(new ListNodeClass(12));

        ListNode result = reverse(list);
        while(result !=null){
            System.out.println(result.getItem());
            result = result.getNext();
        }
    }
}
