/**
 */
package TelemetryPacketData;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packet Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link TelemetryPacketData.PacketData#getFrameTime <em>Frame Time</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getObrt <em>Obrt</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getPkt <em>Pkt</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getPktHeader <em>Pkt Header</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getPuslMaxDuration <em>Pusl Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getSatcmMaxDuration <em>Satcm Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getSsmaplMaxDuration <em>Ssmapl Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getSsmapfMaxDuration <em>Ssmapf Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getAocscmPreMaxD <em>Aocscm Pre Max D</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getAocnMaxDuration <em>Aocn Max Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getAocscmPostMaxDur <em>Aocscm Post Max Dur</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getCmgMxDuration <em>Cmg Mx Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getSfdirMxDuration <em>Sfdir Mx Duration</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getCodMaxDur <em>Cod Max Dur</em>}</li>
 *   <li>{@link TelemetryPacketData.PacketData#getPodMaxDur <em>Pod Max Dur</em>}</li>
 * </ul>
 *
 * @see TelemetryPacketData.PacketDataPackage#getPacketData()
 * @model
 * @generated
 */
public interface PacketData extends EObject {
	/**
	 * Returns the value of the '<em><b>Frame Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Time</em>' attribute.
	 * @see #setFrameTime(String)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_FrameTime()
	 * @model
	 * @generated
	 */
	String getFrameTime();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getFrameTime <em>Frame Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame Time</em>' attribute.
	 * @see #getFrameTime()
	 * @generated
	 */
	void setFrameTime(String value);

	/**
	 * Returns the value of the '<em><b>Obrt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obrt</em>' attribute.
	 * @see #setObrt(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_Obrt()
	 * @model
	 * @generated
	 */
	int getObrt();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getObrt <em>Obrt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obrt</em>' attribute.
	 * @see #getObrt()
	 * @generated
	 */
	void setObrt(int value);

	/**
	 * Returns the value of the '<em><b>Pkt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pkt</em>' attribute.
	 * @see #setPkt(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_Pkt()
	 * @model
	 * @generated
	 */
	int getPkt();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getPkt <em>Pkt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pkt</em>' attribute.
	 * @see #getPkt()
	 * @generated
	 */
	void setPkt(int value);

	/**
	 * Returns the value of the '<em><b>Pkt Header</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pkt Header</em>' attribute.
	 * @see #setPktHeader(String)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_PktHeader()
	 * @model
	 * @generated
	 */
	String getPktHeader();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getPktHeader <em>Pkt Header</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pkt Header</em>' attribute.
	 * @see #getPktHeader()
	 * @generated
	 */
	void setPktHeader(String value);

	/**
	 * Returns the value of the '<em><b>Pusl Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pusl Max Duration</em>' attribute.
	 * @see #setPuslMaxDuration(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_PuslMaxDuration()
	 * @model
	 * @generated
	 */
	int getPuslMaxDuration();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getPuslMaxDuration <em>Pusl Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pusl Max Duration</em>' attribute.
	 * @see #getPuslMaxDuration()
	 * @generated
	 */
	void setPuslMaxDuration(int value);

	/**
	 * Returns the value of the '<em><b>Satcm Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Satcm Max Duration</em>' attribute.
	 * @see #setSatcmMaxDuration(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_SatcmMaxDuration()
	 * @model
	 * @generated
	 */
	int getSatcmMaxDuration();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getSatcmMaxDuration <em>Satcm Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Satcm Max Duration</em>' attribute.
	 * @see #getSatcmMaxDuration()
	 * @generated
	 */
	void setSatcmMaxDuration(int value);

	/**
	 * Returns the value of the '<em><b>Ssmapl Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ssmapl Max Duration</em>' attribute.
	 * @see #setSsmaplMaxDuration(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_SsmaplMaxDuration()
	 * @model
	 * @generated
	 */
	int getSsmaplMaxDuration();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getSsmaplMaxDuration <em>Ssmapl Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssmapl Max Duration</em>' attribute.
	 * @see #getSsmaplMaxDuration()
	 * @generated
	 */
	void setSsmaplMaxDuration(int value);

	/**
	 * Returns the value of the '<em><b>Ssmapf Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ssmapf Max Duration</em>' attribute.
	 * @see #setSsmapfMaxDuration(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_SsmapfMaxDuration()
	 * @model
	 * @generated
	 */
	int getSsmapfMaxDuration();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getSsmapfMaxDuration <em>Ssmapf Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ssmapf Max Duration</em>' attribute.
	 * @see #getSsmapfMaxDuration()
	 * @generated
	 */
	void setSsmapfMaxDuration(int value);

	/**
	 * Returns the value of the '<em><b>Aocscm Pre Max D</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aocscm Pre Max D</em>' attribute.
	 * @see #setAocscmPreMaxD(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_AocscmPreMaxD()
	 * @model
	 * @generated
	 */
	int getAocscmPreMaxD();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getAocscmPreMaxD <em>Aocscm Pre Max D</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aocscm Pre Max D</em>' attribute.
	 * @see #getAocscmPreMaxD()
	 * @generated
	 */
	void setAocscmPreMaxD(int value);

	/**
	 * Returns the value of the '<em><b>Aocn Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aocn Max Duration</em>' attribute.
	 * @see #setAocnMaxDuration(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_AocnMaxDuration()
	 * @model
	 * @generated
	 */
	int getAocnMaxDuration();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getAocnMaxDuration <em>Aocn Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aocn Max Duration</em>' attribute.
	 * @see #getAocnMaxDuration()
	 * @generated
	 */
	void setAocnMaxDuration(int value);

	/**
	 * Returns the value of the '<em><b>Aocscm Post Max Dur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aocscm Post Max Dur</em>' attribute.
	 * @see #setAocscmPostMaxDur(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_AocscmPostMaxDur()
	 * @model
	 * @generated
	 */
	int getAocscmPostMaxDur();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getAocscmPostMaxDur <em>Aocscm Post Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aocscm Post Max Dur</em>' attribute.
	 * @see #getAocscmPostMaxDur()
	 * @generated
	 */
	void setAocscmPostMaxDur(int value);

	/**
	 * Returns the value of the '<em><b>Cmg Mx Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cmg Mx Duration</em>' attribute.
	 * @see #setCmgMxDuration(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_CmgMxDuration()
	 * @model
	 * @generated
	 */
	int getCmgMxDuration();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getCmgMxDuration <em>Cmg Mx Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cmg Mx Duration</em>' attribute.
	 * @see #getCmgMxDuration()
	 * @generated
	 */
	void setCmgMxDuration(int value);

	/**
	 * Returns the value of the '<em><b>Sfdir Mx Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sfdir Mx Duration</em>' attribute.
	 * @see #setSfdirMxDuration(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_SfdirMxDuration()
	 * @model
	 * @generated
	 */
	int getSfdirMxDuration();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getSfdirMxDuration <em>Sfdir Mx Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sfdir Mx Duration</em>' attribute.
	 * @see #getSfdirMxDuration()
	 * @generated
	 */
	void setSfdirMxDuration(int value);

	/**
	 * Returns the value of the '<em><b>Cod Max Dur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cod Max Dur</em>' attribute.
	 * @see #setCodMaxDur(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_CodMaxDur()
	 * @model
	 * @generated
	 */
	int getCodMaxDur();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getCodMaxDur <em>Cod Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cod Max Dur</em>' attribute.
	 * @see #getCodMaxDur()
	 * @generated
	 */
	void setCodMaxDur(int value);

	/**
	 * Returns the value of the '<em><b>Pod Max Dur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pod Max Dur</em>' attribute.
	 * @see #setPodMaxDur(int)
	 * @see TelemetryPacketData.PacketDataPackage#getPacketData_PodMaxDur()
	 * @model
	 * @generated
	 */
	int getPodMaxDur();

	/**
	 * Sets the value of the '{@link TelemetryPacketData.PacketData#getPodMaxDur <em>Pod Max Dur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pod Max Dur</em>' attribute.
	 * @see #getPodMaxDur()
	 * @generated
	 */
	void setPodMaxDur(int value);

} // PacketData
