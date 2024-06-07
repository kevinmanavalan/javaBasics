package LeetCode;

//URL:https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.*;

public class NMeetingsInOneRoom {
    public static int approach1(int[] start, int[] end, int n) {          // Consumes too much memmory
        List<List<Integer>> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(List.of(start[i], end[i], i));
        }
        meetings.sort((m1, m2) -> {
            if (m1.get(1) < m2.get(1)) {
                return -1;
            } else if (m1.get(1) < m2.get(1)) {
                return 1;
            } else if (m1.get(2) < m2.get(2)) {
                return -1;
            }
            return 1;
        });
//        Collections.sort(meetings, (m1, m2) -> {          // Older way to implementing a comparator
//            if (m1.get(1) < m2.get(1)) {
//                return -1;
//            } else if (m1.get(1) < m2.get(1)) {
//                return 1;
//            } else if (m1.get(2) < m2.get(2)) {
//                return -1;
//            }
//            return 1;
//        });
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(meetings.get(0));
        int limit = meetings.get(0).get(1);
        for(int i = 1; i < n; i++){
            if(meetings.get(i).get(0) > limit){
                answer.add(meetings.get(i));
                limit = meetings.get(i).get(1);
            }
        }
        return answer.size();
    }


    public static int approach2(int[] start, int[] end, int n) {       // Memory efficient approach
        List<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++){
            meetings.add(new Meeting(start[i], end[i], i+1));
        }
        //meetings.sort(Comparator.naturalOrder());
        Collections.sort(meetings);                    // sorted using the natural order aka "the Comparable approach"

        //MeetingSort ms = new MeetingSort();
        //meetings.sort(ms);                             // using the custom comparator
        //Collections.sort(meetings, ms);

        List<Meeting> answers = new ArrayList<>();
        answers.add(meetings.get(0));
        int limit = meetings.get(0).end;
        for(int i = 1; i < n; i++){
            if(meetings.get(i).start > limit){
                limit = meetings.get(i).end;
                answers.add(meetings.get(i));
            }
        }
        return answers.size();
    }
}







class Meeting implements Comparable<Meeting>{           // In this variation I directly
    int start;                                          // implemented the Comparable interface thereby providing
    int end;                                            // natural ordering for this custom type class.
    int pos;
    Meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

    @Override
    public int compareTo(Meeting o) {
        if(this.end < o.end){
            return -1;
        } else if (this.end > o.end) {
            return 1;
        }else {
            return Integer.compare(this.pos, o.pos);
        }
    }
}

class MeetingSort implements Comparator<Meeting> {       // In this variation I decided to provide
                                                         // an external custom Comparator by creating
    @Override                                            // implementation for the Comparator to provide a custom
    public int compare(Meeting m1, Meeting m2) {         // sorting approach.
        if(m1.end < m2.end){                             //  This approach is useful when you want to define more than
            return -1;                                   //  one sorting approach for a custom type.
        } else if (m1.end > m2.end) {
            return 1;
        }
        else {
            return Integer.compare(m1.pos, m2.pos);
        }
    }
}
