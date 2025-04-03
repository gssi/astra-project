/**
 */
package MetaEditor.MetaEditorConfiguration.impl;

import MetaEditor.MetaEditorConfiguration.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetaEditorConfigurationFactoryImpl extends EFactoryImpl implements MetaEditorConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetaEditorConfigurationFactory init() {
		try {
			MetaEditorConfigurationFactory theMetaEditorConfigurationFactory = (MetaEditorConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(MetaEditorConfigurationPackage.eNS_URI);
			if (theMetaEditorConfigurationFactory != null) {
				return theMetaEditorConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetaEditorConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaEditorConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetaEditorConfigurationPackage.META_EDITOR_CONFIGURATION: return createMetaEditorConfiguration();
			case MetaEditorConfigurationPackage.GRAPHICAL_ELEMENT: return createGraphicalElement();
			case MetaEditorConfigurationPackage.ANCHOR_POINT: return createAnchorPoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MetaEditorConfigurationPackage.ROTATION_POSITION:
				return createRotationPositionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MetaEditorConfigurationPackage.ROTATION_POSITION:
				return convertRotationPositionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaEditorConfiguration createMetaEditorConfiguration() {
		MetaEditorConfigurationImpl metaEditorConfiguration = new MetaEditorConfigurationImpl();
		return metaEditorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicalElement createGraphicalElement() {
		GraphicalElementImpl graphicalElement = new GraphicalElementImpl();
		return graphicalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnchorPoint createAnchorPoint() {
		AnchorPointImpl anchorPoint = new AnchorPointImpl();
		return anchorPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RotationPosition createRotationPositionFromString(EDataType eDataType, String initialValue) {
		RotationPosition result = RotationPosition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRotationPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaEditorConfigurationPackage getMetaEditorConfigurationPackage() {
		return (MetaEditorConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetaEditorConfigurationPackage getPackage() {
		return MetaEditorConfigurationPackage.eINSTANCE;
	}

} //MetaEditorConfigurationFactoryImpl
