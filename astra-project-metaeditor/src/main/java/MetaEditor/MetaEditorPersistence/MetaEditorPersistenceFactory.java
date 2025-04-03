/**
 */
package MetaEditor.MetaEditorPersistence;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage
 * @generated
 */
public interface MetaEditorPersistenceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetaEditorPersistenceFactory eINSTANCE = MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistenceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Meta Editor Persistence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Editor Persistence</em>'.
	 * @generated
	 */
	MetaEditorPersistence createMetaEditorPersistence();

	/**
	 * Returns a new object of class '<em>Element Position</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Position</em>'.
	 * @generated
	 */
	ElementPosition createElementPosition();

	/**
	 * Returns a new object of class '<em>Bend Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bend Point</em>'.
	 * @generated
	 */
	BendPoint createBendPoint();

	/**
	 * Returns a new object of class '<em>Canvas Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Canvas Section</em>'.
	 * @generated
	 */
	CanvasSection createCanvasSection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetaEditorPersistencePackage getMetaEditorPersistencePackage();

} //MetaEditorPersistenceFactory
