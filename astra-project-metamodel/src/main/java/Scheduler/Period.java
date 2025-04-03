/**
 */
package Scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Period</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see Scheduler.SchedulerPackage#getPeriod()
 * @model
 * @generated
 */
public enum Period implements Enumerator {
	/**
	 * The '<em><b>TICK INTO TSLICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TICK_INTO_TSLICE_VALUE
	 * @generated
	 * @ordered
	 */
	TICK_INTO_TSLICE(0, "TICK_INTO_TSLICE", "TICK_INTO_TSLICE"),

	/**
	 * The '<em><b>TICK INTO SLICE 84</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TICK_INTO_SLICE_84_VALUE
	 * @generated
	 * @ordered
	 */
	TICK_INTO_SLICE_84(1, "TICK_INTO_SLICE_8_4", "TICK_INTO_SLICE_8_4");

	/**
	 * The '<em><b>TICK INTO TSLICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TICK_INTO_TSLICE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TICK_INTO_TSLICE_VALUE = 0;

	/**
	 * The '<em><b>TICK INTO SLICE 84</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TICK_INTO_SLICE_84
	 * @model name="TICK_INTO_SLICE_8_4"
	 * @generated
	 * @ordered
	 */
	public static final int TICK_INTO_SLICE_84_VALUE = 1;

	/**
	 * An array of all the '<em><b>Period</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Period[] VALUES_ARRAY =
		new Period[] {
			TICK_INTO_TSLICE,
			TICK_INTO_SLICE_84,
		};

	/**
	 * A public read-only list of all the '<em><b>Period</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Period> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Period</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Period get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Period result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Period</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Period getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Period result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Period</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Period get(int value) {
		switch (value) {
			case TICK_INTO_TSLICE_VALUE: return TICK_INTO_TSLICE;
			case TICK_INTO_SLICE_84_VALUE: return TICK_INTO_SLICE_84;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Period(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //Period
