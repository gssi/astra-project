/**
 */
package MetaEditor.MetaEditorPersistence.impl;

import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;

import MetaEditor.MetaEditorConfiguration.impl.MetaEditorConfigurationPackageImpl;

import MetaEditor.MetaEditorPersistence.BendPoint;
import MetaEditor.MetaEditorPersistence.BendableElementPosition;
import MetaEditor.MetaEditorPersistence.CanvasSection;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistence;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistenceFactory;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import MetaEditor.MetaEditorPersistence.Position;
import MetaEditor.MetaEditorPersistence.RotationPosition;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetaEditorPersistencePackageImpl extends EPackageImpl implements MetaEditorPersistencePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaEditorPersistenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementPositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bendableElementPositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rotationPositionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bendPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass canvasSectionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetaEditorPersistencePackageImpl() {
		super(eNS_URI, MetaEditorPersistenceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MetaEditorPersistencePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetaEditorPersistencePackage init() {
		if (isInited) return (MetaEditorPersistencePackage)EPackage.Registry.INSTANCE.getEPackage(MetaEditorPersistencePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetaEditorPersistencePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetaEditorPersistencePackageImpl theMetaEditorPersistencePackage = registeredMetaEditorPersistencePackage instanceof MetaEditorPersistencePackageImpl ? (MetaEditorPersistencePackageImpl)registeredMetaEditorPersistencePackage : new MetaEditorPersistencePackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MetaEditorConfigurationPackage.eNS_URI);
		MetaEditorConfigurationPackageImpl theMetaEditorConfigurationPackage = (MetaEditorConfigurationPackageImpl)(registeredPackage instanceof MetaEditorConfigurationPackageImpl ? registeredPackage : MetaEditorConfigurationPackage.eINSTANCE);

		// Create package meta-data objects
		theMetaEditorPersistencePackage.createPackageContents();
		theMetaEditorConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theMetaEditorPersistencePackage.initializePackageContents();
		theMetaEditorConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetaEditorPersistencePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetaEditorPersistencePackage.eNS_URI, theMetaEditorPersistencePackage);
		return theMetaEditorPersistencePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetaEditorPersistence() {
		return metaEditorPersistenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaEditorPersistence_ElementPositions() {
		return (EReference)metaEditorPersistenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaEditorPersistence_CanvasWidth() {
		return (EAttribute)metaEditorPersistenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaEditorPersistence_CanvasHeight() {
		return (EAttribute)metaEditorPersistenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaEditorPersistence_CanvasSections() {
		return (EReference)metaEditorPersistenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElementPosition() {
		return elementPositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElementPosition_Element() {
		return (EReference)elementPositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getElementPosition_Visible() {
		return (EAttribute)elementPositionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getElementPosition_Magnetizable() {
		return (EAttribute)elementPositionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getElementPosition_Pinned() {
		return (EAttribute)elementPositionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBendableElementPosition() {
		return bendableElementPositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBendableElementPosition_BendPoints() {
		return (EReference)bendableElementPositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRotationPosition() {
		return rotationPositionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRotationPosition_RotationPosition() {
		return (EAttribute)rotationPositionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBendPoint() {
		return bendPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPosition() {
		return positionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPosition_X() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPosition_Y() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPosition_Z() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCanvasSection() {
		return canvasSectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCanvasSection_Name() {
		return (EAttribute)canvasSectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCanvasSection_SectionWidth() {
		return (EAttribute)canvasSectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCanvasSection_SectionHeight() {
		return (EAttribute)canvasSectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaEditorPersistenceFactory getMetaEditorPersistenceFactory() {
		return (MetaEditorPersistenceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		metaEditorPersistenceEClass = createEClass(META_EDITOR_PERSISTENCE);
		createEReference(metaEditorPersistenceEClass, META_EDITOR_PERSISTENCE__ELEMENT_POSITIONS);
		createEAttribute(metaEditorPersistenceEClass, META_EDITOR_PERSISTENCE__CANVAS_WIDTH);
		createEAttribute(metaEditorPersistenceEClass, META_EDITOR_PERSISTENCE__CANVAS_HEIGHT);
		createEReference(metaEditorPersistenceEClass, META_EDITOR_PERSISTENCE__CANVAS_SECTIONS);

		elementPositionEClass = createEClass(ELEMENT_POSITION);
		createEReference(elementPositionEClass, ELEMENT_POSITION__ELEMENT);
		createEAttribute(elementPositionEClass, ELEMENT_POSITION__VISIBLE);
		createEAttribute(elementPositionEClass, ELEMENT_POSITION__MAGNETIZABLE);
		createEAttribute(elementPositionEClass, ELEMENT_POSITION__PINNED);

		bendableElementPositionEClass = createEClass(BENDABLE_ELEMENT_POSITION);
		createEReference(bendableElementPositionEClass, BENDABLE_ELEMENT_POSITION__BEND_POINTS);

		rotationPositionEClass = createEClass(ROTATION_POSITION);
		createEAttribute(rotationPositionEClass, ROTATION_POSITION__ROTATION_POSITION);

		bendPointEClass = createEClass(BEND_POINT);

		positionEClass = createEClass(POSITION);
		createEAttribute(positionEClass, POSITION__X);
		createEAttribute(positionEClass, POSITION__Y);
		createEAttribute(positionEClass, POSITION__Z);

		canvasSectionEClass = createEClass(CANVAS_SECTION);
		createEAttribute(canvasSectionEClass, CANVAS_SECTION__NAME);
		createEAttribute(canvasSectionEClass, CANVAS_SECTION__SECTION_WIDTH);
		createEAttribute(canvasSectionEClass, CANVAS_SECTION__SECTION_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MetaEditorConfigurationPackage theMetaEditorConfigurationPackage = (MetaEditorConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(MetaEditorConfigurationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		elementPositionEClass.getESuperTypes().add(this.getPosition());
		elementPositionEClass.getESuperTypes().add(this.getBendableElementPosition());
		elementPositionEClass.getESuperTypes().add(this.getRotationPosition());
		bendPointEClass.getESuperTypes().add(this.getPosition());

		// Initialize classes, features, and operations; add parameters
		initEClass(metaEditorPersistenceEClass, MetaEditorPersistence.class, "MetaEditorPersistence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaEditorPersistence_ElementPositions(), this.getElementPosition(), null, "elementPositions", null, 0, -1, MetaEditorPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaEditorPersistence_CanvasWidth(), ecorePackage.getEInt(), "canvasWidth", "0", 1, 1, MetaEditorPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaEditorPersistence_CanvasHeight(), ecorePackage.getEInt(), "canvasHeight", "0", 1, 1, MetaEditorPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetaEditorPersistence_CanvasSections(), this.getCanvasSection(), null, "canvasSections", null, 0, -1, MetaEditorPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementPositionEClass, ElementPosition.class, "ElementPosition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementPosition_Element(), ecorePackage.getEObject(), null, "element", null, 1, 1, ElementPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementPosition_Visible(), ecorePackage.getEBoolean(), "visible", "true", 1, 1, ElementPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementPosition_Magnetizable(), ecorePackage.getEBoolean(), "magnetizable", "true", 1, 1, ElementPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementPosition_Pinned(), ecorePackage.getEBoolean(), "pinned", "false", 1, 1, ElementPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bendableElementPositionEClass, BendableElementPosition.class, "BendableElementPosition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBendableElementPosition_BendPoints(), this.getBendPoint(), null, "bendPoints", null, 0, -1, BendableElementPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rotationPositionEClass, RotationPosition.class, "RotationPosition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRotationPosition_RotationPosition(), theMetaEditorConfigurationPackage.getRotationPosition(), "rotationPosition", null, 0, 1, RotationPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bendPointEClass, BendPoint.class, "BendPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(positionEClass, Position.class, "Position", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPosition_X(), ecorePackage.getEInt(), "x", "0", 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPosition_Y(), ecorePackage.getEInt(), "y", "0", 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPosition_Z(), ecorePackage.getEInt(), "z", "0", 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(canvasSectionEClass, CanvasSection.class, "CanvasSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCanvasSection_Name(), ecorePackage.getEString(), "name", "TBD", 1, 1, CanvasSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCanvasSection_SectionWidth(), ecorePackage.getEInt(), "sectionWidth", "0", 1, 1, CanvasSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCanvasSection_SectionHeight(), ecorePackage.getEInt(), "sectionHeight", "0", 1, 1, CanvasSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //MetaEditorPersistencePackageImpl
