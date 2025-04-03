/**
 */
package Scheduler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Scheduler.TableTask#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see Scheduler.SchedulerPackage#getTableTask()
 * @model
 * @generated
 */
public interface TableTask extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link Scheduler.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see Scheduler.SchedulerPackage#getTableTask_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getTasks();

} // TableTask
