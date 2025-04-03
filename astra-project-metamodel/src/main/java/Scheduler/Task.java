/**
 */
package Scheduler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Scheduler.Task#getPriority <em>Priority</em>}</li>
 *   <li>{@link Scheduler.Task#getFollowing <em>Following</em>}</li>
 *   <li>{@link Scheduler.Task#getDuration <em>Duration</em>}</li>
 *   <li>{@link Scheduler.Task#getActs <em>Acts</em>}</li>
 * </ul>
 *
 * @see Scheduler.SchedulerPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see Scheduler.SchedulerPackage#getTask_Priority()
	 * @model
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link Scheduler.Task#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Following</b></em>' reference list.
	 * The list contents are of type {@link Scheduler.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Following</em>' reference list.
	 * @see Scheduler.SchedulerPackage#getTask_Following()
	 * @model
	 * @generated
	 */
	EList<Task> getFollowing();

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(int)
	 * @see Scheduler.SchedulerPackage#getTask_Duration()
	 * @model required="true"
	 * @generated
	 */
	int getDuration();

	/**
	 * Sets the value of the '{@link Scheduler.Task#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(int value);

	/**
	 * Returns the value of the '<em><b>Acts</b></em>' containment reference list.
	 * The list contents are of type {@link Scheduler.ACT}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acts</em>' containment reference list.
	 * @see Scheduler.SchedulerPackage#getTask_Acts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ACT> getActs();

} // Task
