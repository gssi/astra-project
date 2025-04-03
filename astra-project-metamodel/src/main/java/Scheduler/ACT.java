/**
 */
package Scheduler;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ACT</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Scheduler.ACT#getStart <em>Start</em>}</li>
 *   <li>{@link Scheduler.ACT#getEnd <em>End</em>}</li>
 *   <li>{@link Scheduler.ACT#getPeriod <em>Period</em>}</li>
 * </ul>
 *
 * @see Scheduler.SchedulerPackage#getACT()
 * @model
 * @generated
 */
public interface ACT extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(Tick)
	 * @see Scheduler.SchedulerPackage#getACT_Start()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Tick getStart();

	/**
	 * Sets the value of the '{@link Scheduler.ACT#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Tick value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' containment reference.
	 * @see #setEnd(Tick)
	 * @see Scheduler.SchedulerPackage#getACT_End()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Tick getEnd();

	/**
	 * Sets the value of the '{@link Scheduler.ACT#getEnd <em>End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' containment reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Tick value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * The literals are from the enumeration {@link Scheduler.Period}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see Scheduler.Period
	 * @see #setPeriod(Period)
	 * @see Scheduler.SchedulerPackage#getACT_Period()
	 * @model required="true"
	 * @generated
	 */
	Period getPeriod();

	/**
	 * Sets the value of the '{@link Scheduler.ACT#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see Scheduler.Period
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(Period value);

} // ACT
