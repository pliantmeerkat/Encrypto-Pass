package com.jackbranch.pmanger.domain;

import com.jackbranch.pmanger.domain.enums.EncryptedFieldTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypted {
    EncryptedFieldTypes fieldType() default EncryptedFieldTypes.SINGLE;
}
