package jp.artan.dmlreloaded.util.nullness;

import org.jetbrains.annotations.Nullable;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Nullable
public @interface NullableType {
}
