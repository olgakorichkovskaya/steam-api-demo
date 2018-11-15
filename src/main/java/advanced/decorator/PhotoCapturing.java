package advanced.decorator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Decorating using lambda
 */
public class PhotoCapturing {

    static Function<Color, Color> addMoreBlueFilter = color -> {
        final Color build = color.toBuilder().b(color.getB() + 100).build();
        System.out.println("   ... filter in action - more blue");
        return build;
    };

    static Function<Color, Color> addMoreRedFilter = color -> {
        final Color build = color.toBuilder().r(color.getR() + 100).build();
        System.out.println("   ... filter in action - more red");
        return build;
    };

    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Color grey = new Color(200, 200, 200);

        System.out.println("No filters");
        camera.capture(grey);

        System.out.println("\nAdd more blue to color");
        camera.setFilter(addMoreBlueFilter);
        camera.capture(grey);

        System.out.println("\nAdd more blue and red");
        camera.setFilter(addMoreBlueFilter, addMoreRedFilter);
        camera.capture(grey);

        System.out.println("\nadd more blue, red, and one more time blue");
        camera.setFilter(addMoreBlueFilter, addMoreRedFilter, addMoreBlueFilter);
        camera.capture(grey);

    }
}

class Camera {
    public Camera() {
        setFilter();
    }

    private Function<Color, Color> filter;

    void setFilter(Function<Color, Color>... filters) {
        this.filter = Stream.of(filters).reduce((f1, f2) -> f1.compose(f2))
                .orElse(t -> t);
    }


    void capture(Color color) {
        final Color filteredColor = filter.apply(color);
        System.out.println("  save into SSD color :" + filteredColor);
    }

}

@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@ToString
class Color {
    int r;
    int b;
    int g;
}