package com.Masiv.Roulette.entity;

import com.Masiv.Roulette.entity.Roulette;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-21T21:34:44")
@StaticMetamodel(Box.class)
public class Box_ { 

    public static volatile ListAttribute<Box, Roulette> rouletteList;
    public static volatile SingularAttribute<Box, String> color;
    public static volatile SingularAttribute<Box, BigInteger> numberBox;
    public static volatile SingularAttribute<Box, BigDecimal> idBox;

}