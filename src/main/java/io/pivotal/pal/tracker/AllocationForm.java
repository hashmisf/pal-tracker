package io.pivotal.pal.tracker;

import java.util.Objects;

public class AllocationForm {

    private long projectId;
    private String info;

    public AllocationForm(long projectId, String info) {
        this.projectId = projectId;
        this.info = info;
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
        AllocationForm that = (AllocationForm) o;
        return projectId == that.projectId &&
                Objects.equals(info, that.info);
    }

    @Override
    public String toString() {
        return "AllocationForm{" +
                "projectId=" + projectId +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, info);
    }
}


