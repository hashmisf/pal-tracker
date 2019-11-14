package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {


    long nextTimeEtnryId;
    HashMap<Long, TimeEntry> repo=new HashMap<>();

    @Override
    public TimeEntry find(long timeEntryId) {
        return repo.get(timeEntryId);
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        nextTimeEtnryId++;
        timeEntry.setId(nextTimeEtnryId);
        repo.put(Long.valueOf(timeEntry.getId()),timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (repo.get(id)!=null) {
            timeEntry.setId(id);
            repo.put(id, timeEntry);
            return timeEntry;
        }
        return
            null;
    }

    @Override
    public void delete(long id) {
        TimeEntry timeEntry=repo.get(id);
        repo.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(repo.values());
    }
}
