/**
 */
package TelemetryPacketData;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see TelemetryPacketData.PacketDataFactory
 * @model kind="package"
 * @generated
 */
public interface PacketDataPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "TelemetryPacketData";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "gssi.astra.telemetry.packetdata";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gssi.astra.telemetry.packetdata";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PacketDataPackage eINSTANCE = TelemetryPacketData.impl.PacketDataPackageImpl.init();

	/**
	 * The meta object id for the '{@link TelemetryPacketData.impl.PacketDataModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TelemetryPacketData.impl.PacketDataModelImpl
	 * @see TelemetryPacketData.impl.PacketDataPackageImpl#getPacketDataModel()
	 * @generated
	 */
	int PACKET_DATA_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Packet Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA_MODEL__PACKET_DATA = 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA_MODEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link TelemetryPacketData.impl.PacketDataImpl <em>Packet Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see TelemetryPacketData.impl.PacketDataImpl
	 * @see TelemetryPacketData.impl.PacketDataPackageImpl#getPacketData()
	 * @generated
	 */
	int PACKET_DATA = 1;

	/**
	 * The feature id for the '<em><b>Frame Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__FRAME_TIME = 0;

	/**
	 * The feature id for the '<em><b>Obrt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__OBRT = 1;

	/**
	 * The feature id for the '<em><b>Pkt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__PKT = 2;

	/**
	 * The feature id for the '<em><b>Pkt Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__PKT_HEADER = 3;

	/**
	 * The feature id for the '<em><b>Pusl Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__PUSL_MAX_DURATION = 4;

	/**
	 * The feature id for the '<em><b>Satcm Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__SATCM_MAX_DURATION = 5;

	/**
	 * The feature id for the '<em><b>Ssmapl Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__SSMAPL_MAX_DURATION = 6;

	/**
	 * The feature id for the '<em><b>Ssmapf Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__SSMAPF_MAX_DURATION = 7;

	/**
	 * The feature id for the '<em><b>Aocscm Pre Max D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__AOCSCM_PRE_MAX_D = 8;

	/**
	 * The feature id for the '<em><b>Aocn Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__AOCN_MAX_DURATION = 9;

	/**
	 * The feature id for the '<em><b>Aocscm Post Max Dur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__AOCSCM_POST_MAX_DUR = 10;

	/**
	 * The feature id for the '<em><b>Cmg Mx Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__CMG_MX_DURATION = 11;

	/**
	 * The feature id for the '<em><b>Sfdir Mx Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__SFDIR_MX_DURATION = 12;

	/**
	 * The feature id for the '<em><b>Cod Max Dur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__COD_MAX_DUR = 13;

	/**
	 * The feature id for the '<em><b>Pod Max Dur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA__POD_MAX_DUR = 14;

	/**
	 * The number of structural features of the '<em>Packet Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Packet Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKET_DATA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link TelemetryPacketData.PacketDataModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see TelemetryPacketData.PacketDataModel
	 * @generated
	 */
	EClass getPacketDataModel();

	/**
	 * Returns the meta object for the containment reference list '{@link TelemetryPacketData.PacketDataModel#getPacketData <em>Packet Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packet Data</em>'.
	 * @see TelemetryPacketData.PacketDataModel#getPacketData()
	 * @see #getPacketDataModel()
	 * @generated
	 */
	EReference getPacketDataModel_PacketData();

	/**
	 * Returns the meta object for class '{@link TelemetryPacketData.PacketData <em>Packet Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packet Data</em>'.
	 * @see TelemetryPacketData.PacketData
	 * @generated
	 */
	EClass getPacketData();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getFrameTime <em>Frame Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame Time</em>'.
	 * @see TelemetryPacketData.PacketData#getFrameTime()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_FrameTime();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getObrt <em>Obrt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obrt</em>'.
	 * @see TelemetryPacketData.PacketData#getObrt()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_Obrt();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getPkt <em>Pkt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pkt</em>'.
	 * @see TelemetryPacketData.PacketData#getPkt()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_Pkt();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getPktHeader <em>Pkt Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pkt Header</em>'.
	 * @see TelemetryPacketData.PacketData#getPktHeader()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_PktHeader();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getPuslMaxDuration <em>Pusl Max Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pusl Max Duration</em>'.
	 * @see TelemetryPacketData.PacketData#getPuslMaxDuration()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_PuslMaxDuration();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getSatcmMaxDuration <em>Satcm Max Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Satcm Max Duration</em>'.
	 * @see TelemetryPacketData.PacketData#getSatcmMaxDuration()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_SatcmMaxDuration();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getSsmaplMaxDuration <em>Ssmapl Max Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ssmapl Max Duration</em>'.
	 * @see TelemetryPacketData.PacketData#getSsmaplMaxDuration()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_SsmaplMaxDuration();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getSsmapfMaxDuration <em>Ssmapf Max Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ssmapf Max Duration</em>'.
	 * @see TelemetryPacketData.PacketData#getSsmapfMaxDuration()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_SsmapfMaxDuration();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getAocscmPreMaxD <em>Aocscm Pre Max D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aocscm Pre Max D</em>'.
	 * @see TelemetryPacketData.PacketData#getAocscmPreMaxD()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_AocscmPreMaxD();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getAocnMaxDuration <em>Aocn Max Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aocn Max Duration</em>'.
	 * @see TelemetryPacketData.PacketData#getAocnMaxDuration()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_AocnMaxDuration();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getAocscmPostMaxDur <em>Aocscm Post Max Dur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aocscm Post Max Dur</em>'.
	 * @see TelemetryPacketData.PacketData#getAocscmPostMaxDur()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_AocscmPostMaxDur();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getCmgMxDuration <em>Cmg Mx Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cmg Mx Duration</em>'.
	 * @see TelemetryPacketData.PacketData#getCmgMxDuration()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_CmgMxDuration();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getSfdirMxDuration <em>Sfdir Mx Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sfdir Mx Duration</em>'.
	 * @see TelemetryPacketData.PacketData#getSfdirMxDuration()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_SfdirMxDuration();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getCodMaxDur <em>Cod Max Dur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cod Max Dur</em>'.
	 * @see TelemetryPacketData.PacketData#getCodMaxDur()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_CodMaxDur();

	/**
	 * Returns the meta object for the attribute '{@link TelemetryPacketData.PacketData#getPodMaxDur <em>Pod Max Dur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pod Max Dur</em>'.
	 * @see TelemetryPacketData.PacketData#getPodMaxDur()
	 * @see #getPacketData()
	 * @generated
	 */
	EAttribute getPacketData_PodMaxDur();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PacketDataFactory getPacketDataFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link TelemetryPacketData.impl.PacketDataModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TelemetryPacketData.impl.PacketDataModelImpl
		 * @see TelemetryPacketData.impl.PacketDataPackageImpl#getPacketDataModel()
		 * @generated
		 */
		EClass PACKET_DATA_MODEL = eINSTANCE.getPacketDataModel();

		/**
		 * The meta object literal for the '<em><b>Packet Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKET_DATA_MODEL__PACKET_DATA = eINSTANCE.getPacketDataModel_PacketData();

		/**
		 * The meta object literal for the '{@link TelemetryPacketData.impl.PacketDataImpl <em>Packet Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see TelemetryPacketData.impl.PacketDataImpl
		 * @see TelemetryPacketData.impl.PacketDataPackageImpl#getPacketData()
		 * @generated
		 */
		EClass PACKET_DATA = eINSTANCE.getPacketData();

		/**
		 * The meta object literal for the '<em><b>Frame Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__FRAME_TIME = eINSTANCE.getPacketData_FrameTime();

		/**
		 * The meta object literal for the '<em><b>Obrt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__OBRT = eINSTANCE.getPacketData_Obrt();

		/**
		 * The meta object literal for the '<em><b>Pkt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__PKT = eINSTANCE.getPacketData_Pkt();

		/**
		 * The meta object literal for the '<em><b>Pkt Header</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__PKT_HEADER = eINSTANCE.getPacketData_PktHeader();

		/**
		 * The meta object literal for the '<em><b>Pusl Max Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__PUSL_MAX_DURATION = eINSTANCE.getPacketData_PuslMaxDuration();

		/**
		 * The meta object literal for the '<em><b>Satcm Max Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__SATCM_MAX_DURATION = eINSTANCE.getPacketData_SatcmMaxDuration();

		/**
		 * The meta object literal for the '<em><b>Ssmapl Max Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__SSMAPL_MAX_DURATION = eINSTANCE.getPacketData_SsmaplMaxDuration();

		/**
		 * The meta object literal for the '<em><b>Ssmapf Max Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__SSMAPF_MAX_DURATION = eINSTANCE.getPacketData_SsmapfMaxDuration();

		/**
		 * The meta object literal for the '<em><b>Aocscm Pre Max D</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__AOCSCM_PRE_MAX_D = eINSTANCE.getPacketData_AocscmPreMaxD();

		/**
		 * The meta object literal for the '<em><b>Aocn Max Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__AOCN_MAX_DURATION = eINSTANCE.getPacketData_AocnMaxDuration();

		/**
		 * The meta object literal for the '<em><b>Aocscm Post Max Dur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__AOCSCM_POST_MAX_DUR = eINSTANCE.getPacketData_AocscmPostMaxDur();

		/**
		 * The meta object literal for the '<em><b>Cmg Mx Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__CMG_MX_DURATION = eINSTANCE.getPacketData_CmgMxDuration();

		/**
		 * The meta object literal for the '<em><b>Sfdir Mx Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__SFDIR_MX_DURATION = eINSTANCE.getPacketData_SfdirMxDuration();

		/**
		 * The meta object literal for the '<em><b>Cod Max Dur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__COD_MAX_DUR = eINSTANCE.getPacketData_CodMaxDur();

		/**
		 * The meta object literal for the '<em><b>Pod Max Dur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKET_DATA__POD_MAX_DUR = eINSTANCE.getPacketData_PodMaxDur();

	}

} //PacketDataPackage
