package model;

import java.time.LocalTime;

/**
 * Created by alexandermiheev on 27.05.17.
 */


public class Task {
    private LocalTime departmentStartTime;
    private LocalTime departmentEndTime;
    private Constraint constraint;

    public Task(LocalTime departmentStartTime, LocalTime departmentEndTime, Constraint constraint) {
        this.departmentStartTime = departmentStartTime;
        this.departmentEndTime = departmentEndTime;
        this.constraint = constraint;
    }

    public Task(String departmentStartTime, String departmentEndTime, Constraint constraint) {
        this.departmentStartTime = LocalTime.parse(departmentStartTime);
        this.departmentEndTime = LocalTime.parse(departmentEndTime);
        this.constraint = constraint;
    }

    public LocalTime getDepartmentStartTime() {
        return departmentStartTime;
    }

    public void setDepartmentStartTime(LocalTime departmentStartTime) {
        this.departmentStartTime = departmentStartTime;
    }

    public LocalTime getDepartmentEndTime() {
        return departmentEndTime;
    }

    public void setDepartmentEndTime(LocalTime departmentEndTime) {
        this.departmentEndTime = departmentEndTime;
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }
}
