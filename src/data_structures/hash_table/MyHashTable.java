package hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class MyHashTable {
    private ArrayList<KeyValue>[] data;
    private int keyLength;
    private int dataLength;

    public MyHashTable(int size){
        data = new ArrayList[size];
        dataLength = 0;
    }

    private int _hash(String key){
        int hash = 0;
        for(int i=0; i<key.length(); i++){
            hash = (hash + key.codePointAt(i) * i) % data.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int address = _hash(key);
        if(data[address] == null){
            data[address] = new ArrayList<KeyValue>();
            dataLength++;
        }

        KeyValue pair = new KeyValue(key,value);
        data[address].add(pair);
        keyLength++;
    }

    public Integer get(String key){
        int address = _hash(key);
        ArrayList<KeyValue> bucket = data[address];

        if(bucket!=null){
            for(KeyValue k : bucket){
                if(k.getKey().equalsIgnoreCase(key)){
                    return k.getValue();
                }
            }
        }
        return null; //if value does not exist
    }

    public String[] keys(){
        ArrayList<KeyValue>[] bucket = data;
        String[] keysArray = new String[keyLength];
        int count =0;
        for (ArrayList<KeyValue> keyValues : bucket){
            if (keyValues !=null){
                if(keyValues.size()==1){
                    keysArray[count] = keyValues.get(0).getKey();
                    count++;
                }else {
                    int l = keyValues.size();
                    for(int i=0; i<l; i++){
                        keysArray[count] = keyValues.get(i).getKey();
                        count++;
                    }
                }
            }
        }
        return keysArray;
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(10);
        hashTable.set("grapes", 1200);
        hashTable.set("apple", 1500);
        //hashTable.set("apple", 23);
        hashTable.set("banana", 200);
        hashTable.set("coconut", 50);
        System.out.println("value for key grapes: " + hashTable.get("grapes"));
        System.out.println("value for key apple: " + hashTable.get("apple"));
        //System.out.println("value for key apple: " + hashTable.get("apple"));
        System.out.println("value for key banana: " + hashTable.get("banana"));
        System.out.println("value for key coconut: " + hashTable.get("coconut"));
        System.out.println("list of keys: " + Arrays.toString(hashTable.keys()));

    }
}
