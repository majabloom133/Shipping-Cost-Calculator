package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /* Old code
        // Manual object creation (composition root)
        List<ShippingCostCalculator> calculators = List.of(
                new StandardDomesticShipping(),
                new ExpressInternationalShipping()
        );
        */

        // 1. Start Spring Container and point to config clas
        // Here Spring reads @ComponentScan and finds all the @Components
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Ask Spring to give me the ShippingService bean
        // No need to create factory or list of calculators, Spring does that instead.
        ShippingService shippingService = context.getBean(ShippingService.class);


        // --- Original code ---
        ShippingRequest domesticStandardRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10.0);
        System.out.println("Shipping cost: " + shippingService.quote(domesticStandardRequest));

        ShippingRequest internationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        System.out.println("Shipping cost: " + shippingService.quote(internationalExpressRequest));

        ShippingRequest lightDomesticRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 5.0);
        System.out.println("Shipping cost: " + shippingService.quote(lightDomesticRequest));

        ShippingRequest heavyInternationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        System.out.println("Shipping cost: " + shippingService.quote(heavyInternationalExpressRequest));

        // Clean up + close Spring container
        context.close();

    }
}
