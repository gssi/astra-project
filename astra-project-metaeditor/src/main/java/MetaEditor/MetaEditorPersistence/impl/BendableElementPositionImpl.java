/**
 */
package MetaEditor.MetaEditorPersistence.impl;

import MetaEditor.MetaEditorPersistence.BendPoint;
import MetaEditor.MetaEditorPersistence.BendableElementPosition;
import MetaEditor.MetaEditorPersistence.MetaEditorPersistencePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bendable Element Position</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link MetaEditor.MetaEditorPersistence.impl.BendableElementPositionImpl#getBendPoints <em>Bend Points</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BendableElementPositionImpl extends MinimalEObjectImpl.Container implements BendableElementPosition {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BendableElementPositionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetaEditorPersistencePackage.Literals.BENDABLE_ELEMENT_POSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BendPoint> getBendPoints() {
		if (bendPoints == null) {
			bendPoints = new EObjectContainmentEList<BendPoint>(BendPoint.class, this, MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS);
		}
		return bendPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS:
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
			case MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS:
				return getBendPoints();
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
			case MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS:
				getBendPoints().clear();
				getBendPoints().addAll((Collection<? extends BendPoint>)newValue);
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
			case MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS:
				getBendPoints().clear();
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
			case MetaEditorPersistencePackage.BENDABLE_ELEMENT_POSITION__BEND_POINTS:
				return bendPoints != null && !bendPoints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BendableElementPositionImpl
