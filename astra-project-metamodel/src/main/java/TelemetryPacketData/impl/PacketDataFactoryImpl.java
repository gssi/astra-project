/**
 */
package TelemetryPacketData.impl;

import TelemetryPacketData.*;

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
public class PacketDataFactoryImpl extends EFactoryImpl implements PacketDataFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PacketDataFactory init() {
		try {
			PacketDataFactory thePacketDataFactory = (PacketDataFactory)EPackage.Registry.INSTANCE.getEFactory(PacketDataPackage.eNS_URI);
			if (thePacketDataFactory != null) {
				return thePacketDataFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PacketDataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PacketDataFactoryImpl() {
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
			case PacketDataPackage.PACKET_DATA_MODEL: return createPacketDataModel();
			case PacketDataPackage.PACKET_DATA: return createPacketData();
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
	public PacketDataModel createPacketDataModel() {
		PacketDataModelImpl packetDataModel = new PacketDataModelImpl();
		return packetDataModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PacketData createPacketData() {
		PacketDataImpl packetData = new PacketDataImpl();
		return packetData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PacketDataPackage getPacketDataPackage() {
		return (PacketDataPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PacketDataPackage getPackage() {
		return PacketDataPackage.eINSTANCE;
	}

} //PacketDataFactoryImpl
