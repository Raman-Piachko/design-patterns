package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MergeToBranchWebHook implements WebHook {
    private String branchName;
    private List<Event> events;

    public MergeToBranchWebHook(String branchName) {
        this.branchName = branchName;
        events = new ArrayList<>();
    }

    @Override
    public String branch() {
        return branchName;
    }

    @Override
    public Event.Type type() {
        return Event.Type.MERGE;
    }

    @Override
    public List<Event> caughtEvents() {
        return events.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public void onEvent(Event event) {
        if (events.isEmpty()) {
            events.add(event);
        }
    }

    @Override
    public String toString() {
        return events.toString();
    }
}
