package LeetCode;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ConsolidatingPartition {                          // given the used up space
    public static void main(String[] args) {                  // given the actual available space on each partition
        List<Integer> used = new ArrayList<>();               // find the minimum no. of partitions required to store the data ?
        used.add(3);
        used.add(2);
        used.add(1);
        used.add(3);
        used.add(1);
        used.add(5);
        used.add(1);

        List<Integer> total = new ArrayList<>();
        total.add(3);
        total.add(5);
        total.add(3);
        total.add(5);
        total.add(5);

        int actualPartitionsRequired = consolidatingPartition(used, total);
    }
    public static int consolidatingPartition(List<Integer> usedSpace, List<Integer> totalSpace){
         int minPartitions = 0;
         totalSpace.sort(Collections.reverseOrder());
         int totalSpaceRequired = 0;
         for(int space : usedSpace){
             totalSpaceRequired += space;
         }
         int partitionIndex = 0;
         int currentTotal;
         while(totalSpaceRequired > 0){
             currentTotal = totalSpace.get(partitionIndex);
             totalSpaceRequired -= currentTotal;
             if(totalSpaceRequired > 0){
                 partitionIndex++;
                 minPartitions++;
                 continue;
             }
             minPartitions++;
         }
         return minPartitions;
    }
}
