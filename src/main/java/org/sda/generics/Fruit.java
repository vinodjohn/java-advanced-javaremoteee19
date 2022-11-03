package org.sda.generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Fruit class for Generic
 *
 * @author Vinod John
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fruit {
    private String name;
    private String color;
    private BigDecimal price;
}
