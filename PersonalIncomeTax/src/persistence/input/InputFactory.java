package persistence.input;

import java.util.function.Supplier;

public class InputFactory {
    private InputFactory() {}

    public static <T> T create(Input<T> input){
        return input.create();
    }
}

