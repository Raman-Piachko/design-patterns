package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class CommitToBranchWebHook implements WebHook {
    private List<Event> events;
    private String branch;

    public CommitToBranchWebHook(String branch) {
        this.branch = branch;
        events = new ArrayList<>();
    }

    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return Event.Type.COMMIT;
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
