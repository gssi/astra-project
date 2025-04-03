package it.gssi.astra.metaeditor.common.property;

/**
 * This is a functional interface meaning it defines exactly one method
 * that will be implemented with lambda expression.
 *
 *@see  <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html">Functional interface</a>
 */
@FunctionalInterface
public interface SetAttribute {
	void operate(Object value);
}
