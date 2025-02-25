package mx.uv.fiee.iinf.poo.boundedbyexample;

import java.math.BigInteger;

public class BoundInheritance {


}


class GenericSupperClass<T extends Number>
{}

class GenericSubclass1 extends GenericSupperClass<BigInteger>
{}

// compile error
/*class GenericSubclass2 extends GenericSupperClass<Object>
{}*/
