package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

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
        return events;
    }

    @Override
    public void onEvent(Event event) {
        events.add(event);
    }

    @Override
    public String toString() {
        return events.toString();
    }
}
