package training.Annotations;

import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target(value={FIELD,PARAMETER})
@Retention(RUNTIME)
public @interface IntValue {
    int min();
    int max();
}
