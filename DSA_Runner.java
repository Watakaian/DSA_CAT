public class DSA_Runner {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   DSA AUTOMATED DEMONSTRATION RUNNER    ");
        System.out.println("==========================================");
        
        System.out.println("\n[1] RUNNING ARRAY-BASED DATA STRUCTURES DEMO");
        ArrayBasedDataStructures.main(new String[0]);
        
        System.out.println("\n[2] RUNNING LINKED-LIST-BASED DATA STRUCTURES DEMO");
        LinkedListBasedDataStructures.main(new String[0]);
        
        System.out.println("\n[3] RUNNING ARRAY-BASED LINKED LIST DEMO");
        ArrayLinkedList.main(new String[0]);
        
        System.out.println("\n[4] RUNNING BUILT-IN JAVA COLLECTIONS DEMO");
        BuiltInDataStructuresDemo.main(new String[0]);
        
        System.out.println("\n==========================================");
        System.out.println("   ALL AUTOMATED DEMOS COMPLETED!         ");
        System.out.println("   ENTERING INTERACTIVE MODE...           ");
        System.out.println("==========================================");
        
        CLI.main(args);
    }
}
