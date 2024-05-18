package controller;

import lombok.Getter;
import java.util.List;

@Getter
public abstract class Constant {
    private final List<String> tablewares = List.of("Cup", "Plate", "Pot", "Spoon");
    private final List<String> cupParameters = List.of("color", "size");
    private final List<String> plateParameters = List.of("color", "shape");
    private final List<String> potParameters = List.of("type");
    private final List<String> spoonParameters = List.of("type");
    private final List<String> generalParameter = List.of("material", "name");
    private final List<String> AllParameters = List.of("color", "size", "shape", "type", "material", "name");
}
