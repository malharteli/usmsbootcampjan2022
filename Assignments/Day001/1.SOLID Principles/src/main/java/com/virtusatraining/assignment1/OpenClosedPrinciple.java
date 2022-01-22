package com.virtusatraining.assignment1;

// In this class, I will demonstrate the Open-Closed Principle

import lombok.AllArgsConstructor;
import lombok.Data;

//This class fails to keep the open-closed Principle, as each time it is extended by a subclass, it will need to be
// modified to account for its presence
@AllArgsConstructor
@Data
class OpenOpenPrinciple {
    Double baseValue = 2.0;
    public double add2(OpenOpenPrinciple source){

    }
}

public class OpenClosedPrinciple {
}
