/**
 */
package TelemetryPacketData.impl;

import TelemetryPacketData.PacketData;
import TelemetryPacketData.PacketDataFactory;
import TelemetryPacketData.PacketDataModel;
import TelemetryPacketData.PacketDataPackage;

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
public class PacketDataPackageImpl extends EPackageImpl implements PacketDataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packetDataModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packetDataEClass = null;

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
	 * @see TelemetryPacketData.PacketDataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PacketDataPackageImpl() {
		super(eNS_URI, PacketDataFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PacketDataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PacketDataPackage init() {
		if (isInited) return (PacketDataPackage)EPackage.Registry.INSTANCE.getEPackage(PacketDataPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredPacketDataPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PacketDataPackageImpl thePacketDataPackage = registeredPacketDataPackage instanceof PacketDataPackageImpl ? (PacketDataPackageImpl)registeredPacketDataPackage : new PacketDataPackageImpl();

		isInited = true;

		// Create package meta-data objects
		thePacketDataPackage.createPackageContents();

		// Initialize created meta-data
		thePacketDataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePacketDataPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PacketDataPackage.eNS_URI, thePacketDataPackage);
		return thePacketDataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPacketDataModel() {
		return packetDataModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPacketDataModel_PacketData() {
		return (EReference)packetDataModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPacketData() {
		return packetDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_FrameTime() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_Obrt() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_Pkt() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_PktHeader() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_PuslMaxDuration() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_SatcmMaxDuration() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_SsmaplMaxDuration() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_SsmapfMaxDuration() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_AocscmPreMaxD() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_AocnMaxDuration() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_AocscmPostMaxDur() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_CmgMxDuration() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_SfdirMxDuration() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_CodMaxDur() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPacketData_PodMaxDur() {
		return (EAttribute)packetDataEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PacketDataFactory getPacketDataFactory() {
		return (PacketDataFactory)getEFactoryInstance();
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
		packetDataModelEClass = createEClass(PACKET_DATA_MODEL);
		createEReference(packetDataModelEClass, PACKET_DATA_MODEL__PACKET_DATA);

		packetDataEClass = createEClass(PACKET_DATA);
		createEAttribute(packetDataEClass, PACKET_DATA__FRAME_TIME);
		createEAttribute(packetDataEClass, PACKET_DATA__OBRT);
		createEAttribute(packetDataEClass, PACKET_DATA__PKT);
		createEAttribute(packetDataEClass, PACKET_DATA__PKT_HEADER);
		createEAttribute(packetDataEClass, PACKET_DATA__PUSL_MAX_DURATION);
		createEAttribute(packetDataEClass, PACKET_DATA__SATCM_MAX_DURATION);
		createEAttribute(packetDataEClass, PACKET_DATA__SSMAPL_MAX_DURATION);
		createEAttribute(packetDataEClass, PACKET_DATA__SSMAPF_MAX_DURATION);
		createEAttribute(packetDataEClass, PACKET_DATA__AOCSCM_PRE_MAX_D);
		createEAttribute(packetDataEClass, PACKET_DATA__AOCN_MAX_DURATION);
		createEAttribute(packetDataEClass, PACKET_DATA__AOCSCM_POST_MAX_DUR);
		createEAttribute(packetDataEClass, PACKET_DATA__CMG_MX_DURATION);
		createEAttribute(packetDataEClass, PACKET_DATA__SFDIR_MX_DURATION);
		createEAttribute(packetDataEClass, PACKET_DATA__COD_MAX_DUR);
		createEAttribute(packetDataEClass, PACKET_DATA__POD_MAX_DUR);
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

		// Initialize classes, features, and operations; add parameters
		initEClass(packetDataModelEClass, PacketDataModel.class, "PacketDataModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPacketDataModel_PacketData(), this.getPacketData(), null, "packetData", null, 0, -1, PacketDataModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packetDataEClass, PacketData.class, "PacketData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPacketData_FrameTime(), ecorePackage.getEString(), "frameTime", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_Obrt(), ecorePackage.getEInt(), "obrt", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_Pkt(), ecorePackage.getEInt(), "pkt", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_PktHeader(), ecorePackage.getEString(), "pktHeader", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_PuslMaxDuration(), ecorePackage.getEInt(), "puslMaxDuration", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_SatcmMaxDuration(), ecorePackage.getEInt(), "satcmMaxDuration", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_SsmaplMaxDuration(), ecorePackage.getEInt(), "ssmaplMaxDuration", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_SsmapfMaxDuration(), ecorePackage.getEInt(), "ssmapfMaxDuration", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_AocscmPreMaxD(), ecorePackage.getEInt(), "aocscmPreMaxD", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_AocnMaxDuration(), ecorePackage.getEInt(), "aocnMaxDuration", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_AocscmPostMaxDur(), ecorePackage.getEInt(), "aocscmPostMaxDur", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_CmgMxDuration(), ecorePackage.getEInt(), "cmgMxDuration", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_SfdirMxDuration(), ecorePackage.getEInt(), "sfdirMxDuration", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_CodMaxDur(), ecorePackage.getEInt(), "codMaxDur", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPacketData_PodMaxDur(), ecorePackage.getEInt(), "podMaxDur", null, 0, 1, PacketData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PacketDataPackageImpl
