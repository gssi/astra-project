/**
 */
package Scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Scheduler.SchedulerModel#getTableTask <em>Table Task</em>}</li>
 * </ul>
 *
 * @see Scheduler.SchedulerPackage#getSchedulerModel()
 * @model
 * @generated
 */
public interface SchedulerModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Table Task</b></em>' containment reference list.
	 * The list contents are of type {@link Scheduler.TableTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Task</em>' containment reference list.
	 * @see Scheduler.SchedulerPackage#getSchedulerModel_TableTask()
	 * @model containment="true"
	 * @generated
	 */
	EList<TableTask> getTableTask();

} // SchedulerModel
