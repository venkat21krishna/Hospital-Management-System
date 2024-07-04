import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyClass implements Serializable {
    int x;

    public MyClass(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        try {
            // Serialization
            MyClass obj = new MyClass(10);
            FileOutputStream fileOut = new FileOutputStream("myclass.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Object serialized");

            // Deserialization
            FileInputStream fileIn = new FileInputStream("myclass.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MyClass deserializedObj = (MyClass) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object deserialized");
            System.out.println("Value of x: " + deserializedObj.x);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
