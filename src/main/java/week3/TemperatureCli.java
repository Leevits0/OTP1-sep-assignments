package week3;

public class TemperatureCli {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: <f2c|c2f|k2c> <value>");
            System.exit(1);
        }
        String op = args[0].toLowerCase();
        double v = Double.parseDouble(args[1]);
        TemperatureConverter c = new TemperatureConverter();

        switch (op) {
            case "f2c":
                System.out.printf("%.2f°F = %.2f°C%n", v, c.fahrenheitToCelsius(v));
                break;
            case "c2f":
                System.out.printf("%.2f°C = %.2f°F%n", v, c.celsiusToFahrenheit(v));
                break;
            case "k2c":
                System.out.printf("%.2fK = %.2f°C%n", v, c.kelvinToCelsius(v));
                break;
            default:
                System.out.println("Unknown op. Use one of: f2c, c2f, k2c");
                System.exit(1);
        }
    }
}
