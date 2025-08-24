package tests;

import decorator.BreakfastDecorator;
import decorator.InsuranceDecorator;
import decorator.SpaDecorator;
import org.junit.jupiter.api.Test;
import reservations.CarReservation;
import reservations.FlightReservation;
import reservations.HotelReservation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test de Decorators
 * Nota: por la implementacion de diferentes patrones lso mensaje en consola pueden tener datos nulos
 * solo se está probando que al agregarce servicios extras a traves de Decoratos se sume el cargo por servicio
 * extra al precio final
 * */
public class DecoratorTest {
    @Test
    public void testInsuranceDecoratorAddCharge(){
        CarReservation reservation = new CarReservation();
        reservation.setPrice(250);

        InsuranceDecorator insurance = new InsuranceDecorator(reservation); // el seguro suma $100 mas al precio
        insurance.reserve();

        assertEquals(350, insurance.getPrice(), 0.001);
    }

    @Test void testBreakfastDecoratorAddCharge(){
        FlightReservation reservation = new FlightReservation();
        reservation.setPrice(120);

        BreakfastDecorator breakfast = new BreakfastDecorator(reservation); // el desayuno suma $50 mas al precio
        breakfast.reserve();

        assertEquals(170, breakfast.getPrice(), 0.001);
    }

    @Test
    public void testSpaDecoratorAddCharge(){
        HotelReservation reservation = new HotelReservation();
        reservation.setPrice(150);

        SpaDecorator spa = new SpaDecorator(reservation); // el acceso al spa suma $100 mas al precio
        spa.reserve();

        assertEquals(250, spa.getPrice(), 0.001);
    }

    @Test
    public void testInsurencePlusSpaPlusBreakfastDecoratorsAddCharge(){
        HotelReservation reservation = new HotelReservation();
        reservation.setPrice(150);

        InsuranceDecorator insurnace = new InsuranceDecorator(reservation); // el seguro suma $100 mas al precio
        SpaDecorator spa = new SpaDecorator(insurnace); // el acceso al spa suma $100 mas al precio
        BreakfastDecorator breakfast = new BreakfastDecorator(spa); // suma $50 mas por el desayuno
        breakfast.reserve();

        assertEquals(400, breakfast.getPrice(), 0.001);
    }
}
