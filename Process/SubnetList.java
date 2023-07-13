package Process;

public class SubnetList {
    protected Subnet head;
    private int length;
    private class Subnet {
        private String SubnetMask;
        private Subnet next;
        public Subnet(String SubnetMask) {
            this.SubnetMask = SubnetMask;
            this.next = null;
        }
    }

    public SubnetList() {
        this.head = null;
        this.length = 0;
    }

    public int length() {return length;}
    public boolean isEmpty() {return length == 0;}

    public void addSubnetMask (String SubnetMask) {
        Subnet Subnet = new Subnet(SubnetMask);

        Subnet.next = head;
        head = Subnet;
        length++;
    }
    
    public void display () {
        Subnet temp = head;

        while (temp != null) {
            System.out.print("[" + temp.SubnetMask + "] -->");
            temp = temp.next;
        }
        System.out.print("null");
        DefaultText.Jump();
    }
}
