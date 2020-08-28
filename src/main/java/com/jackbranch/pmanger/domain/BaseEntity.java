package com.jackbranch.pmanger.domain;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {

    boolean isFieldEqual(Object first, Object second) {
        if(first == null || second == null) {
            return first == second;
        }
        return first.equals(second);
    }
}
