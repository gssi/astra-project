/**
 */
package MetaEditor.MetaEditorConfiguration.impl;

import MetaEditor.MetaEditorConfiguration.AnchorPoint;
import MetaEditor.MetaEditorConfiguration.ConfigurationOptions;
import MetaEditor.MetaEditorConfiguration.GraphicalElement;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfiguration;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationFactory;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;
import MetaEditor.MetaEditorConfiguration.NamedElement;
import MetaEditor.MetaEditorConfiguration.RotationPosition;

import MetaEditor.MetaEditorConfiguration.UneditableFeaturesElement;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;

import MetaEditor.MetaEditorPersistence.impl.MetaEditorPersistencePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetaEditorConfigurationPackageImpl extends EPackageImpl implements MetaEditorConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uneditableFeaturesElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaEditorConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anchorPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationOptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rotationPositionEEnum = null;

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
	 * @see MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetaEditorConfigurationPackageImpl() {
		super(eNS_URI, MetaEditorConfigurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MetaEditorConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetaEditorConfigurationPackage init() {
		if (isInited) return (MetaEditorConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(MetaEditorConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetaEditorConfigurationPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetaEditorConfigurationPackageImpl theMetaEditorConfigurationPackage = registeredMetaEditorConfigurationPackage instanceof MetaEditorConfigurationPackageImpl ? (MetaEditorConfigurationPackageImpl)registeredMetaEditorConfigurationPackage : new MetaEditorConfigurationPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MetaEditorPersistencePackage.eNS_URI);
		MetaEditorPersistencePackageImpl theMetaEditorPersistencePackage = (MetaEditorPersistencePackageImpl)(registeredPackage instanceof MetaEditorPersistencePackageImpl ? registeredPackage : MetaEditorPersistencePackage.eINSTANCE);

		// Create package meta-data objects
		theMetaEditorConfigurationPackage.createPackageContents();
		theMetaEditorPersistencePackage.createPackageContents();

		// Initialize created meta-data
		theMetaEditorConfigurationPackage.initializePackageContents();
		theMetaEditorPersistencePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetaEditorConfigurationPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetaEditorConfigurationPackage.eNS_URI, theMetaEditorConfigurationPackage);
		return theMetaEditorConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUneditableFeaturesElement() {
		return uneditableFeaturesElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUneditableFeaturesElement_UneditableFeatures() {
		return (EReference)uneditableFeaturesElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetaEditorConfiguration() {
		return metaEditorConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaEditorConfiguration_RootElement() {
		return (EReference)metaEditorConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaEditorConfiguration_GraphicalElements() {
		return (EReference)metaEditorConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaEditorConfiguration_InitCanvasWidth() {
		return (EAttribute)metaEditorConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaEditorConfiguration_InitCanvasHeight() {
		return (EAttribute)metaEditorConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaEditorConfiguration_ModelFileExtension() {
		return (EAttribute)metaEditorConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaEditorConfiguration_EditorIconPath() {
		return (EAttribute)metaEditorConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGraphicalElement() {
		return graphicalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicalElement_Element() {
		return (EReference)graphicalElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicalElement_FxmlPath() {
		return (EAttribute)graphicalElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicalElement_AnchorPoints() {
		return (EReference)graphicalElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGraphicalElement_IconPath() {
		return (EAttribute)graphicalElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicalElement_NameAttribute() {
		return (EReference)graphicalElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGraphicalElement_ContainmentRef() {
		return (EReference)graphicalElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnchorPoint() {
		return anchorPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnchorPoint_Ref() {
		return (EReference)anchorPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAnchorPoint_ConnectableAnchorPoints() {
		return (EReference)anchorPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnchorPoint_FullAnchorPoint() {
		return (EAttribute)anchorPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfigurationOptions() {
		return configurationOptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfigurationOptions_BendableElement() {
		return (EAttribute)configurationOptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfigurationOptions_RotationPositions() {
		return (EAttribute)configurationOptionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfigurationOptions_SelectWithParent() {
		return (EAttribute)configurationOptionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfigurationOptions_ZIndexDefault() {
		return (EAttribute)configurationOptionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRotationPosition() {
		return rotationPositionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaEditorConfigurationFactory getMetaEditorConfigurationFactory() {
		return (MetaEditorConfigurationFactory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		uneditableFeaturesElementEClass = createEClass(UNEDITABLE_FEATURES_ELEMENT);
		createEReference(uneditableFeaturesElementEClass, UNEDITABLE_FEATURES_ELEMENT__UNEDITABLE_FEATURES);

		metaEditorConfigurationEClass = createEClass(META_EDITOR_CONFIGURATION);
		createEReference(metaEditorConfigurationEClass, META_EDITOR_CONFIGURATION__ROOT_ELEMENT);
		createEReference(metaEditorConfigurationEClass, META_EDITOR_CONFIGURATION__GRAPHICAL_ELEMENTS);
		createEAttribute(metaEditorConfigurationEClass, META_EDITOR_CONFIGURATION__INIT_CANVAS_WIDTH);
		createEAttribute(metaEditorConfigurationEClass, META_EDITOR_CONFIGURATION__INIT_CANVAS_HEIGHT);
		createEAttribute(metaEditorConfigurationEClass, META_EDITOR_CONFIGURATION__MODEL_FILE_EXTENSION);
		createEAttribute(metaEditorConfigurationEClass, META_EDITOR_CONFIGURATION__EDITOR_ICON_PATH);

		graphicalElementEClass = createEClass(GRAPHICAL_ELEMENT);
		createEReference(graphicalElementEClass, GRAPHICAL_ELEMENT__ELEMENT);
		createEAttribute(graphicalElementEClass, GRAPHICAL_ELEMENT__FXML_PATH);
		createEReference(graphicalElementEClass, GRAPHICAL_ELEMENT__ANCHOR_POINTS);
		createEAttribute(graphicalElementEClass, GRAPHICAL_ELEMENT__ICON_PATH);
		createEReference(graphicalElementEClass, GRAPHICAL_ELEMENT__NAME_ATTRIBUTE);
		createEReference(graphicalElementEClass, GRAPHICAL_ELEMENT__CONTAINMENT_REF);

		anchorPointEClass = createEClass(ANCHOR_POINT);
		createEReference(anchorPointEClass, ANCHOR_POINT__REF);
		createEReference(anchorPointEClass, ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS);
		createEAttribute(anchorPointEClass, ANCHOR_POINT__FULL_ANCHOR_POINT);

		configurationOptionsEClass = createEClass(CONFIGURATION_OPTIONS);
		createEAttribute(configurationOptionsEClass, CONFIGURATION_OPTIONS__BENDABLE_ELEMENT);
		createEAttribute(configurationOptionsEClass, CONFIGURATION_OPTIONS__ROTATION_POSITIONS);
		createEAttribute(configurationOptionsEClass, CONFIGURATION_OPTIONS__SELECT_WITH_PARENT);
		createEAttribute(configurationOptionsEClass, CONFIGURATION_OPTIONS__ZINDEX_DEFAULT);

		// Create enums
		rotationPositionEEnum = createEEnum(ROTATION_POSITION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		metaEditorConfigurationEClass.getESuperTypes().add(this.getNamedElement());
		metaEditorConfigurationEClass.getESuperTypes().add(this.getUneditableFeaturesElement());
		graphicalElementEClass.getESuperTypes().add(this.getNamedElement());
		graphicalElementEClass.getESuperTypes().add(this.getUneditableFeaturesElement());
		graphicalElementEClass.getESuperTypes().add(this.getConfigurationOptions());
		anchorPointEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(uneditableFeaturesElementEClass, UneditableFeaturesElement.class, "UneditableFeaturesElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUneditableFeaturesElement_UneditableFeatures(), ecorePackage.getEStructuralFeature(), null, "uneditableFeatures", null, 0, -1, UneditableFeaturesElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaEditorConfigurationEClass, MetaEditorConfiguration.class, "MetaEditorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetaEditorConfiguration_RootElement(), ecorePackage.getEClass(), null, "rootElement", null, 1, 1, MetaEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetaEditorConfiguration_GraphicalElements(), this.getGraphicalElement(), null, "graphicalElements", null, 0, -1, MetaEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaEditorConfiguration_InitCanvasWidth(), ecorePackage.getEInt(), "initCanvasWidth", "1000", 1, 1, MetaEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaEditorConfiguration_InitCanvasHeight(), ecorePackage.getEInt(), "initCanvasHeight", "500", 1, 1, MetaEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaEditorConfiguration_ModelFileExtension(), ecorePackage.getEString(), "modelFileExtension", "xmi", 1, 1, MetaEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaEditorConfiguration_EditorIconPath(), ecorePackage.getEString(), "editorIconPath", null, 0, 1, MetaEditorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicalElementEClass, GraphicalElement.class, "GraphicalElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicalElement_Element(), ecorePackage.getEClass(), null, "element", null, 1, 1, GraphicalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalElement_FxmlPath(), ecorePackage.getEString(), "fxmlPath", "TBD", 1, 1, GraphicalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicalElement_AnchorPoints(), this.getAnchorPoint(), null, "anchorPoints", null, 0, -1, GraphicalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGraphicalElement_IconPath(), ecorePackage.getEString(), "iconPath", null, 0, 1, GraphicalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicalElement_NameAttribute(), ecorePackage.getEAttribute(), null, "nameAttribute", null, 0, 1, GraphicalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicalElement_ContainmentRef(), ecorePackage.getEReference(), null, "containmentRef", null, 1, -1, GraphicalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(anchorPointEClass, AnchorPoint.class, "AnchorPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnchorPoint_Ref(), ecorePackage.getEReference(), null, "ref", null, 0, 1, AnchorPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnchorPoint_ConnectableAnchorPoints(), this.getAnchorPoint(), null, "connectableAnchorPoints", null, 0, -1, AnchorPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnchorPoint_FullAnchorPoint(), ecorePackage.getEBoolean(), "fullAnchorPoint", "false", 1, 1, AnchorPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationOptionsEClass, ConfigurationOptions.class, "ConfigurationOptions", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationOptions_BendableElement(), ecorePackage.getEBoolean(), "bendableElement", "false", 1, 1, ConfigurationOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationOptions_RotationPositions(), this.getRotationPosition(), "rotationPositions", null, 0, -1, ConfigurationOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationOptions_SelectWithParent(), ecorePackage.getEBoolean(), "selectWithParent", "false", 1, 1, ConfigurationOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationOptions_ZIndexDefault(), ecorePackage.getEInt(), "zIndexDefault", "0", 1, 1, ConfigurationOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(rotationPositionEEnum, RotationPosition.class, "RotationPosition");
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.DEFAULT);
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.ROT45);
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.ROT90);
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.ROT135);
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.ROT180);
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.ROT225);
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.ROT270);
		addEEnumLiteral(rotationPositionEEnum, RotationPosition.ROT315);

		// Create resource
		createResource(eNS_URI);
	}

} //MetaEditorConfigurationPackageImpl
