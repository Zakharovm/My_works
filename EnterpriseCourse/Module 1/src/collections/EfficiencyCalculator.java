package collections;

import java.util.*;

public class EfficiencyCalculator {

    private List<Integer> arrayList = new ArrayList<>();
    private List<Integer> linkedList = new LinkedList<>();
    private Set<Integer> hashSet = new HashSet<>();
    private Set<Integer> treeSet = new TreeSet<>();


    protected Map<String, Long> countArrayList(Map<String, Long> timeData, int number) {
        long startTime;
        long endTimePop = 0, endTimeAdd = 0, endTimeGet = 0, endTimeContains = 0, endTimeRemove = 0, endTimeItAdd = 0, endTimeItRemove = 0;

        for (int j = 0; j < 100; j++) {
            arrayList = new ArrayList<>();

            startTime = System.currentTimeMillis();        // populate [ ArrayList ]
            for (int i = 0; i < number; i++) {
                arrayList.add(i);
            }
            endTimePop += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "add" [ ArrayList ]
            arrayList.add(5000, 7777);
            endTimeAdd += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "get" [ ArrayList ]
            arrayList.get(5000);
            endTimeGet += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "contains" [ ArrayList ]
            arrayList.contains(5000);
            endTimeContains += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "remove" [ ArrayList ]
            arrayList.remove(5000);
            endTimeRemove += System.currentTimeMillis() - startTime;


            ListIterator<Integer> iterator = arrayList.listIterator();
            iterator.next();
            startTime = System.currentTimeMillis();        // "Iterator.add" [ ArrayList ]
            iterator.add(99999);
            endTimeItAdd += System.currentTimeMillis() - startTime;


            iterator.next();
            startTime = System.currentTimeMillis();       // "Iterator.remove" [ ArrayList ]
            iterator.remove();
            endTimeItRemove += System.currentTimeMillis() - startTime;

        }

        timeData.put("ArrayList Populate", endTimePop / 100);
        timeData.put("ArrayList Add", endTimeAdd / 100);
        timeData.put("ArrayList Get", endTimeGet / 100);
        timeData.put("ArrayList Contains", endTimeContains / 100);
        timeData.put("ArrayList Remove", endTimeRemove / 100);
        timeData.put("ArrayList Iterator.add()", endTimeItAdd / 100);
        timeData.put("ArrayList Iterator.remove()", endTimeItRemove / 100);
        return timeData;
    }

    protected Map<String, Long> countLinkedList(Map<String, Long> timeData, int number) {
        long startTime;
        long endTimePop = 0, endTimeAdd = 0, endTimeGet = 0, endTimeContains = 0, endTimeRemove = 0, endTimeItAdd = 0, endTimeItRemove = 0;

        for (int j = 0; j < 100; j++) {
            linkedList = new LinkedList<>();

            startTime = System.currentTimeMillis();        // populate [ LinkedList ]
            for (int i = 0; i < number; i++) {
                linkedList.add(i);
            }
            endTimePop += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "add" [ LinkedList ]
            linkedList.add(5000, 7777);
            endTimeAdd += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "get" [ LinkedList ]
            linkedList.get(5000);
            endTimeGet += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "contains" [ LinkedList ]
            linkedList.contains(5000);
            endTimeContains += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "remove" [ LinkedList ]
            linkedList.remove(5000);
            endTimeRemove += System.currentTimeMillis() - startTime;


            ListIterator<Integer> iterator = linkedList.listIterator();
            iterator.next();
            startTime = System.currentTimeMillis();        // "Iterator.add" [ LinkedList ]
            iterator.add(99999);
            endTimeItAdd += System.currentTimeMillis() - startTime;


            iterator.next();
            startTime = System.currentTimeMillis();       // "Iterator.remove" [ LinkedList ]
            iterator.remove();
            endTimeItRemove += System.currentTimeMillis() - startTime;

        }

        timeData.put("LinkedList Populate", endTimePop / 100);
        timeData.put("LinkedList Add", endTimeAdd / 100);
        timeData.put("LinkedList Get", endTimeGet / 100);
        timeData.put("LinkedList Contains", endTimeContains / 100);
        timeData.put("LinkedList Remove", endTimeRemove / 100);
        timeData.put("LinkedList Iterator.add()", endTimeItAdd / 100);
        timeData.put("LinkedList Iterator.remove()", endTimeItRemove / 100);
        return timeData;
    }

    protected Map<String, Long> countHashSet(Map<String, Long> timeData, int number) {
        long startTime;
        long endTimePop = 0, endTimeAdd = 0, endTimeGet = 0, endTimeContains = 0, endTimeRemove = 0, endTimeItAdd = 0, endTimeItRemove = 0;

        for (int j = 0; j < 100; j++) {
            hashSet = new HashSet<>();

            startTime = System.currentTimeMillis();        // populate [ HashSet ]
            for (int i = 0; i < number; i++) {
                hashSet.add(i);
            }
            endTimePop += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "add" [ HashSet ]
            hashSet.add(12000);
            endTimeAdd += System.currentTimeMillis() - startTime;



            startTime = System.currentTimeMillis();        //  "contains" [ HashSet ]
            hashSet.contains(5000);
            endTimeContains += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "remove" [ HashSet ]
            hashSet.remove(5000);
            endTimeRemove += System.currentTimeMillis() - startTime;


            Iterator<Integer> iterator = hashSet.iterator();

            iterator.next();
            startTime = System.currentTimeMillis();       // "Iterator.remove" [ HashSet ]
            iterator.remove();
            endTimeItRemove += System.currentTimeMillis() - startTime;

        }

        timeData.put("HashSet Populate", endTimePop / 100);
        timeData.put("HashSet Add", endTimeAdd / 100);
        timeData.put("HashSet Get", 99999L);
        timeData.put("HashSet Contains", endTimeContains / 100);
        timeData.put("HashSet Remove", endTimeRemove / 100);
        timeData.put("HashSet Iterator.add()", 99999L);
        timeData.put("HashSet Iterator.remove()", endTimeItRemove / 100);
        return timeData;
    }

    protected Map<String, Long> countTreeSet(Map<String, Long> timeData, int number) {
        long startTime;
        long endTimePop = 0, endTimeAdd = 0, endTimeGet = 0, endTimeContains = 0, endTimeRemove = 0, endTimeItAdd = 0, endTimeItRemove = 0;

        for (int j = 0; j < 100; j++) {
            treeSet = new TreeSet<>();

            startTime = System.currentTimeMillis();        // populate [ TreeSet ]
            for (int i = 0; i < number; i++) {
                treeSet.add(i);
            }
            endTimePop += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "add" [ TreeSet ]
            treeSet.add(44444);
            endTimeAdd += System.currentTimeMillis() - startTime;

            startTime = System.currentTimeMillis();        //  "contains" [ TreeSet ]
            treeSet.contains(5000);
            endTimeContains += System.currentTimeMillis() - startTime;


            startTime = System.currentTimeMillis();        //  "remove" [ TreeSet ]
            treeSet.remove(5000);
            endTimeRemove += System.currentTimeMillis() - startTime;


            Iterator<Integer> iterator = treeSet.iterator();

            iterator.next();
            startTime = System.currentTimeMillis();       // "Iterator.remove" [ TreeSet ]
            iterator.remove();
            endTimeItRemove += System.currentTimeMillis() - startTime;

        }

        timeData.put("TreeSet Populate", endTimePop / 100);
        timeData.put("TreeSet Add", endTimeAdd / 100);
        timeData.put("TreeSet Get", 99999L);
        timeData.put("TreeSet Contains", endTimeContains / 100);
        timeData.put("TreeSet Remove", endTimeRemove / 100);
        timeData.put("TreeSet Iterator.add()", 99999L);
        timeData.put("TreeSet Iterator.remove()", endTimeItRemove / 100);
        return timeData;
    }

    protected void printTable(Map<String, Long> data, String collectionType, int number) {
        int counter = 0;
        int quantityOfSpaces;
        Iterator iter = data.values().iterator();

        while (iter.hasNext()) {
            if (counter%7 == 0) {
                System.out.print("\n" + collectionType);
            }
            counter += 1;
            String word = collectionType;
            quantityOfSpaces = 12 - word.length();
            for (int i = 0; i < quantityOfSpaces; i++) {
                System.out.print(" ");
            }
            System.out.printf("|%05d | %05d    | %05d |      %05d     |     %05d         | %05d    | %05d   |", iter.next(), iter.next(), iter.next(), iter.next(), iter.next(), iter.next(), iter.next());

        }

    }
}
