package LeetCode;

//CodeSignal VISA Pre-Screening OA!!

import java.util.*;

public class BranchWithLargestNoOfFiles {
    static String solution(String[] logs) {
        Map<String, Set<String>> branchCommits = getBranchToFilesMapping(logs);
        String largestBranch = "";
        int largestCount = 0;
        for(Map.Entry<String, Set<String>> branchEntry: branchCommits.entrySet()){
            if(branchEntry.getValue().size() > largestCount){
                largestCount = branchEntry.getValue().size();
                largestBranch = branchEntry.getKey();
            }
        }
        return largestBranch;
    }

    private static Map<String, Set<String>> getBranchToFilesMapping(String[] logs) {
        Map<String, Set<String>> branchCommits = new HashMap<>();
        String branch = "";
        for (String log : logs) {
            String[] logVal = log.split(" ");
            if (logVal[0].equals("switch")) {
                branch = logVal[1];
            } else if (logVal[0].equals("push")) {
                Set<String> files = branchCommits.getOrDefault(branch, new HashSet<>());
                files.add(logVal[1]);
                branchCommits.put(branch, files);
            }
        }
        return branchCommits;
    }
    public static void main(String[] args){
        String[] logs = new String[]{
                "switch branch1",
                "push file1",
                "push file2",
                "push file3",
                "switch branch2",
                "switch issue2",
                "push file1",
                "push file1",
                "push file3"
        };
        System.out.println(solution(logs));
    }
}
