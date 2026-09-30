package LRU;

import java.util.*;

public class Main {

    // Node of Doubly Linked List
    static class Node {

        int val;
        int key;

        Node prev;
        Node next;

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    static class LRUCache {

        Node head;
        Node tail;

        Map<Integer, Node> map;

        int capacity;

        // Constructor
        public LRUCache(int capacity) {

            this.capacity = capacity;

            map = new HashMap<>();

            // Dummy nodes
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // Get value
        public int get(int key) {

            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);

            // Make this node most recently used
            putHead(node);

            return node.val;
        }

        // Put key-value
        public void put(int key, int value) {

            // Key already exists
            if (map.containsKey(key)) {

                Node node = map.get(key);

                // Update value
                node.val = value;

                // Move to front
                putHead(node);

            }

            // New key
            else {

                Node newNode = new Node(value, key);

                map.put(key, newNode);

                // Add as most recently used
                addHead(newNode);

                // Capacity exceeded
                if (map.size() > capacity) {

                    // Least recently used node
                    Node lru = tail.prev;

                    remove(lru);

                    map.remove(lru.key);
                }
            }
        }

        // Remove node from linked list
        public void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Add node immediately after head
        public void addHead(Node node) {

            node.next = head.next;

            head.next.prev = node;

            head.next = node;

            node.prev = head;
        }

        // Move existing node to head
        public void putHead(Node node) {

            remove(node);

            addHead(node);
        }

        // Display cache
        public void display() {

            Node temp = head.next;

            System.out.print("Cache: ");

            while (temp != tail) {

                System.out.print(
                    "[" + temp.key + ":" + temp.val + "] "
                );

                temp = temp.next;
            }

            System.out.println();
        }

        // Display HashMap
        public void displayMap() {

            System.out.println("Map: " + map);
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        System.out.println("LRU Cache Capacity = 2");

        System.out.println();

        cache.put(1, 10);
        cache.display();

        cache.put(2, 20);
        cache.display();

        System.out.println("get(1) = " + cache.get(1));
        cache.display();

        cache.put(3, 30);
        cache.display();

        System.out.println("get(2) = " + cache.get(2));
        cache.display();

        cache.put(4, 40);
        cache.display();

        System.out.println("get(1) = " + cache.get(1));
        System.out.println("get(3) = " + cache.get(3));
        System.out.println("get(4) = " + cache.get(4));

        cache.display();
    }
}