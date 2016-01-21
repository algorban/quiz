package main.java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 1/20/2016.
 *
 * Your company built an in-house calendar tool called HiCal.
 * You want to add a feature to see the times in a day when everyone is available.
 * To do this, you’ll need to know when any team is having a meeting.
 * In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
 * These integers represent the number of 30-minute blocks past 9:00am.
 *
 * Write a function condenseMeetingTimes() that takes a list of meeting time ranges and returns a list of condensed ranges.
 *
 * For example, given:
 * [(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)]
 * your function would return:
 * [(0, 1), (3, 8), (9, 12)]
 *
 */
public class MeetingTimes {


    private class Meeting {
        Integer startTime;
        Integer endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public Meeting join(Meeting that) {
            return new Meeting(this.startTime, that.endTime);
        }

        public String toString() {
            return String.format("(%d, %d)", startTime, endTime);
        }
    }

    public static void main(String[] args) {
        List<Meeting> meetingTime = new LinkedList<>();
        List<Meeting> result = new LinkedList<>();
        MeetingTimes mainClazz = new MeetingTimes();

        //(0, 1), (3, 5), (4, 8), (10, 12), (9, 10)
        meetingTime.add(mainClazz.new Meeting(0,1));
        meetingTime.add(mainClazz.new Meeting(3,5));
        meetingTime.add(mainClazz.new Meeting(4,8));
        meetingTime.add(mainClazz.new Meeting(10,12));
        meetingTime.add(mainClazz.new Meeting(9,10));
        result = condenseMeetingTimes(meetingTime);
        result.forEach((m)->System.out.println(m));
        System.out.println("******");
        meetingTime.clear();
        //(1, 10), (2, 6), (3, 5), (7, 9)
        meetingTime.add(mainClazz.new Meeting(1,10));
        meetingTime.add(mainClazz.new Meeting(2,6));
        meetingTime.add(mainClazz.new Meeting(3,5));
        meetingTime.add(mainClazz.new Meeting(7,9));
        result = condenseMeetingTimes(meetingTime);
        result.forEach((m)->System.out.println(m));
        System.out.println("******");
        meetingTime.clear();
        //(1, 2), (2, 3)
        meetingTime.add(mainClazz.new Meeting(1,2));
        meetingTime.add(mainClazz.new Meeting(2,3));
        result = condenseMeetingTimes(meetingTime);
        result.forEach((m)->System.out.println(m));
        System.out.println("******");
        meetingTime.clear();

        //(1, 5), (2, 3)
        meetingTime.add(mainClazz.new Meeting(1,5));
        meetingTime.add(mainClazz.new Meeting(2,3));
        result = condenseMeetingTimes(meetingTime);
        result.forEach((m)->System.out.println(m));

    }

    public static List<Meeting> condenseMeetingTimes(List<Meeting> meetings) {
        LinkedList <Meeting> condenseMeetings = new LinkedList<>();

        Collections.sort(meetings, (meeting1, meeting2) -> meeting1.startTime.compareTo(meeting2.startTime));
        //Collections.sort(meetings, (meeting1, meeting2) -> meeting1.endTime.compareTo(meeting2.endTime));

        Meeting mt = meetings.get(0);
        condenseMeetings.add(mt);

        for(int i=1; i< meetings.size(); i++) {
            Meeting last = condenseMeetings.removeLast();
            Meeting current = meetings.get(i);
            if(current.startTime <= last.endTime && current.endTime > last.endTime) {
                last = last.join(current);
                condenseMeetings.addLast(last);
            } else if (current.startTime <= last.endTime && current.endTime <= last.endTime) {
                condenseMeetings.addLast(last);
                continue;
            } else {
                condenseMeetings.addLast(last);
                condenseMeetings.addLast(current);
            }
        }

        return condenseMeetings;
    }
}
