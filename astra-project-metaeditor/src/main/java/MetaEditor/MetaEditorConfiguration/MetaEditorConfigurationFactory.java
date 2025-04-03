/**
 */
package MetaEditor.MetaEditorConfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage
 * @generated
 */
public interface MetaEditorConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetaEditorConfigurationFactory eINSTANCE = MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Meta Editor Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Editor Configuration</em>'.
	 * @generated
	 */
	MetaEditorConfiguration createMetaEditorConfiguration();

	/**
	 * Returns a new object of class '<em>Graphical Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graphical Element</em>'.
	 * @generated
	 */
	GraphicalElement createGraphicalElement();

	/**
	 * Returns a new object of class '<em>Anchor Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Anchor Point</em>'.
	 * @generated
	 */
	AnchorPoint createAnchorPoint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetaEditorConfigurationPackage getMetaEditorConfigurationPackage();

} //MetaEditorConfigurationFactory
