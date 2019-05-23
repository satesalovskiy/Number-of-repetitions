package asdf;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Numbers  {

    private static int SPACE_SYMBOL = 32;
    private static int NEWLINE_SYMBOL_1 = 10;
    private static int NEWLINE_SYMBOL_2 = 13;

    int o;
    String txt = new String();
    FileInputStream Source;
    Scanner in = new Scanner(System.in);

    void Read (String name) throws FileNotFoundException
    {
        Source = new FileInputStream(name);
    }


    void Start(String name) throws  IOException
    {

        Read (name);

        System.out.println("Input file name: ");

        String name1 = in.next();

        FileWriter Result = new FileWriter(name1);

        while ((o = Source.read()) != -1) {
            if ((o != NEWLINE_SYMBOL_2) && (o != NEWLINE_SYMBOL_1) && (o != SPACE_SYMBOL)) {
                txt = txt + (char) o;
                // System.out.println(o);
            }
        }


            // System.out.println(txt);

            Map<Character, Integer> map = new HashMap<Character, Integer>(40);

            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);

                } else {
                    map.put(c, 1);
                }
            }

            Source.close();


            for (Map.Entry<Character, Integer> item : map.entrySet()) {

                System.out.printf("Key: %c  Value: %d \n", item.getKey(), item.getValue());

                Result.write(item.getKey());

                Result.write('=');

                String s = Integer.toString(item.getValue());

                Result.write(s);

                Result.write(' ');

                Result.write(System.lineSeparator());
            }

            Result.close();
        }
    }

