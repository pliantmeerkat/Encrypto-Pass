package com.jackbranch.pmanger.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordKey extends BaseEntity {

    private String salt;
    private String value;
    private Instant updated;

    public PasswordKey(String salt, String value) {
        this.salt = salt;
        this.value = value;
        this.updated = Instant.now();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Objects.hashCode(this.salt),
                Objects.hashCode(this.value)
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (null == other || getClass() != other.getClass()) {
            return false;
        }
        PasswordKey otherKey = (PasswordKey) other;
        return isFieldEqual(this.salt, otherKey.salt) &&
                isFieldEqual(this.value, otherKey.value) &&
                 isFieldEqual(this.updated, otherKey.updated);
    }
}
