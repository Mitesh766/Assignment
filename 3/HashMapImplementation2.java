

import java.util.LinkedList;


public class HashMapImplementation2 {
     static class MyHashMap<K, V> {
        int DEFAULT_CAPACITY = 4;
        float DEFAULT_LOAD_FACTOR = 0.75F;

        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;

            }
        }

        LinkedList<Node>[] buckets;

        private void initBuckets(int n) {
            buckets = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                buckets[i] = new LinkedList<Node>();
            }
        }

        private int hashFunction(K key) {
            int hash = key.hashCode();
            int finalHashCode = Math.abs(hash) % buckets.length;
            return finalHashCode;
        }

        private int search(LinkedList<Node> currBucket, K key) {
            for (int i = 0; i < currBucket.size(); i++) {
                if (currBucket.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        MyHashMap() {
            initBuckets(DEFAULT_CAPACITY);
        }

        public void resize() {


        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            LinkedList<Node> currentBucket = buckets[bi];
            int sc = search(currentBucket, key);
            if (sc == -1) {
                Node newNode = new Node(key, value);
                currentBucket.add(newNode);
            } else {
                currentBucket.get(sc).value = value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int sc = search(currBucket, key);
            if (sc != -1) {
                return currBucket.get(sc).value;
            }
            return null;
        }

        public V delete(K key) {
            int bi = hashFunction(key);
            LinkedList<Node> currBucket = buckets[bi];
            int sc = search(currBucket, key);
            if (sc != -1) {
                Node currNode = currBucket.get(sc);
                V value = currBucket.get(sc).value;
                currBucket.remove(currNode);
                return value;
            }
            return null;

        }

        public void print() {
            int i=0;
            for (var bucket : buckets) {

                for (var node : bucket) {
                    System.out.print(node.value + "--->");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> mp = new MyHashMap<>();
        mp.put("A", 1);
        mp.put("B", 2);
        mp.put("C", 3);
        mp.put("D", 4);
        mp.put("E",5);
        mp.put("F",6);

        mp.print();
    }

}