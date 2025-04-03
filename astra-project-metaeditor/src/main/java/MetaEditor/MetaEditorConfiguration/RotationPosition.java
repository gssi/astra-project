/**
 */
package MetaEditor.MetaEditorConfiguration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Rotation Position</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Enumerator che rappresenta le varie posizioni di rotazione previste per i graphical element definiti come "ruotabili". I literal di questo enumerator definiscono ciascuno i gradi di rotazione (da 0 a 360).
 * <!-- end-model-doc -->
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#getRotationPosition()
 * @model
 * @generated
 */
public enum RotationPosition implements Enumerator {
	/**
	 * The '<em><b>DEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_VALUE
	 * @generated
	 * @ordered
	 */
	DEFAULT(0, "DEFAULT", "DEFAULT"),

	/**
	 * The '<em><b>ROT45</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT45_VALUE
	 * @generated
	 * @ordered
	 */
	ROT45(45, "ROT45", "ROT45"),

	/**
	 * The '<em><b>ROT90</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT90_VALUE
	 * @generated
	 * @ordered
	 */
	ROT90(90, "ROT90", "ROT90"),

	/**
	 * The '<em><b>ROT135</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT135_VALUE
	 * @generated
	 * @ordered
	 */
	ROT135(135, "ROT135", "ROT135"),

	/**
	 * The '<em><b>ROT180</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT180_VALUE
	 * @generated
	 * @ordered
	 */
	ROT180(180, "ROT180", "ROT180"),

	/**
	 * The '<em><b>ROT225</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT225_VALUE
	 * @generated
	 * @ordered
	 */
	ROT225(225, "ROT225", "ROT225"),

	/**
	 * The '<em><b>ROT270</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT270_VALUE
	 * @generated
	 * @ordered
	 */
	ROT270(270, "ROT270", "ROT270"),

	/**
	 * The '<em><b>ROT315</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT315_VALUE
	 * @generated
	 * @ordered
	 */
	ROT315(315, "ROT315", "ROT315");

	/**
	 * The '<em><b>DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_VALUE = 0;

	/**
	 * The '<em><b>ROT45</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT45
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROT45_VALUE = 45;

	/**
	 * The '<em><b>ROT90</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT90
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROT90_VALUE = 90;

	/**
	 * The '<em><b>ROT135</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT135
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROT135_VALUE = 135;

	/**
	 * The '<em><b>ROT180</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT180
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROT180_VALUE = 180;

	/**
	 * The '<em><b>ROT225</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT225
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROT225_VALUE = 225;

	/**
	 * The '<em><b>ROT270</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT270
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROT270_VALUE = 270;

	/**
	 * The '<em><b>ROT315</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROT315
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROT315_VALUE = 315;

	/**
	 * An array of all the '<em><b>Rotation Position</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RotationPosition[] VALUES_ARRAY =
		new RotationPosition[] {
			DEFAULT,
			ROT45,
			ROT90,
			ROT135,
			ROT180,
			ROT225,
			ROT270,
			ROT315,
		};

	/**
	 * A public read-only list of all the '<em><b>Rotation Position</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RotationPosition> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Rotation Position</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RotationPosition get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RotationPosition result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rotation Position</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RotationPosition getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RotationPosition result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Rotation Position</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RotationPosition get(int value) {
		switch (value) {
			case DEFAULT_VALUE: return DEFAULT;
			case ROT45_VALUE: return ROT45;
			case ROT90_VALUE: return ROT90;
			case ROT135_VALUE: return ROT135;
			case ROT180_VALUE: return ROT180;
			case ROT225_VALUE: return ROT225;
			case ROT270_VALUE: return ROT270;
			case ROT315_VALUE: return ROT315;
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
	private RotationPosition(int value, String name, String literal) {
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
	
} //RotationPosition
