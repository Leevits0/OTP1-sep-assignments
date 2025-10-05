package week3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    private   TemperatureConverter converter;

    @BeforeEach
    void setup() {
        converter = new TemperatureConverter();
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 1e-3);
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 1e-3);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40.0), 1e-3);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 1e-3);
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 1e-3);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40.0), 1e-3);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-41.0));
        assertTrue(converter.isExtremeTemperature(51.0));
        assertFalse(converter.isExtremeTemperature(10.0));
        assertFalse(converter.isExtremeTemperature(0.0));
    }

    @Test
    void testKelvinToCelsius_examples() {
        assertEquals(26.85, converter.kelvinToCelsius(300.0), 1e-2);
        assertEquals(0.0, converter.kelvinToCelsius(273.15), 1e-9);
        assertEquals(-273.15, converter.kelvinToCelsius(0.0), 1e-9);
    }

    @ParameterizedTest(name = "{index} ⇒ K={0} → C≈{1}")
    @CsvSource({
            "200.00, -73.15",
            "250.50, -22.65",
            "310.15, 37.00",
            "373.15, 100.00"
    })
    void testKelvinToCelsius_parameterized(double kelvin, double expectedC) {
        assertEquals(expectedC, converter.kelvinToCelsius(kelvin), 1e-2);
    }
}
