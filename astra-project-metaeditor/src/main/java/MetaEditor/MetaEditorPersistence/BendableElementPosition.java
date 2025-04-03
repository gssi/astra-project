/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bendable Element Position</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Questa metaclasse è necessaria per clusterizzare in un unico contenitore la posizione di tutti i bend points di un graphical element che sia di tipo bendable. Se il graphical element non è di tipo bendable, non ha bend points.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.BendableElementPosition#getBendPoints <em>Bend Points</em>}</li>
 * </ul>
 *
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getBendableElementPosition()
 * @model abstract="true"
 * @generated
 */
public interface BendableElementPosition extends EObject {
	/**
	 * Returns the value of the '<em><b>Bend Points</b></em>' containment reference list.
	 * The list contents are of type {@link MetaEditor.MetaEditorPersistence.BendPoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Puntatore a tutti i bend points di un element position relativo a un graphical element di tipo bendable.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bend Points</em>' containment reference list.
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#getBendableElementPosition_BendPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<BendPoint> getBendPoints();

} // BendableElementPosition
