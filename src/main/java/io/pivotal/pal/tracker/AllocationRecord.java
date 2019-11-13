package io.pivotal.pal.tracker;

import java.util.Objects;

public class AllocationRecord {
    private final long id;
    private final long projectId;
    private final String info;

    public AllocationRecord(long id, long projectId, String info) {
        this.id = id;
        this.projectId = projectId;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllocationRecord that = (AllocationRecord) o;
        return id == that.id &&
                projectId == that.projectId &&
                Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, info);
    }

    @Override
    public String toString() {
        return "AllocationRecord{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", info='" + info + '\'' +
                '}';
    }
}
