/**
 */
package Scheduler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Scheduler.Tick#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see Scheduler.SchedulerPackage#getTick()
 * @model
 * @generated
 */
public interface Tick extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see Scheduler.SchedulerPackage#getTick_Value()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link Scheduler.Tick#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

} // Tick
