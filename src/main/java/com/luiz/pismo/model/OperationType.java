package com.luiz.pismo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "operation_types")
public class OperationType {

    @Id
    @Column(name = "operation_type_id", updatable = false, nullable = false)
    private int operationTypeId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean negative;

    public OperationType(int operationTypeId, String description, boolean negative) {
        this.operationTypeId = operationTypeId;
        this.description = description;
        this.negative = negative;
    }

    public OperationType() {
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNegative() {
        return negative;
    }

    @Override
    public String toString() {
        return "OperationType{" +
                "operationTypeId=" + operationTypeId +
                ", description='" + description + '\'' +
                ", negative=" + negative +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationType that = (OperationType) o;
        return operationTypeId == that.operationTypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationTypeId);
    }


    public double defineOperationSign() {
        return negative ? -1 : 1;
    }
}
