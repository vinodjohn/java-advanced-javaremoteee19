package org.sda.generics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
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
public class Fruit implements Serializable { // This class can be Serialized and Deserialized
    private String name;
    private String color;
    private BigDecimal price;
}
