package com.btoy.debezium.domain.base.entity;

import com.btoy.debezium.domain.base.vo.BaseId;

import java.util.Objects;

public abstract class BaseEntity<ID extends BaseId> {

    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id.getValue(), that.id.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
