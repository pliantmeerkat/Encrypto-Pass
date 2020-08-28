package com.jackbranch.pmanger.util;

import com.jackbranch.pmanger.domain.BaseEntity;
import com.jackbranch.pmanger.view.ViewEntity;

public class ReflectUtil {

    private ReflectUtil() {

    }

    public static <T extends BaseEntity, V extends ViewEntity> V getViewFromModel(T model, V view) {
        return null;
    }

    public static <T extends ViewEntity, V extends BaseEntity> T getModelFromView(T view, V model) {
        return null;
    }
}
