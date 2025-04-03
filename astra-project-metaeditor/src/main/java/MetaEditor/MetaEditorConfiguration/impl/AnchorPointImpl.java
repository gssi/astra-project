/**
 */
package MetaEditor.MetaEditorConfiguration.impl;

import MetaEditor.MetaEditorConfiguration.AnchorPoint;
import MetaEditor.MetaEditorConfiguration.MetaEditorConfigurationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Anchor Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.AnchorPointImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.AnchorPointImpl#getConnectableAnchorPoints <em>Connectable Anchor Points</em>}</li>
 *   <li>{@link MetaEditor.MetaEditorConfiguration.impl.AnchorPointImpl#isFullAnchorPoint <em>Full Anchor Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnchorPointImpl extends NamedElementImpl implements AnchorPoint {
	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EReference ref;

	/**
	 * The cached value of the '{@link #getConnectableAnchorPoints() <em>Connectable Anchor Points</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectableAnchorPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<AnchorPoint> connectableAnchorPoints;

	/**
	 * The default value of the '{@link #isFullAnchorPoint() <em>Full Anchor Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullAnchorPoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FULL_ANCHOR_POINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFullAnchorPoint() <em>Full Anchor Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFullAnchorPoint()
	 * @generated
	 * @ordered
	 */
	protected boolean fullAnchorPoint = FULL_ANCHOR_POINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnchorPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorConfigurationPackage.Literals.ANCHOR_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (EReference)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MetaEditorConfigurationPackage.ANCHOR_POINT__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRef(EReference newRef) {
		EReference oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.ANCHOR_POINT__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AnchorPoint> getConnectableAnchorPoints() {
		if (connectableAnchorPoints == null) {
			connectableAnchorPoints = new EObjectResolvingEList<AnchorPoint>(AnchorPoint.class, this, MetaEditorConfigurationPackage.ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS);
		}
		return connectableAnchorPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFullAnchorPoint() {
		return fullAnchorPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFullAnchorPoint(boolean newFullAnchorPoint) {
		boolean oldFullAnchorPoint = fullAnchorPoint;
		fullAnchorPoint = newFullAnchorPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetaEditorConfigurationPackage.ANCHOR_POINT__FULL_ANCHOR_POINT, oldFullAnchorPoint, fullAnchorPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetaEditorConfigurationPackage.ANCHOR_POINT__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case MetaEditorConfigurationPackage.ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS:
				return getConnectableAnchorPoints();
			case MetaEditorConfigurationPackage.ANCHOR_POINT__FULL_ANCHOR_POINT:
				return isFullAnchorPoint();
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
			case MetaEditorConfigurationPackage.ANCHOR_POINT__REF:
				setRef((EReference)newValue);
				return;
			case MetaEditorConfigurationPackage.ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS:
				getConnectableAnchorPoints().clear();
				getConnectableAnchorPoints().addAll((Collection<? extends AnchorPoint>)newValue);
				return;
			case MetaEditorConfigurationPackage.ANCHOR_POINT__FULL_ANCHOR_POINT:
				setFullAnchorPoint((Boolean)newValue);
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
			case MetaEditorConfigurationPackage.ANCHOR_POINT__REF:
				setRef((EReference)null);
				return;
			case MetaEditorConfigurationPackage.ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS:
				getConnectableAnchorPoints().clear();
				return;
			case MetaEditorConfigurationPackage.ANCHOR_POINT__FULL_ANCHOR_POINT:
				setFullAnchorPoint(FULL_ANCHOR_POINT_EDEFAULT);
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
			case MetaEditorConfigurationPackage.ANCHOR_POINT__REF:
				return ref != null;
			case MetaEditorConfigurationPackage.ANCHOR_POINT__CONNECTABLE_ANCHOR_POINTS:
				return connectableAnchorPoints != null && !connectableAnchorPoints.isEmpty();
			case MetaEditorConfigurationPackage.ANCHOR_POINT__FULL_ANCHOR_POINT:
				return fullAnchorPoint != FULL_ANCHOR_POINT_EDEFAULT;
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
		result.append(" (fullAnchorPoint: ");
		result.append(fullAnchorPoint);
		result.append(')');
		return result.toString();
	}

} //AnchorPointImpl
