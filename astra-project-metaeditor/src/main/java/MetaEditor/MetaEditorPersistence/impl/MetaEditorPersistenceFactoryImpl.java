/**
 */
package MetaEditor.MetaEditorPersistence.impl;

import MetaEditor.MetaEditorPersistence.*;

import org.eclipse.emf.ecore.EClass;
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
public class MetaEditorPersistenceFactoryImpl extends EFactoryImpl implements MetaEditorPersistenceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetaEditorPersistenceFactory init() {
		try {
			MetaEditorPersistenceFactory theMetaEditorPersistenceFactory = (MetaEditorPersistenceFactory)EPackage.Registry.INSTANCE.getEFactory(MetaEditorPersistencePackage.eNS_URI);
			if (theMetaEditorPersistenceFactory != null) {
				return theMetaEditorPersistenceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetaEditorPersistenceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaEditorPersistenceFactoryImpl() {
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
			case MetaEditorPersistencePackage.META_EDITOR_PERSISTENCE: return createMetaEditorPersistence();
			case MetaEditorPersistencePackage.ELEMENT_POSITION: return createElementPosition();
			case MetaEditorPersistencePackage.BEND_POINT: return createBendPoint();
			case MetaEditorPersistencePackage.CANVAS_SECTION: return createCanvasSection();
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
	public MetaEditorPersistence createMetaEditorPersistence() {
		MetaEditorPersistenceImpl metaEditorPersistence = new MetaEditorPersistenceImpl();
		return metaEditorPersistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElementPosition createElementPosition() {
		ElementPositionImpl elementPosition = new ElementPositionImpl();
		return elementPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BendPoint createBendPoint() {
		BendPointImpl bendPoint = new BendPointImpl();
		return bendPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CanvasSection createCanvasSection() {
		CanvasSectionImpl canvasSection = new CanvasSectionImpl();
		return canvasSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaEditorPersistencePackage getMetaEditorPersistencePackage() {
		return (MetaEditorPersistencePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetaEditorPersistencePackage getPackage() {
		return MetaEditorPersistencePackage.eINSTANCE;
	}

} //MetaEditorPersistenceFactoryImpl
