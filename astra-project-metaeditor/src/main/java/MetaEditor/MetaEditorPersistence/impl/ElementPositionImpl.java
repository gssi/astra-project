/**
 */
package MetaEditor.MetaEditorPersistence.impl;

import MetaEditor.MetaEditorConfiguration.RotationPosition;

import MetaEditor.MetaEditorPersistence.BendPoint;
import MetaEditor.MetaEditorPersistence.BendableElementPosition;
import MetaEditor.MetaEditorPersistence.ElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl#getBendPoints <em>Bend Points</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl#getRotationPosition <em>Rotation Position</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl#getElement <em>Element</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl#isMagnetizable <em>Magnetizable</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.ElementPositionImpl#isPinned <em>Pinned</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementPositionImpl extends PositionImpl implements ElementPosition {
	/**
	 * The cached value of the '{@link #getBendPoints() <em>Bend Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBendPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<BendPoint> bendPoints;

	/**
	 * The default value of the '{@link #getRotationPosition() <em>Rotation Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotationPosition()
	 * @generated
	 * @ordered
	 */
	protected static final RotationPosition ROTATION_POSITION_EDEFAULT = RotationPosition.DEFAULT;

	/**
	 * The cached value of the '{@link #getRotationPosition() <em>Rotation Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRotationPosition()
	 * @generated
	 * @ordered
	 */
	protected RotationPosition rotationPosition = ROTATION_POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected EObject element;

	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMagnetizable() <em>Magnetizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMagnetizable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAGNETIZABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMagnetizable() <em>Magnetizable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMagnetizable()
	 * @generated
	 * @ordered
	 */
	protected boolean magnetizable = MAGNETIZABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPinned() <em>Pinned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPinned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PINNED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPinned() <em>Pinned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPinned()
	 * @generated
	 * @ordered
	 */
	protected boolean pinned = PINNED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementPositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorPersistencePackage.Literals.ELEMENT_POSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BendPoint> getBendPoints() {
		if (bendPoints == null) {
			bendPoints = new EObjectContainmentEList<BendPoint>(BendPoint.class, this, MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS);
		}
		return bendPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RotationPosition getRotationPosition() {
		return rotationPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRotationPosition(RotationPosition newRotationPosition) {
		RotationPosition oldRotationPosition = rotationPosition;
		rotationPosition = newRotationPosition == null ? ROTATION_POSITION_EDEFAULT : newRotationPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.ELEMENT_POSITION__ROTATION_POSITION, oldRotationPosition, rotationPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetaEditorPersistencePackage.ELEMENT_POSITION__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement(EObject newElement) {
		EObject oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.ELEMENT_POSITION__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisible(boolean newVisible) {
		boolean oldVisible = visible;
		visible = newVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.ELEMENT_POSITION__VISIBLE, oldVisible, visible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMagnetizable() {
		return magnetizable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMagnetizable(boolean newMagnetizable) {
		boolean oldMagnetizable = magnetizable;
		magnetizable = newMagnetizable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.ELEMENT_POSITION__MAGNETIZABLE, oldMagnetizable, magnetizable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPinned() {
		return pinned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPinned(boolean newPinned) {
		boolean oldPinned = pinned;
		pinned = newPinned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorPersistencePackage.ELEMENT_POSITION__PINNED, oldPinned, pinned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS:
				return ((InternalEList<?>)getBendPoints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS:
				return getBendPoints();
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ROTATION_POSITION:
				return getRotationPosition();
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case MetaEditorPersistencePackage.ELEMENT_POSITION__VISIBLE:
				return isVisible();
			case MetaEditorPersistencePackage.ELEMENT_POSITION__MAGNETIZABLE:
				return isMagnetizable();
			case MetaEditorPersistencePackage.ELEMENT_POSITION__PINNED:
				return isPinned();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS:
				getBendPoints().clear();
				getBendPoints().addAll((Collection<? extends BendPoint>)newValue);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ROTATION_POSITION:
				setRotationPosition((RotationPosition)newValue);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ELEMENT:
				setElement((EObject)newValue);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__VISIBLE:
				setVisible((Boolean)newValue);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__MAGNETIZABLE:
				setMagnetizable((Boolean)newValue);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__PINNED:
				setPinned((Boolean)newValue);
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
			case MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS:
				getBendPoints().clear();
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ROTATION_POSITION:
				setRotationPosition(ROTATION_POSITION_EDEFAULT);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ELEMENT:
				setElement((EObject)null);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__VISIBLE:
				setVisible(VISIBLE_EDEFAULT);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__MAGNETIZABLE:
				setMagnetizable(MAGNETIZABLE_EDEFAULT);
				return;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__PINNED:
				setPinned(PINNED_EDEFAULT);
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
			case MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS:
				return bendPoints != null && !bendPoints.isEmpty();
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ROTATION_POSITION:
				return rotationPosition != ROTATION_POSITION_EDEFAULT;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__ELEMENT:
				return element != null;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__VISIBLE:
				return visible != VISIBLE_EDEFAULT;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__MAGNETIZABLE:
				return magnetizable != MAGNETIZABLE_EDEFAULT;
			case MetaEditorPersistencePackage.ELEMENT_POSITION__PINNED:
				return pinned != PINNED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BendableElementPosition.class) {
			switch (derivedFeatureID) {
				case MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS: return MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS;
				default: return -1;
			}
		}
		if (baseClass == MetaEditor.MetaEditorPersistence.RotationPosition.class) {
			switch (derivedFeatureID) {
				case MetaEditorPersistencePackage.ELEMENT_POSITION__ROTATION_POSITION: return MetaEditorPersistencePackage.ROTATION_POSITION__ROTATION_POSITION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BendableElementPosition.class) {
			switch (baseFeatureID) {
				case MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS: return MetaEditorPersistencePackage.ELEMENT_POSITION__BEND_POINTS;
				default: return -1;
			}
		}
		if (baseClass == MetaEditor.MetaEditorPersistence.RotationPosition.class) {
			switch (baseFeatureID) {
				case MetaEditorPersistencePackage.ROTATION_POSITION__ROTATION_POSITION: return MetaEditorPersistencePackage.ELEMENT_POSITION__ROTATION_POSITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(", visible: ");
		result.append(visible);
		result.append(", magnetizable: ");
		result.append(magnetizable);
		result.append(", pinned: ");
		result.append(pinned);
		result.append(')');
		return result.toString();
	}

} //ElementPositionImpl
