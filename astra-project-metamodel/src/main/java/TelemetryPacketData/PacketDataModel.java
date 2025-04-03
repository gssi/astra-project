/**
 */
package TelemetryPacketData;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link TelemetryPacketData.PacketDataModel#getPacketData <em>Packet Data</em>}</li>
 * </ul>
 *
 * @see TelemetryPacketData.PacketDataPackage#getPacketDataModel()
 * @model
 * @generated
 */
public interface PacketDataModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Packet Data</b></em>' containment reference list.
	 * The list contents are of type {@link TelemetryPacketData.PacketData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packet Data</em>' containment reference list.
	 * @see TelemetryPacketData.PacketDataPackage#getPacketDataModel_PacketData()
	 * @model containment="true"
	 * @generated
	 */
	EList<PacketData> getPacketData();

} // PacketDataModel
