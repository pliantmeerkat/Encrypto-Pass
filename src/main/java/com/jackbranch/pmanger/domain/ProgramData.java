package com.jackbranch.pmanger.domain;

import com.jackbranch.pmanger.domain.enums.EncryptedFieldTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramData extends BaseEntity {

    @Encrypted(fieldType = EncryptedFieldTypes.LIST)
    List<PasswordEntity> userPasswords;
}
