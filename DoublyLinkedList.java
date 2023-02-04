import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class DoublyLinkedList {
    // node creation
    Node head;
    Node tail;

        // insert node at the front
        public void insertFront(Character ch) {
            // allocate memory for newNode and assign data to newNode
            Node newNode = new Node(ch);

            // make newNode as a head
            newNode.next = head;

            // assign null to prev of newNode
            newNode.prev = null;

            // previous of head (now head is the second node) is newNode
            if (head != null)
                head.prev = newNode;

            // head points to newNode
            head = newNode;
        }

        //Finds The Node In The Scecified Position Inside
        //The List And Returns The Node
        public Node FindNode(long position) {
            Node i = null;
            long count = 0;
            for (i = head; i != null; i = i.next) {

                if (position == count) {
                    return i;
                } else {
                    count++;
                }
            }

            if (i == null) {
                System.out.println("FindNode Function Did not find the node at index " + position);
            }
            return i;
        }

        // insert a node after a specific node
        public void insertAfter(long position, Character chrctr) {

            Node foundNode = FindNode(position);
            Node newNode = new Node(chrctr);

            if (foundNode.next != null) {
                foundNode.next = newNode;
                newNode.next.prev = newNode;
            } else if (foundNode.next == null) {
                newNode.prev = foundNode;
                newNode.next = null;
                tail = newNode;
            }
        }

        // insert a newNode at the end of the list
        public void insertEnd(Character ch) {
            // allocate memory for newNode and assign data to newNode
            Node new_node = new Node(ch);

            // store the head node temporarily (for later use)
            Node temp = head;

            // assign null to next of newNode
            new_node.next = null;

            // if the linked list is empty, make the newNode as head node
            if (head == null) {
                new_node.prev = null;
                head = new_node;
                return;
            }

            // if the linked list is not empty, traverse to the end of the linked list
            while (temp.next != null)
                temp = temp.next;

            // assign next of the last node (temp) to newNode
            temp.next = new_node;

            // assign prev of newNode to temp
            new_node.prev = temp;
        }

        public void insertEnd(Node nd)
        {
            // allocate memory for newNode and assign data to newNode
            Node new_node = nd;

            // store the head node temporarily (for later use)
            Node temp = head;

            // assign null to next of newNode
            new_node.next = null;

            // if the linked list is empty, make the newNode as head node
            if (head == null) {
                new_node.prev = null;
                head = new_node;
                return;
            }

            // if the linked list is not empty, traverse to the end of the linked list
            while (temp.next != null)
                temp = temp.next;

            // assign next of the last node (temp) to newNode
            temp.next = new_node;

            // assign prev of newNode to temp
            new_node.prev = temp;

        }

        // delete a node from the doubly linked list
        public void deleteNode(Node del_node) {

            // if head or del is null, deletion is not possible
            if (head == null || del_node == null) {
                if (del_node == null) {
                    System.out.println("Error, Node Given Is Null");
                } else if (head == null) {
                    System.out.println("Error, Doubly Linked List Is Empty!");
                }
                return;
            }

            // if del_node is the head node, point the head pointer to the next of del_node
            if (head == del_node) {
                head = del_node.next;
            }

            // if del_node is not at the last node, point the prev of node next to del_node
            // to the previous of del_node
            if (del_node.next != null) {
                del_node.next.prev = del_node.prev;
            }

            // if del_node is not the first node, point the next of the previous node to the
            // next node of del_node
            if (del_node.prev != null) {
                del_node.prev.next = del_node.next;
            }

        }

        //Sorts The List According To The Frequency A Character Is
        //Inserted
        public void SortCharFrequency()
        {
            Node x = null;
            int min, max;

            max = Integer.MAX_VALUE;
            min = Integer.MIN_VALUE;

            for(Node i = head; i != null; i = i.next)
            {
                for(x = head; x != null; x = x.next)
                {
                    if((x.next != null) && (x.next.timesFound > x.timesFound))
                    {
                        //Swap(x.next.data,x.data);

                        Set<Character> set1 = x.next.data.keySet();
                        ArrayList<Character> arrlist = new ArrayList<>(set1);
                        Iterator<Character> it = arrlist.iterator();

                        char [] charArr1 = new char[arrlist.size()];
                        for(int n = 0; it.hasNext(); n++)
                        {
                            charArr1[n] = it.next();
                        }
                        char key_map = charArr1[0];
                        Integer value_map = x.next.data.get(key_map);

                        //map2 attributes
                        Set<Character> set2 = x.data.keySet();
                        ArrayList<Character> arraylist2 = new ArrayList<>(set2);
                        Iterator<Character> it2 = arraylist2.iterator();

                        char[] charArr2 = new char[arraylist2.size()];
                        char key_map2;
                        Integer value_map2;
                        for(int n = 0; it2.hasNext(); n++)
                        {
                            charArr2[n] = it2.next();
                        }
                        key_map2 = charArr2[0];
                        value_map2 = x.data.get(key_map2);
                        ;
                        if(Integer.compare(value_map,value_map2) > 0)
                        {
                            //Swap Section
                            x.next.data.clear();
                            x.next.data.put(key_map2,value_map2);

                            x.data.clear();
                            x.data.put(key_map,value_map);
                            int temp2 = x.timesFound;
                            x.timesFound = x.next.timesFound;
                            x.next.timesFound = temp2;

                            //End Of Swap Section

                        }
                    }
                }
            }
        }

        public void SortCharName()
        {
            Node j = null;
            char max = (char) 127;
            Node i = null;
            Node piv = null;
            for(i = head; i != null; i = i.next)
            {
                for(j = i; j != null; j = j.next)
                {
                    char key = GetKey(j.data);
                    if(key < max)
                    {
                        Set<Character> set1 = i.data.keySet();
                        ArrayList<Character> arrlist = new ArrayList<>(set1);
                        Iterator<Character> it = arrlist.iterator();

                        char [] charArr1 = new char[arrlist.size()];
                        for(int n = 0; it.hasNext(); n++)
                        {
                            charArr1[n] = it.next();
                        }
                        char key_map = charArr1[0];
                        Integer value_map = i.data.get(key_map);

                        //map2 attributes
                        Set<Character> set2 = j.data.keySet();
                        ArrayList<Character> arraylist2 = new ArrayList<>(set2);
                        Iterator<Character> it2 = arraylist2.iterator();

                        char[] charArr2 = new char[arraylist2.size()];
                        char key_map2;
                        Integer value_map2;
                        for(int n = 0; it2.hasNext(); n++)
                        {
                            charArr2[n] = it2.next();
                        }
                        key_map2 = charArr2[0];
                        value_map2 = j.data.get(key_map2);
                        ;
                        if(Character.compare(key_map2,key_map) < 0)
                        {
                            //Swap Section
                            i.data.clear();
                            i.data.put(key_map2,value_map2);

                            j.data.clear();
                            j.data.put(key_map,value_map);
                            int temp = i.timesFound;
                            i.timesFound = j.timesFound;
                            j.timesFound = temp;

                            //End Of Swap Section

                        }
                        else {

                        }
                    }
                }
            }
        }

        public char GetKey(HashMap<Character,Integer> hash)
        {
            Set<Character> set1 = hash.keySet();
            ArrayList<Character> arrlist = new ArrayList<>(set1);
            Iterator<Character> it = arrlist.iterator();

            char [] charArr1 = new char[arrlist.size()];
            for(int n = 0; it.hasNext(); n++)
            {
                charArr1[n] = it.next();
            }
            char key_map = charArr1[0];
            return key_map;
        }
        public void Swap(HashMap<Character,Integer> hash1, HashMap<Character,Integer> hash2)
        {
            //map1 attributes
            Set<Character> set1 = hash1.keySet();
            ArrayList<Character> arrlist = new ArrayList<>(set1);
            Iterator<Character> it = arrlist.iterator();

            char [] charArr1 = new char[arrlist.size()];
            for(int n = 0; it.hasNext(); n++)
            {
                charArr1[n] = it.next();
            }
            char key_map = charArr1[0];
            Integer value_map = hash1.get(key_map);

            //map2 attributes
            Set<Character> set2 = hash2.keySet();
            ArrayList<Character> arraylist2 = new ArrayList<>(set2);
            Iterator<Character> it2 = arraylist2.iterator();

            char[] charArr2 = new char[arraylist2.size()];
            char key_map2;
            Integer value_map2;
            for(int n = 0; it2.hasNext(); n++)
            {
                charArr2[n] = it2.next();
            }
            key_map2 = charArr2[0];
            value_map2 = hash2.get(key_map2);

            if(key_map2 < key_map)
            {
                //Swap Section
                hash1.clear();
                hash1.put(key_map2,value_map2);

                hash2.clear();
                hash2.put(key_map,value_map);
                //End Of Swap Section
            }
            else {
                return;
            }
        }

        public boolean charExists(char ch, Node nd)
        {
            boolean found = false;
            Node tmp = head;

            while(!(found) && (tmp != null))
            {
                Set<Character> set1 = tmp.data.keySet();
                ArrayList<Character> arrlist = new ArrayList<>(set1);
                Iterator<Character> it = arrlist.iterator();

                char [] charArr1 = new char[arrlist.size()];
                for(int n = 0; it.hasNext(); n++)
                {
                    charArr1[n] = it.next();
                }
                char key_map = charArr1[0];
                Integer value_map = tmp.data.get(key_map);

                if(key_map == ch)
                {
                    found = true;
                    nd = tmp;
                }
                else
                {
                    nd.data = tmp.data;
                    nd.timesFound = tmp.timesFound;
                    tmp = tmp.next;
                    nd = tmp;
                    continue;
                }
                return found;
            }
            return found;
        }

    public Node charExistsRetNode(char ch, Node nd)
    {
        boolean found = false;
        Node tmp = head;

        while(!(found) && (tmp != null))
        {
            Set<Character> set1 = tmp.data.keySet();
            ArrayList<Character> arrlist = new ArrayList<>(set1);
            Iterator<Character> it = arrlist.iterator();

            char [] charArr1 = new char[arrlist.size()];
            for(int n = 0; it.hasNext(); n++)
            {
                charArr1[n] = it.next();
            }
            char key_map = charArr1[0];
            Integer value_map = tmp.data.get(key_map);

            if(key_map == ch)
            {
                found = true;
                nd = tmp;
            }
            else
            {
                tmp = tmp.next;
                nd = tmp;
                continue;
            }
            return nd;
        }
        return nd;
    }


    //Increases the timesFound counter by one and
        //Disintegrates n.data HashMap And Then After The
        //Incrementation Of Hash's Value Puts The Values Back In
        public void increaseCharNumFound(Node n)
        {
            if (n.timesFound == 0) {
                n.timesFound = 1; //An Entry Allready exists For Func To Be Here
                char key_hash = GetKey(n.data);
                int value = n.data.get(key_hash);
                value++;
                n.data.clear();
                n.data.put(key_hash, value);
            }
            else
            {
                n.timesFound++;
                char key_hash = GetKey(n.data);
                int value = n.data.get(key_hash);
                value++;
                n.data.clear();
                n.data.put(key_hash, value);
            }

        }

        // print the doubly linked list and show characters percentage
        // of occurrence. Worth mentioned is the fact that it also sorts the list
        public void printlist(int totalTextCharCount) {

            SortCharFrequency();

            for(Node i = head; i != null; i = i.next)
            {
                Node tmp = i;
                char key_hash = GetKey(tmp.data);
                if(!(key_hash == ' '))
                {
                    System.out.print(key_hash + " ");
                }
                else
                {
                    System.out.print("KENO" + " ");
                }
                float d = (((float)i.timesFound *100) / (float)totalTextCharCount);
                System.out.println(d+"%");
            }
        }
    }