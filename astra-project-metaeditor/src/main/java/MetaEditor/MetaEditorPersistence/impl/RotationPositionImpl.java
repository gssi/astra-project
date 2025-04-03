/**
 */
package MetaEditor.MetaEditorPersistence.impl;

import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;
import MetaEditor.MetaEditorPersistence.RotationPosition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rotation Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.RotationPositionImpl#getRotationPosition <em>Rotation Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RotationPositionImpl extends MinimalEObjectImpl.Container implements RotationPosition {
	/**
	 * The default value of the '{@link #getRotationPosition() <em>Rotation Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotationPosition()
	 * @generated
	 * @ordered
	 */
	protected static final MetaEditor.MetaEditorConfiguration.RotationPosition ROTATION_POSITION_EDEFAULT = MetaEditor.MetaEditorConfiguration.RotationPosition.DEFAULT;

	/**
	 * The cached value of the '{@link #getRotationPosition() <em>Rotation Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotationPosition()
	 * @generated
	 * @ordered
	 */
	protected MetaEditor.MetaEditorConfiguration.RotationPosition rotationPosition = ROTATION_POSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RotationPositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorPersistencePackage.Literals.ROTATION_POSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaEditor.MetaEditorConfiguration.RotationPosition getRotationPosition() {
		return rotationPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationPosition(MetaEditor.MetaEditorConfiguration.RotationPosition newRotationPosition) {
		MetaEditor.MetaEditorConfiguration.RotationPosition oldRotationPosition = rotationPosition;
		rotationPosition = newRotationPosition == null ? ROTATION_POSITION_EDEFAULT : newRotationPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.ROTATION_POSITION__ROTATION_POSITION, oldRotationPosition, rotationPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorPersistencePackage.ROTATION_POSITION__ROTATION_POSITION:
				return getRotationPosition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetaEditorPersistencePackage.ROTATION_POSITION__ROTATION_POSITION:
				setRotationPosition((MetaEditor.MetaEditorConfiguration.RotationPosition)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetaEditorPersistencePackage.ROTATION_POSITION__ROTATION_POSITION:
				setRotationPosition(ROTATION_POSITION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetaEditorPersistencePackage.ROTATION_POSITION__ROTATION_POSITION:
				return rotationPosition != ROTATION_POSITION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (rotationPosition: ");
		result.append(rotationPosition);
		result.append(')');
		return result.toString();
	}

} //RotationPositionImpl
