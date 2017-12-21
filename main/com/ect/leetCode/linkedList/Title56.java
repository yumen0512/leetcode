package com.ect.leetCode.linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 *
 * The idea is to sort the intervals by their starting points. Then, we take the first interval and
 * compare its end with the next intervals starts. As long as they overlap, we update the end to be
 * the max end of the overlapping intervals. Once we find a non overlapping interval, we can add the
 * previous "extended" interval and start over.
 *
 * Created by Mr Wang :) on 17-12-21.
 */
public class Title56 {

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null) return null;
        if (intervals.size() <= 1) return intervals;

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        List<Interval> result = new ArrayList<>();

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                Interval temp = new Interval(start, end);
                result.add(temp);
                start = interval.start;
                end = interval.end;
            }
        }

        Interval temp = new Interval(start, end);
        result.add(temp);

        return result;

    }


}
