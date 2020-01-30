package com.epam.training.sportsbetting.domain.type;

import java.util.stream.Stream;

public enum LanguageType implements StringTypeEnum {

    UA("UA"),
    EN("EN");


    private final String value;

    LanguageType(String value) {
        this.value = value;
    }

    /**
     * default - EN
     *
     * @param value
     * @return
     */
    public static LanguageType fromValue(String value) {
        return Stream.of(values()).filter(v -> v.getValue().equals(value)).findFirst().orElse(EN);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equalsTo(String value) {
        return false;
    }


}
