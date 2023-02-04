import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        DoublyLinkedList list = new DoublyLinkedList();
        File file = new File("c:/Users/me/Documents/endeiktiko keimeno.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        int charCount = 0;
        Node node = null;
        Node i;


        int f = 0;

        while((f = br.read()) != -1)
        {
            char x = (char) f;
            node = new Node(x);
            int unicodeRepresentation = (int)x;


                if (list.charExists(x,node))
                {
                    i = list.charExistsRetNode(x,node);
                    list.increaseCharNumFound(i);
                }
                else if ((charCount == 0) && (!(list.charExists(x,node))))
                {
                    list.insertFront(x);
                }
                else if ((charCount > 0) && (!(list.charExists(x,node))))
                {
                    list.insertEnd(x);
                }
                charCount++;

        }
        list.printlist(charCount);
    }
}