import org.w3c.dom.Node;

class Main {
  public static void main(String[] args) {

    class Node {
      int number;
      Node left;
      Node right;

      public Node(int number){
        this.number = number;
        left = right = null;
      }
    }
    class BST {
      Node root;

      BST(){
        root = null;
      }
      
      // insert 
      void insert(int number){
        root = insertData(root,number);
      }

      Node insertData(Node root, int number){
        if (root == null){
          root = new Node(number);
          return root;
        }
        if (number < root.number) {
          root.left = insertData(root.left, number);
        } else if (number > root.number) {
          root.right = insertData(root.right, number);
        }
        return root;
      }

      //delete
      void delete(int number){
        root = deleteData(root,number);
      }

      Node deleteData(Node root, int number){
        if (root == null) { return root;}

        if (number < root.number){
          root.left = deleteData(root.left, number);
        } else if (number > root.number){
          root.right = deleteData(root.right, number);
        } else {
          if (root.left == null)
          return root.right;
          
          else if (root.right == null)
          return root.left;

          root.number = minValue(root.right);
          root.right = deleteData(root.right, root.number);
        }

        return root;
      }
      int minValue(Node root){
        int minValue = root.number;
        while (root.left != null){
          minValue = root.left.number;
          root = root.left;
        }
        return minValue;
      }

      //inorder
      public void inorder(){
        inorderRec(root);
        System.out.println();
      }
      void inorderRec(Node root){
        if (root != null) {
          inorderRec(root.left);
          System.out.println(root.number + "");
          inorderRec(root.right);
        }
      }

      //postorder
      public void postorder(){
        postorderRec(root);
        System.out.println();
      }
      void postorderRec(Node root){
        if (root != null){
          postorderRec(root.left);
          postorderRec(root.right);
          System.out.print(root.number + " ");
        }
      }

      //preorder
      public void preorder(){
        pretorderRec(root);
        System.out.println();
      }
      void pretorderRec(Node root){
        if (root != null){
          System.out.print(root.number + " ");
          postorderRec(root.left);
          postorderRec(root.right);
        }
      }

      //search
      public boolean search(int e) {
        return searchRec(root,e);
      }
      private boolean searchRec(Node root, int e){
        if (root == null || root.number == e) {
          return root != null;
      }
      if (e > root.number) {
        return searchRec(root.right, e);
    }
      return searchRec(root.right,e);
      }

    //path
    public void path(int number) {
      System.out.println("Path from root to " + number + ": ");
      if(!pathRec(root, number)){
        System.out.println("No path found for number: " + number);
      }
      System.out.println();
    }

    boolean pathRec(Node root, int number){
      if (root == null){
        return false;
      }
      System.out.print(root.number + " ");

      if(root.number == number){
        return true;
      }
      if (root.number > number){
        return pathRec(root.left, number);
      }
      return pathRec(root.right, number);
    }
  


    } //BST class close

    // Step 1 - Create a BST tree object called lab5Tree
      BST lab5Tree = new BST();

    // Step 2 - Insert the following values: 13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10
     lab5Tree.insert(13);
     lab5Tree.insert(22);
     lab5Tree.insert(36);
     lab5Tree.insert(5);
     lab5Tree.insert(48);
     lab5Tree.insert(17);
     lab5Tree.insert(39);
     lab5Tree.insert(2);
     lab5Tree.insert(26);
     lab5Tree.insert(40);
     lab5Tree.insert(29);
     lab5Tree.insert(34);
     lab5Tree.insert(10);

    // Step 3 - Delete the value 17
    lab5Tree.delete(17);

    // Step 4 - Traverse and output the values using inorder (sorted)
    System.out.print("Inorder (sorted): ");
    lab5Tree.inorder();

    // Step 5 - Traverse and output the values using postorder
    System.out.print("Postorder: ");
    lab5Tree.postorder();

    // Step 6 - Traverse and output the values using preorder
    System.out.print("Preorder: ");
    lab5Tree.preorder();

    // Step 7 - Display the result of a search for the value 36
    System.out.println("Search for 36: " + lab5Tree.search(36));

    // Step 8 - Display the result of a search for the value 37
    System.out.println("Search for 37: " + lab5Tree.search(37));

    // Step 9 - Using the path() method, display the path from the root to 2
    lab5Tree.path(2);

    // Step 10 - Display the path from the root to 34
    lab5Tree.path(34);

  }
}